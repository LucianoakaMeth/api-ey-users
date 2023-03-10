package cl.ey.exercise.utilities.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionHandlerResponseTest {

  @Test
  public void getMessage() {
    final ExceptionHandlerResponse<String> exceptionHandlerResponse =
        new ExceptionHandlerResponse<>("CustomException");

    assertNotNull(exceptionHandlerResponse);
  }
}
