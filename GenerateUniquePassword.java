import java.util.random.RandomGenerator;

public class GenerateUniquePassword {
  
  // Declare the class variable (no longer assigning it to an undefined variable)
  public static String accountPassword;
  
  public void generatePasscode() {
    // 1. Initialize the RandomGenerator instance using the modern Java 17+ factory
    RandomGenerator generator = RandomGenerator.getDefault();

    // 2. Generate the random number between 100,000 and 999,999
    int passcodeGenerator = generator.nextInt(100000, 1000000);

    // 3. Assign the converted value to the static class variable
    accountPassword = String.valueOf(passcodeGenerator);
  }
}
