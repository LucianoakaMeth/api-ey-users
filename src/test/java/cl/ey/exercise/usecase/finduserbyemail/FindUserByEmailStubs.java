package cl.ey.exercise.usecase.finduserbyemail;

import cl.ey.exercise.utilities.formats.LoadStubs;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailRequest;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FindUserByEmailStubs {
  public FindUserByEmailStubs() {}

  public static FindUserByEmailResponse getFindUserByEmailResponse() throws IOException {
    return new ObjectMapper()
        .readValue(
            LoadStubs.getStubs("find-user-by-email-response.json"),
            new TypeReference<FindUserByEmailResponse>() {});
  }

  public static FindUserByEmailRequest getFindUserByEmailRequest() throws IOException {
    return new ObjectMapper()
        .readValue(
            LoadStubs.getStubs("find-user-by-email-request.json"),
            new TypeReference<FindUserByEmailRequest>() {});
  }
}
