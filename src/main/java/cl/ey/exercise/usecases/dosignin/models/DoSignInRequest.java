package cl.ey.exercise.usecases.dosignin.models;

import cl.ey.exercise.utilities.AppConstant;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DoSignInRequest implements Serializable {

  private static final long serialVersionUID = -4496080854528033222L;

  @NotNull(message = AppConstant.NAME_NULL_ERROR_MESSAGE)
  @NotBlank(message = AppConstant.NAME_EMPTY_ERROR_MESSAGE)
  private String name;

  @NotNull(message = AppConstant.EMAIL_NULL_ERROR_MESSAGE)
  @NotBlank(message = AppConstant.EMAIL_EMPTY_ERROR_MESSAGE)
  @Email(message = AppConstant.EMAIL_FORMAT_ERROR_MESSAGE)
  private String email;

  @NotNull(message = AppConstant.CREDENTIALS_NULL_ERROR_MESSAGE)
  @NotBlank(message = AppConstant.CREDENTIALS_EMPTY_ERROR_MESSAGE)
  @Pattern(regexp = AppConstant.PATTERN_CREDENTIALS, message = AppConstant.CREDENTIALS_FORMAT_ERROR_MESSAGE)
  private String password;

  @Valid
  @NotNull(message = AppConstant.PHONES_NULL_ERROR_MESSAGE)
  @NotEmpty(message = AppConstant.PHONES_EMPTY_ERROR_MESSAGE)
  private List<Phone> phones;

  public DoSignInRequest() {}

  public DoSignInRequest(
      final String name, final String email, final String password, final List<Phone> phones) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final DoSignInRequest that = (DoSignInRequest) o;
    return Objects.equals(getName(), that.getName())
        && Objects.equals(getEmail(), that.getEmail())
        && Objects.equals(getPassword(), that.getPassword())
        && Objects.equals(getPhones(), that.getPhones());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getEmail(), getPassword(), getPhones());
  }

  @Override
  public String toString() {
    return "DoSignInRequest{"
        + "name='"
        + getName()
        + '\''
        + ", email='"
        + getEmail()
        + '\''
        + ", password='"
        + getPassword()
        + '\''
        + ", phones="
        + getPhones()
        + '}';
  }
}
