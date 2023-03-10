package cl.ey.exercise.usecase.dosignin;

import cl.ey.exercise.Controller;
import cl.ey.exercise.ServiceFacade;
import cl.ey.exercise.data.EYRepository;
import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.usecases.dosignin.DoSignInUseCase;
import cl.ey.exercise.usecases.finduserbyemail.FindUserByEmailUseCase;
import cl.ey.exercise.usecases.getusers.GetUsersUseCase;
import cl.ey.exercise.utilities.jwt.JwtTokenProvider;
import cl.ey.exercise.usecases.dosignin.models.DoSignInResponse;
import cl.ey.exercise.utilities.exceptions.ExceptionHandlerResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static cl.ey.exercise.usecase.UserStubs.getUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class DoSignInTest {

  @Mock private GetUsersUseCase getUsersUseCase;
  @Mock private FindUserByEmailUseCase findUserByEmailUseCase;
  @Mock private EYRepository globalLogicRepository;
  @MockBean AuthenticationManager authenticationManager;
  @MockBean
  JwtTokenProvider jwtTokenProvider;

  private Controller globalLogicController;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Before
  public void setup() throws IOException {

    final DoSignInUseCase doSignInUseCase =
        new DoSignInUseCase(
            authenticationManager, jwtTokenProvider, globalLogicRepository, passwordEncoder());

    final ServiceFacade globalLogicServiceFacade =
        new ServiceFacade(doSignInUseCase, getUsersUseCase, findUserByEmailUseCase);

    globalLogicController = new Controller(globalLogicServiceFacade);

    final User user =
        new User(
            getUser().getId(),
            getUser().getName(),
            getUser().getEmail(),
            getUser().getPassword(),
            getUser().getPhones(),
            getUser().getCreated(),
            getUser().getModified(),
            getUser().getLastLogin(),
            getUser().getToken(),
            getUser().getRoles(),
            getUser().isActive());
    when(globalLogicRepository.save(any(User.class))).thenReturn(user);
    when(globalLogicRepository.findByEmail(any(String.class))).thenReturn(user);
    when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
        .thenReturn(
            new UsernamePasswordAuthenticationToken(
                DoSignInStubs.getDoSignInRequest().getEmail(), DoSignInStubs.getDoSignInRequest().getPassword()));
    when(globalLogicRepository.updateUser(
            any(String.class), any(String.class), any(String.class), any(String.class)))
        .thenReturn(1);
    when(jwtTokenProvider.createToken(any(), any())).thenReturn(DoSignInStubs.getDoSignInResponse().getToken());
  }

  @Test
  public void itShouldDoSignInWhenApiSuccess() throws IOException {
    assertNotNull(DoSignInStubs.getDoSignInRequest());

    final DoSignInResponse doSignInResponse = globalLogicController.doSignIn(DoSignInStubs.getDoSignInRequest());

    assertNotNull(DoSignInStubs.getDoSignInResponse());
    assertNotNull(doSignInResponse);
    assertEquals(
        doSignInResponse,
        new DoSignInResponse(
            DoSignInStubs.getDoSignInResponse().getId(),
            DoSignInStubs.getDoSignInResponse().getCreated(),
            DoSignInStubs.getDoSignInResponse().getModified(),
            DoSignInStubs.getDoSignInResponse().getLastLogin(),
            DoSignInStubs.getDoSignInResponse().getToken(),
            DoSignInStubs.getDoSignInResponse().isActive()));
  }

  @Test
  public void itShouldDoSignInWhenApiFailure() throws IOException {
    assertNotNull(DoSignInStubs.getDoSignInRequest());
    try {
      globalLogicController.doSignIn(null);
    } catch (NullPointerException ex) {
      assertEquals(new ExceptionHandlerResponse<>(null).getMessage(), ex.getMessage());
    }
  }
}
