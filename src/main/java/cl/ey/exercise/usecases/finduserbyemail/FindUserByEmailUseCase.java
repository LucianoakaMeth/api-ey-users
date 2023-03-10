package cl.ey.exercise.usecases.finduserbyemail;

import cl.ey.exercise.data.EYRepository;
import cl.ey.exercise.data.dtos.User;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailRequest;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static cl.ey.exercise.utilities.AppConstant.USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE;

@Service
public class FindUserByEmailUseCase {

  private EYRepository globalLogicRepository;
  private final Logger logsFindUserByEmailUseCase;

  @Autowired
  public FindUserByEmailUseCase(final EYRepository globalLogicRepository) {
    this.globalLogicRepository = globalLogicRepository;
    this.logsFindUserByEmailUseCase = LogManager.getLogger(FindUserByEmailUseCase.class);
  }

  public FindUserByEmailResponse findUserByEmail(
      final FindUserByEmailRequest findUserByEmailRequest) {
    // Do log class
    logsFindUserByEmailUseCase.info(
        "Here I Am: Class:FindUserByEmailUseCase, Method: findUserByEmail, Message: {}",
        findUserByEmailRequest);
    // Do find email user
    final User user = globalLogicRepository.findByEmail(findUserByEmailRequest.getEmail());
    // Do log find email user
    logsFindUserByEmailUseCase.info(
        "Here I Am: Class:FindUserByEmailUseCase, Method: findUserByEmail, Action: findUserByEmail, Message: {}",
        user);
    // Do exception user doesn't exist
    Objects.requireNonNull(user, USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE);
    // Do create response find user by email
    final FindUserByEmailResponse findUserByEmailResponse =
        new FindUserByEmailResponse(
            user.getId(),
            user.getCreated(),
            user.getModified(),
            user.getLastLogin(),
            user.getToken(),
            user.isActive());
    // Do log response sign in user
    logsFindUserByEmailUseCase.info(
        "Here I Am: Class:FindUserByEmailUseCase, Method: findUserByEmail, Action: create response, Message: {}",
        findUserByEmailResponse);
    // return response
    return findUserByEmailResponse;
  }
}
