package cl.ey.exercise.usecase.getusers;

import cl.ey.exercise.utilities.formats.LoadStubs;
import cl.ey.exercise.usecases.getusers.models.GetUsersResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class GetUsersStubs {
  public GetUsersStubs() {}

  public static GetUsersResponse getGetUsersResponse() throws IOException {
    return new ObjectMapper()
        .readValue(
            LoadStubs.getStubs("get-users-response.json"),
            new TypeReference<GetUsersResponse>() {});
  }
}
