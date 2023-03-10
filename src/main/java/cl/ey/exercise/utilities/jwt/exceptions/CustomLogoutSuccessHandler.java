package cl.ey.exercise.utilities.jwt.exceptions;

import cl.ey.exercise.utilities.AppConstant;
import cl.ey.exercise.utilities.formats.HandlerMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler, Serializable {

  private static final long serialVersionUID = -7033940199937833003L;

  public CustomLogoutSuccessHandler() {}

  @Override
  public void onLogoutSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {

    HandlerMessage.formatMessageException(response, HttpServletResponse.SC_OK, AppConstant.SUCCESS_LOGOUT_MESSAGE);
  }
}
