import java.util.random.RandomGenerator;
import java.time.LocalTime;
import java.time.ZoneId; // Added for timezone support
import java.io.File;

public class Main {
  
    public static String userFirstName = "null";
    public static String userLastName = "null";
    public static String age = "null";
    public static String birthday = "null";
    private boolean isDeveloper = false;

  public void main() throws InterruptedException {
    
    String input = "null";
    String input2 = "null";
    String developerInput = "null";
    String devPasscode = "null";

    boolean loggedOut = true;

    // imports from other files
    LoginMethod loginMethod = new LoginMethod();
    GenerateUniquePassword password = new GenerateUniquePassword();
    UpdateAccountFiles accountFiles = new UpdateAccountFiles();

    System.out.println("THUNDERHEAD V1.1 INDEV BUILD 1\n");

    while (loggedOut == true && isDeveloper == false) {
      IO.println("Login or register account");
      input = IO.readln();

      if ("register".equalsIgnoreCase(input)) {

        IO.println("First name: ");
        userFirstName = IO.readln();

        IO.println("Last name: ");
        userLastName = IO.readln();

        IO.println("Age: ");
        age = IO.readln();

        IO.println("Birthday: ");
        birthday = IO.readln();

        password.generatePasscode();
        IO.println("Account registered. Welcome " + userFirstName + ". Your passcode is " + GenerateUniquePassword.accountPassword + ".");

        accountFiles.updateAccountFiles();
        loggedOut = false;
    
      } else if ("login".equalsIgnoreCase(input)) {
        
        
        loginMethod.login();
      
      
      } else if ("override".equalsIgnoreCase(input)) {
 
        IO.println("Enter developer mode password: ");
        devPasscode = IO.readln();

        if ("3647".equalsIgnoreCase(devPasscode)) {

          IO.println("Developer mode enabled.");
          isDeveloper = true;

        } else {

          IO.println("Incorrect passcode. Terminating program...");
          IO.println("Program terminated.");

        }
      }
    } 

    while (loggedOut == false) {
      LocalTime now = LocalTime.now(ZoneId.of("America/Los_Angeles"));
      int hour = now.getHour();

      String timeOfDay;
      
      // Fixed logic to cover all hours and avoid "null" or wrong times
      if (hour >= 5 && hour < 12) {
          timeOfDay = "morning";
      } else if (hour >= 12 && hour < 17) {
          timeOfDay = "afternoon";
      } else if (hour >= 17 && hour < 21) {
          timeOfDay = "evening";
      } else {
          timeOfDay = "night";
      }

      IO.println("\nGood " + timeOfDay + " " + userFirstName + ", how may I assist you today?");
      input2 = IO.readln();
    }

    
    //dev mode logic
    if (isDeveloper == true) {
      while(true) {

        IO.println("Enter developer command: ");
        developerInput = IO.readln();

        if ("/builds".equalsIgnoreCase(developerInput)) {

          

        } else if ("system".equalsIgnoreCase(developerInput)) {

        // 1. Operating System Details
        IO.println("\n=== Operating System ===");
        IO.println("OS Name: " + System.getProperty("os.name"));
        IO.println("OS Architecture: " + System.getProperty("os.arch"));
        IO.println("OS Version: " + System.getProperty("os.version"));
        IO.println("User Name: " + System.getProperty("user.name"));

        // 2. CPU / Processor Info
        IO.println("\n=== CPU ===");
        int totalCores = Runtime.getRuntime().availableProcessors();
        IO.println("Available Processors (Cores): " + totalCores);

        // 3. Memory Specs (JVM-allocated limits)
        IO.println("\n=== JVM Memory ===");
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        IO.println("Max Memory: " + (maxMemory / (1024 * 1024)) + " MB");
        IO.println("Total Allocated Memory: " + (totalMemory / (1024 * 1024)) + " MB");
        IO.println("Free Allocated Memory: " + (freeMemory / (1024 * 1024)) + " MB");

        // 4. Disk Storage Space
        IO.println("\n=== Disk Storage ===");
        File root = new File("/");
        IO.println("Total Space: " + (root.getTotalSpace() / (1024 * 1024 * 1024)) + " GB");
        IO.println("Free Space: " + (root.getFreeSpace() / (1024 * 1024 * 1024)) + " GB");
        IO.println("Usable Space: " + (root.getUsableSpace() / (1024 * 1024 * 1024)) + " GB");
        
        // 5. Java Environment
        IO.println("\n=== Java Runtime ===");
        IO.println("Java Version: " + System.getProperty("java.version"));
        IO.println("Java Vendor: " + System.getProperty("java.vendor"));

        }

      }
    }
  }
}

