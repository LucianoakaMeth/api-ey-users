package cl.ey.exercise.usecase.finduserbyemail;

import cl.ey.exercise.ProtectedController;
import cl.ey.exercise.ServiceFacade;
import cl.ey.exercise.data.EYRepository;
import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.usecases.dosignin.DoSignInUseCase;
import cl.ey.exercise.usecases.finduserbyemail.FindUserByEmailUseCase;
import cl.ey.exercise.usecases.getusers.GetUsersUseCase;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailResponse;
import cl.ey.exercise.utilities.exceptions.ExceptionHandlerResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static cl.ey.exercise.usecase.UserStubs.getUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class FindUserByEmailTest {

  @Mock private DoSignInUseCase doSignInUseCase;
  @Mock private GetUsersUseCase getUsersUseCase;
  @Mock private EYRepository globalLogicRepository;

  private ProtectedController globalLogicProtectedController;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Before
  public void setup() throws IOException {

    final FindUserByEmailUseCase findUserByEmailUseCase =
        new FindUserByEmailUseCase(globalLogicRepository);

    final ServiceFacade globalLogicServiceFacade =
        new ServiceFacade(doSignInUseCase, getUsersUseCase, findUserByEmailUseCase);

    globalLogicProtectedController = new ProtectedController(globalLogicServiceFacade);

    when(globalLogicRepository.findByEmail(any(String.class)))
        .thenReturn(
            new User(
                getUser().getId(),
                getUser().getCreated(),
                getUser().getModified(),
                getUser().getLastLogin(),
                getUser().getToken(),
                getUser().isActive()));
  }

  @Test
  public void itShouldFindUserByEmailWhenApiSuccess() throws IOException {
    assertNotNull(FindUserByEmailStubs.getFindUserByEmailRequest());

    final FindUserByEmailResponse findUserByEmailResponse =
        globalLogicProtectedController.findUserByEmail(FindUserByEmailStubs.getFindUserByEmailRequest());

    assertNotNull(FindUserByEmailStubs.getFindUserByEmailResponse());
    assertNotNull(findUserByEmailResponse);
    assertEquals(findUserByEmailResponse, FindUserByEmailStubs.getFindUserByEmailResponse());
  }

  @Test
  public void itShouldFindUserByEmailWhenApiFailure() throws IOException {
    assertNotNull(FindUserByEmailStubs.getFindUserByEmailRequest());
    try {
      globalLogicProtectedController.findUserByEmail(null);
    } catch (NullPointerException ex) {
      assertEquals(new ExceptionHandlerResponse<>(null).getMessage(), ex.getMessage());
    }
  }
}
