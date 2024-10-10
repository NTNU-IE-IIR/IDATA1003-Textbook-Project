package org.bluej.animalmonitor.ui;

import java.util.Scanner;
import org.bluej.animalmonitor.data.Sighting;
import org.bluej.animalmonitor.logic.AnimalMonitor;

/**
 * A simple application for monitoring animal sightings.
 */
public class AnimalMonitorApp {

  private AnimalMonitor animalMonitor;
  private static final String VERSION = "v3.1";



  /**
   * Display a welcome message on the terminal.
   */
  private void displayWelcomeText() {
    System.out.println("Welcome to the Animal Monitor " + VERSION);
    System.out.println("==============================");
    System.out.println();
    System.out.println("This application allows you to enter and view data about animals");
    System.out.println("and the areas in which they have been sighted.");
    System.out.println();
  }

  /**
   * Allow the user to enter a new sighting.
   */
  private void enterNewSighting() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the animal type:");
    String animal = scanner.nextLine();
    System.out.println("Enter the spotter ID:");
    int spotter = scanner.nextInt();
    System.out.println("Enter the number seen:");
    int count = scanner.nextInt();
    System.out.println("Enter the area ID:");
    int area = scanner.nextInt();
    System.out.println("Enter the reporting period:");
    int period = scanner.nextInt();
    Sighting sighting = new Sighting(animal, spotter, count, area, period);
    this.animalMonitor.addSighting(sighting);
  }

  /**
   * Allow the user to enter a specific animal to show sightings of.
   */
  private void viewSightingsOfAnimal() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the animal type:");
    String animal = scanner.nextLine();
    System.out.println("Sightings of " + animal);
    this.animalMonitor.printSightingsOf(animal);
  }

  /**
   * Allow the user to enter a specific spotter to show sightings by.
   */
  private void viewSightingsBySpotterId() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the spotter ID:");
    int spotter = scanner.nextInt();
    System.out.println("Sightings by spotter " + spotter);
    this.animalMonitor.printSightingsBy(spotter);
  }

  /**
   * Allow the user to enter a specific spotter to show list of animals
   * sighted by the specified spotter.
   */
  private void viewAnimalsBySpotterId() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the spotter ID:");
    int spotter = scanner.nextInt();
    System.out.println("Animals sighted by spotter " + spotter);
    this.animalMonitor.printSightingsBySpotter(spotter);
  }

  /**
   * Display the main menu, and get the user's choice.
   *
   * @return The user's choice.
   */
  private int displayMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n\nMain Menu");
    System.out.println("=========");
    System.out.println();
    System.out.println("1. Enter new sighting");
    System.out.println("2. View sightings by animal type");
    System.out.println("3. View sightings by spotter ID");
    System.out.println("4. View names of animals sighted by spotter ID");
    System.out.println("5. Print all sightings");
    System.out.println("6. Quit");
    System.out.println("Please select an option:");
    int option = 0;
    if (scanner.hasNextInt()) {
      option = scanner.nextInt();
      scanner.nextLine();
    } else {
      System.out.println("Must be a number.");
    }

    return option;
  }

  /**
   * The main starting point of the applications.
   * Displays a welcome text, and a menu.
   */
  public void start() {
    boolean finished = false;
    displayWelcomeText();
    while (!finished) {
      int menuChoice = displayMenu();
      switch (menuChoice) {
        case 1:
          System.out.println("Enter a new sighting");
          this.enterNewSighting();
          break;
        case 2:
          System.out.println("View sightings by animal type");
          this.viewSightingsOfAnimal();
          break;
        case 3:
          System.out.println("View sightings by spotter ID");
          this.viewSightingsBySpotterId();
          break;
        case 4:
          System.out.println("View names of animals sighted by spotter ID");
          this.viewAnimalsBySpotterId();
          break;
        case 5:
          System.out.println("List of all sightings\n");
          this.animalMonitor.printList();
          break;
        case 6:
          System.out.println("Thank you for using the Animal Monitor");
          finished = true;
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  /**
   * Creates a new instance of the AnimalMonitorApp.
   */
  public AnimalMonitorApp() {
    this.animalMonitor = new AnimalMonitor();
    this.animalMonitor.addSightings("sightings.csv");
  }

}
