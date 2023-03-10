package cl.ey.exercise;

import cl.ey.exercise.usecases.dosignin.DoSignInUseCase;
import cl.ey.exercise.usecases.finduserbyemail.FindUserByEmailUseCase;
import cl.ey.exercise.usecases.getusers.GetUsersUseCase;
import cl.ey.exercise.usecases.getusers.models.GetUsersResponse;
import cl.ey.exercise.usecases.dosignin.models.DoSignInRequest;
import cl.ey.exercise.usecases.dosignin.models.DoSignInResponse;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailRequest;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade implements EYService {

  // region field
  private final DoSignInUseCase doSignInUseCase;
  private final GetUsersUseCase getUsersUseCase;
  private final FindUserByEmailUseCase findUserByEmailUseCase;
  // endregion

  @Autowired
  public ServiceFacade(
      final DoSignInUseCase doSignInUseCase,
      final GetUsersUseCase getUsersUseCase,
      final FindUserByEmailUseCase findUserByEmailUseCase) {
    this.doSignInUseCase = doSignInUseCase;
    this.getUsersUseCase = getUsersUseCase;
    this.findUserByEmailUseCase = findUserByEmailUseCase;
  }

  @Override
  public DoSignInResponse doSignIn(final DoSignInRequest doSignInRequest) {
    // Redirect to doSignInUseCase
    return doSignInUseCase.doSignIn(doSignInRequest);
  }

  @Override
  public GetUsersResponse getUsers() {
    // Redirect to doGetUsers
    return getUsersUseCase.getUsers();
  }

  @Override
  public FindUserByEmailResponse findUserByEmail(FindUserByEmailRequest findUserByEmailRequest) {
    // Redirect to findUserByEmail
    return findUserByEmailUseCase.findUserByEmail(findUserByEmailRequest);
  }
}
