package org.bluej.animalmonitor.logic;

import java.util.ArrayList;
import java.util.Iterator;
import org.bluej.animalmonitor.data.Sighting;
import org.bluej.animalmonitor.util.SightingReader;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor {
  // Records of all the sightings of animals.
  private final java.util.ArrayList<Sighting> sightings;

  /**
   * Create an AnimalMonitor.
   */
  public AnimalMonitor() {
    this.sightings = new ArrayList<>();
  }

  /**
   * Add the sightings recorded in the given filename to the current list.
   *
   * @param filename A CSV file of Sighting records.
   */
  public void addSightings(String filename) {
    SightingReader reader = new SightingReader();
    sightings.addAll(reader.getSightings(filename));
  }

  /**
   * Add a sighting to the list.
   *
   * @param sighting The sighting to be added.
   */
  public void addSighting(Sighting sighting) {
    sightings.add(sighting);
  }

  private void printSightingDetails(Sighting sighting) {
    System.out.println(sighting.getAnimal() + " "
        + sighting.getCount() + " "
        + sighting.getSpotter() + " "
        + sighting.getArea() + " "
        + sighting.getPeriod()
    );
  }

  /**
   * Print details of all the sightings.
   *
   * <p>This is the "old" version where we use the traditional for-each-loop</p>
   * <p>Here we use <b>non-functional</b>-programming (or declarative programming)</p>
   */
  public void printListOld() {
    for (Sighting sighting : sightings) {
      System.out.println(sighting.getDetails());
    }
  }

  /**
   * Prints the complete list of sightings.
   *
   * <p>This version makes use of lambda-expressions and the {@code forEach()}
   * - method which is present in all collection-classes in Java (ArrayList, HashSet etc).
   *
   * <p>The lamda-expression in this method is in "full format", not the simplified, compressed
   * version
   */
  public void printList() {
    this.sightings.forEach(
        (Sighting sighting) ->
        {
          this.printSightingDetails(sighting);
        }
    );
  }

  /**
   * Prints a list of all sightings.
   * In this version of printList we use the most advanced
   * form of lambda-expressions, namely <b>method reference</b>.
   * Since the method <b>printSightingDetails()</b> takes an object of
   * Sighting as parameter, i.e. the lambda-parameter <b>sighting</b>
   * is sent directly as input to the <b>printSightingDetails()</b> -method,
   * we can <b>"reference"</b> the method directly.
   *
   * <p>The format for referencing an instance method is:
   *
   * <p>{@code this::printSightingDetails}
   *
   * <p>Note that we do not need the lambda-parameter {@code sighting} anymore.
   *
   * <p>NB!! THIS IS ADVANCED STUFF SO IF YOU DO NOT UNDERSTAND IT DO NOT USE I>!!!
   */
  public void printList2() {
    this.sightings.forEach(this::printSightingDetails);
  }

  /**
   * Find the first sighting of the given animal.
   *
   * @param animal The type of animal.
   * @return The first sighting of the animal.
   */
  public Sighting findFirstSightingOfAnimal(String animal) {
    Sighting foundSighting = null;

    Iterator<Sighting> it = this.sightings.iterator();

    boolean foundObject = false;
    while (it.hasNext() && !foundObject) {
      Sighting aSighting = it.next();
      if (aSighting.getAnimal().equals(animal)) {
        foundSighting = aSighting;
        foundObject = true;
      }
    }
    return foundSighting;
  }

  /**
   * Print the details of all the sightings of the given animal.
   *
   * @param animal The type of animal.
   */
  public void printSightingsOfOld(String animal) {
    for (Sighting sighting : sightings) {
      if (animal.equals(sighting.getAnimal())) {
        System.out.println(sighting.getDetails());
      }
    }
  }

  /**
   * Print the details of all the sightings of the given animal.
   *
   * <p>This version uses filter and lambda.
   *
   * @param animal The type of animal.
   */
  public void printSightingsOf(String animal) {
    this.sightings.stream()
        .filter((Sighting sighting) -> animal.equals(sighting.getAnimal()))
        .forEach((Sighting sighting) -> this.printSightingDetails(sighting));
  }

  /**
   * Print all the sightings by the given spotter.
   *
   * <p>This is the original version not using lambda and styreams.
   *
   * @param spotter The ID of the spotter.
   */
  public void printSightingsByOld(int spotter) {
    for (Sighting record : sightings) {
      if (record.getSpotter() == spotter) {
        System.out.println(record.getDetails());
      }
    }
  }

  /**
   * Print all the sightings by the given spotter.
   *
   * <p>This version uses filter and lambda.</p>
   *
   * @param spotter The ID of the spotter.
   */
  public void printSightingsBy(int spotter) {
    this.sightings.stream()
        .filter(sighting -> sighting.getSpotter() == spotter)
        .forEach(sighting -> this.printSightingDetails(sighting));
  }

  /**
   * Prints the names of all animals spotted by a given spotter.
   *
   * <p>A twist to the {@code printSightingsBy()}-method, using map
   * to map from Sighting to a String (the animal).</p>
   *
   * @param spotter the spotter to list sighted animals for.
   */
  public void printSightingsBySpotter(int spotter) {
    this.sightings.stream()
        .filter((Sighting sighting) -> sighting.getSpotter() == spotter)
        .map((Sighting sighting) -> sighting.getAnimal())
        .forEach((String animalName) -> System.out.println(animalName));
  }

  /**
   * Print a list of the types of animal considered to be endangered.
   *
   * @param animalNames     A list of animals names.
   * @param dangerThreshold Counts less-than or equal-to to this level
   *                        are considered to be dangerous.
   */
  public void printEndangered(ArrayList<String> animalNames,
                              int dangerThreshold) {
    for (String animal : animalNames) {
      if (getCount(animal) <= dangerThreshold) {
        System.out.println(animal + " is endangered.");
      }
    }
  }

  /**
   * Return a count of the number of sightings of the given animal.
   *
   * @param animal The type of animal.
   * @return The count of sightings of the given animal.
   */
  public int getCount(String animal) {
    int total = 0;
    for (Sighting sighting : sightings) {
      if (animal.equals(sighting.getAnimal())) {
        total = total + sighting.getCount();
      }
    }
    return total;
  }

  /**
   * Remove from the sightings list all of those records with
   * a count of zero.
   */
  public void removeZeroCounts() {
    Iterator<Sighting> it = sightings.iterator();
    while (it.hasNext()) {
      Sighting record = it.next();
      if (record.getCount() == 0) {
        it.remove();
      }
    }
  }

  /**
   * Return a list of all sightings of the given type of animal
   * in a particular area.
   *
   * @param animal The type of animal.
   * @param area   The ID of the area.
   * @return A list of sightings.
   */
  public ArrayList<Sighting> getSightingsInArea(String animal, int area) {
    ArrayList<Sighting> records = new ArrayList<>();
    for (Sighting record : sightings) {
      if (animal.equals(record.getAnimal())) {
        if (record.getArea() == area) {
          records.add(record);
        }
      }
    }
    return records;
  }

  /**
   * Return a list of all the sightings of the given animal.
   *
   * @param animal The type of animal.
   * @return A list of all sightings of the given animal.
   */
  public ArrayList<Sighting> getSightingsOf(String animal) {
    ArrayList<Sighting> filtered = new ArrayList<>();
    for (Sighting record : sightings) {
      if (animal.equals(record.getAnimal())) {
        filtered.add(record);
      }
    }
    return filtered;
  }
}
