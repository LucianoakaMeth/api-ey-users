package cl.ey.exercise.usecases.getusers;

import cl.ey.exercise.data.EYRepository;
import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.usecases.getusers.models.GetUsersResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static cl.ey.exercise.utilities.AppConstant.USERS_DOES_NOT_EXIST_EXCEPTION_MESSAGE;

@Service
public class GetUsersUseCase {

  // region fields
  private final Logger logsDoGetUsersUseCase;
  private final EYRepository globalLogicRepository;
  // endregion

  @Autowired
  public GetUsersUseCase(final EYRepository globalLogicRepository) {
    this.logsDoGetUsersUseCase =
        LogManager.getLogger(GetUsersUseCase.class);
    this.globalLogicRepository = globalLogicRepository;
  }

  public GetUsersResponse getUsers() {
    // Do log class
    logsDoGetUsersUseCase.info("Here I Am: Class:DoGetUsersUseCase, Method: findUserByEmail");
    // Do find users
    final List<User> users = globalLogicRepository.findAll();
    // Do exception users doesn't exist
    Objects.requireNonNull(users, USERS_DOES_NOT_EXIST_EXCEPTION_MESSAGE);
    // Do log class
    logsDoGetUsersUseCase.info(
        "Here I Am: Class:DoGetUsersUseCase, Method: findUserByEmail, Action: Success Find Users");
    // return response
    return new GetUsersResponse(globalLogicRepository.findAll());
  }
}
