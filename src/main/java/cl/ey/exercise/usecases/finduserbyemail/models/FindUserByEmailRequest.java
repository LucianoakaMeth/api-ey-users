package cl.ey.exercise.usecases.finduserbyemail.models;

import cl.ey.exercise.utilities.AppConstant;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindUserByEmailRequest implements Serializable {

  private static final long serialVersionUID = 7258072125495513517L;

  @NotNull(message = AppConstant.EMAIL_NULL_ERROR_MESSAGE)
  @NotBlank(message = AppConstant.EMAIL_EMPTY_ERROR_MESSAGE)
  @Email(message = AppConstant.EMAIL_FORMAT_ERROR_MESSAGE)
  private String email;

  public FindUserByEmailRequest() {}

  public FindUserByEmailRequest(final String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "FindUserByEmailRequest{" + "email='" + getEmail() + '\'' + '}';
  }
}
