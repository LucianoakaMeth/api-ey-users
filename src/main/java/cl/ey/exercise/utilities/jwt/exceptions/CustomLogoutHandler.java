package cl.ey.exercise.utilities.jwt.exceptions;

import cl.ey.exercise.data.EYRepository;
import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.utilities.AppConstant;
import cl.ey.exercise.utilities.jwt.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class CustomLogoutHandler implements LogoutHandler, Serializable {

  private static final long serialVersionUID = -3409865897460953769L;

  private final transient JwtTokenProvider jwtTokenProvider;
  private final transient EYRepository globalLogicRepository;

  public CustomLogoutHandler(
      final JwtTokenProvider jwtTokenProvider, EYRepository globalLogicRepository) {
    this.globalLogicRepository = globalLogicRepository;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void logout(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    String tokenSearch = request.getHeader(AppConstant.NAME_TOKEN_SESSION);
    final User findEmail = globalLogicRepository.findUserByToken(tokenSearch);
    final String updateToken =
        jwtTokenProvider.revocateToken(
            jwtTokenProvider.getUsername(tokenSearch), findEmail.getRoles());
    globalLogicRepository.revocateToken(tokenSearch, updateToken);
  }
}
