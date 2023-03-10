package cl.ey.exercise.utilities;

public class AppConstant {

  // region constants

  // Validations Errors
  public static final String SESSION_EXCEPTION_MESSAGE = "Invalid token or session expired.";
  public static final String ACCESS_DENIED_EXCEPTION_MESSAGE = "Access denied in this area";
  public static final String USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE = "User doesn't exist.";
  public static final String USERS_DOES_NOT_EXIST_EXCEPTION_MESSAGE = "Users doesn't exist.";
  public static final String CONSTRAINT_EMAIL_VIOLATION_EXCEPTION_MESSAGE = "Email already exist.";
  public static final String INTERNAL_SERVER_ERROR_EXCEPTION_MESSAGE =
      "In this moment we can't respond. Please try later or contact us(call contact center).";
  public static final String EMAIL_FORMAT_ERROR_MESSAGE = "Enter a valid email address.Example : email@email.com";
  public static final String CREDENTIALS_FORMAT_ERROR_MESSAGE =
      "Invalid Format Password.The pattern to create the password most be first one capital letter, then lower case letters, and last two numbers from zero to nine. Example 'Password22'.";

  // Null Field Error
  public static final String EMAIL_NULL_ERROR_MESSAGE = "email cannot be null.";
  public static final String NAME_NULL_ERROR_MESSAGE = "name cannot be null.";
  public static final String CREDENTIALS_NULL_ERROR_MESSAGE = "password cannot be null.";
  public static final String PHONES_NULL_ERROR_MESSAGE = "phones cannot be null.";
  public static final String NUMBER_NULL_ERROR_MESSAGE = "number cannot be null.";
  public static final String CITYWIDE_NULL_ERROR_MESSAGE = "city_code cannot be null.";
  public static final String COUNTRYSIDE_NULL_ERROR_MESSAGE = "country_code cannot be null.";

  // Empty Field Error
  public static final String EMAIL_EMPTY_ERROR_MESSAGE = "email is required.";
  public static final String NAME_EMPTY_ERROR_MESSAGE = "name is required.";
  public static final String CREDENTIALS_EMPTY_ERROR_MESSAGE = "password is required.";
  public static final String PHONES_EMPTY_ERROR_MESSAGE = "phones is required.";
  public static final String NUMBER_EMPTY_ERROR_MESSAGE = "number is required.";
  public static final String CITYWIDE_EMPTY_ERROR_MESSAGE = "city_code is required.";
  public static final String COUNTRYSIDE_EMPTY_ERROR_MESSAGE = "country_code is required.";

  // Patterns
  public static final String PATTERN_CREDENTIALS = "^([A-Z]{1})([a-z].*)([0-9]{2})";

  // Url Apis
  public static final String API_REST_UNPROTECTED_DOSIGNIN = "/v1/unprotected/doSignIn";
  public static final String API_REST_PROTECTED_GETUSERS = "/v1/protected/getUsers";
  public static final String API_REST_PROTECTED_FIND_USER_BY_EMAIL = "/v1/protected/findUserByEmail";
  public static final String API_REST_PROTECTED_DOSIGNOUT = "/v1/protected/doSignOut";

  // Roles
  public static final String ROL_ADMIN = "ROLE_ADMIN";
  public static final String ROL_USER = "ROLE_USER";
  public static final String HAS_ROL_USER = "USER";
  public static final String HAS_ROL_ADMIN = "ADMIN";

  // Others
  public static final long EXPIRED_TIME_TOKEN_SESSION = 300000;
  public static final String NAME_TOKEN_SESSION = "Token";
  public static final String FORMAT_MESSAGE_JWT = "{\"message\": \"%s\"}";
  public static final String TYPE_MESSAGE_JWT = "application/json";
  public static final String CHARACTER_ENCODING_MESSAGE_JWT = "UTF-8";
  public static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
  public static final String SUCCESS_LOGOUT_MESSAGE = "Success logout, have a great day.";

  // endregion

  public AppConstant() {}
}
