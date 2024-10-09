import java.util.Scanner;

/**
 * The main entry point for starting the application.
 */
public class Main {
  /**
   * The main entry point for starting the application.
   *
   * @param args arguments that might have been given from the commandline upon starting
   */
  public static void main(String[] args) {
    String sightingsFile = "sightings.csv";

    // Create the AnimalMonitor instance
    AnimalMonitor animalMonitor = new AnimalMonitor();
    // Read sightings from the file
    animalMonitor.addSightings(sightingsFile);
    // Print all the sightings
    System.out.println("Sightings read from the file "
        + sightingsFile);
    System.out.println("\nList of sightings:");
    animalMonitor.printList();

    // List sightings of a specific animal
    System.out.println("\nPlease enter name of animal to list: ");
    Scanner inputReader = new Scanner(System.in);
    String animal = inputReader.next();
    System.out.println("Sightings of " + animal);
    animalMonitor.printSightingsOf(animal);
    System.out.println("\nThe " + animal
        + " has been sighted "
        + animalMonitor.getCount(animal)
        + " times in total.");
  }
}
