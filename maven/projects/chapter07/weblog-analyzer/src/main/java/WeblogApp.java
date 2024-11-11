/**
 * Represents the Weblog App. This is the starting point of the application.
 */
public class WeblogApp {
  /**
   * Starts the Weblog App.
   *
   * @param args commandline arguments.
   */
  public static void main(String[] args) {
    LogAnalyzer logAnalyzer = new LogAnalyzer();

    logAnalyzer.analyzeHourlyData();
    // Print the log from the file
    System.out.println("\nThe data from the log: ");
    logAnalyzer.printData();
    System.out.println("\nResult of the analysis: ");
    logAnalyzer.printHourlyCounts();

  }
}
