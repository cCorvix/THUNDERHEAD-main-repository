public class LoginMethod {
  public void login() {
    
    String userFirstNameCheck = "null";
    String userLastNameCheck = "null";
    String passwordCheck = "null";

    IO.println("First name: ");
    userFirstNameCheck = IO.readln();

    IO.println("Last name: ");
    userLastNameCheck = IO.readln();

    IO.println("Password: ");
    passwordCheck = IO.readln();

    //login specs for user: Quinn Coffee
    if ("quinn".equalsIgnoreCase(userFirstNameCheck)) {
      if ("coffee".equalsIgnoreCase(userLastNameCheck)) {
        if ("784436".equals(passwordCheck)) {



        }
      }
    }

  }

  public void logNewUserToInfoStorage() {

    

  }
}
