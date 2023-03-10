package cl.ey.exercise;

import cl.ey.exercise.usecases.getusers.models.GetUsersResponse;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailRequest;
import cl.ey.exercise.usecases.finduserbyemail.models.FindUserByEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/protected")
public class ProtectedController {

  // region fields
  private final ServiceFacade globalLogicServiceFacade;
  // endregion

  // region fields
  @Autowired
  public ProtectedController(final ServiceFacade globalLogicServiceFacade) {
    this.globalLogicServiceFacade = globalLogicServiceFacade;
  }
  // endregion

  //
  @RequestMapping(
      value = "/getUsers",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public GetUsersResponse getUsers() {
    return globalLogicServiceFacade.getUsers();
  }
  //
  @RequestMapping(
      value = "/findUserByEmail",
      method = RequestMethod.GET,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public FindUserByEmailResponse findUserByEmail(
      @RequestBody @Valid final FindUserByEmailRequest findUserByEmailRequest) {
    return globalLogicServiceFacade.findUserByEmail(findUserByEmailRequest);
  }
}
