package cl.ey.exercise.usecase;

import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.utilities.formats.LoadStubs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UserStubs {

  public UserStubs() {}

  public static User getUser() throws IOException {
    return new ObjectMapper()
        .readValue(LoadStubs.getStubs("user.json"), new TypeReference<User>() {});
  }
}
