package cl.ey.exercise.usecase.getusers;

import cl.ey.exercise.ProtectedController;
import cl.ey.exercise.ServiceFacade;
import cl.ey.exercise.data.EYRepository;
import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.usecases.dosignin.DoSignInUseCase;
import cl.ey.exercise.usecases.finduserbyemail.FindUserByEmailUseCase;
import cl.ey.exercise.usecases.getusers.GetUsersUseCase;
import cl.ey.exercise.usecases.getusers.models.GetUsersResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cl.ey.exercise.usecase.UserStubs.getUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetUsersTest {

  @Mock private DoSignInUseCase doSignInUseCase;
  @Mock private FindUserByEmailUseCase findUserByEmailUseCase;
  @Mock private EYRepository globalLogicRepository;

  private ProtectedController globalLogicProtectedController;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Before
  public void setup() throws IOException {

    final GetUsersUseCase getUsersUseCase = new GetUsersUseCase(globalLogicRepository);

    final ServiceFacade globalLogicServiceFacade =
        new ServiceFacade(doSignInUseCase, getUsersUseCase, findUserByEmailUseCase);

    globalLogicProtectedController = new ProtectedController(globalLogicServiceFacade);

    final List<User> listUser = new ArrayList<>();
    listUser.add(
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
            getUser().isActive()));

    when(globalLogicRepository.findAll()).thenReturn(listUser);
  }

  @Test
  public void itShouldDoGetUsersWhenApiSuccess() throws IOException {
    final GetUsersResponse getUsersResponse = globalLogicProtectedController.getUsers();

    assertNotNull(GetUsersStubs.getGetUsersResponse());
    assertNotNull(getUsersResponse);
    assertEquals(getUsersResponse, GetUsersStubs.getGetUsersResponse());
  }
}
