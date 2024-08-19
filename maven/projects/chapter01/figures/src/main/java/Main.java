/**
 * The sole purpose of this Main class is to run the program. All operating
 * systems expects to find one single method in the code named "main" that
 * takes an array of strings as a parameter and returns nothing.
 * This method is then used to start your application.
 */
public class Main {

  /**
   * The main method is the entry point of the program.
   *
   * @param args Any "arguments" provided from the commandline upon starting the program.
   */
  public static void main(String[] args) {
    Circle circle = new Circle();
    circle.makeVisible();
  }
}
