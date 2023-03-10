package cl.ey.exercise.utilities.jwt.models;

import cl.ey.exercise.utilities.AppConstant;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CustomUserDetailsTest {

  @Test
  public void customUserDetailsTest() {
    final CustomUserDetails customUserDetails =
        new CustomUserDetails(
            "usernameExample", "examplePassword", Arrays.asList(AppConstant.ROL_ADMIN, AppConstant.ROL_USER));
    assertEquals(customUserDetails, customUserDetails);
  }
}
