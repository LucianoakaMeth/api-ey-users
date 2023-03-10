package cl.ey.exercise;

import cl.ey.exercise.usecases.dosignin.models.DoSignInResponse;
import cl.ey.exercise.usecases.getusers.models.GetUsersResponse;
import cl.ey.exercise.usecases.dosignin.models.DoSignInRequest;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailRequest;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailResponse;

public interface EYService {

  DoSignInResponse doSignIn(DoSignInRequest doSignInRequest);

  GetUsersResponse getUsers();

  FindUserByEmailResponse findUserByEmail(FindUserByEmailRequest findUserByEmailRequest);
}
