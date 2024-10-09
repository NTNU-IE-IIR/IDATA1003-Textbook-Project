package org.bluej.animalmonitor.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.bluej.animalmonitor.data.Sighting;

/**
 * A class to read CSV-style records of animal sighting reports.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class SightingReader {
  // How many fields are expected.
  private static final int NUMBER_OF_FIELDS = 5;
  // Index values for the fields in each record.
  private static final int SPOTTER = 0;
  private static final int ANIMAL = 1;
  private static final int COUNT = 2;
  private static final int AREA = 3;
  private static final int PERIOD = 4;

  /**
   * Create a SightingReader.
   */
  public SightingReader() {
    // Intentionally left empty
  }

  /**
   * Read sightings in CSV format from the given file.
   * Return an ArrayList of Sighting objects created from
   * the information in the file.
   *
   * @param filename The file to be read - should be in CSV format.
   * @return A list of Sightings.
   */
  public ArrayList<Sighting> getSightings(String filename) {
    // Create a Sighting from a CSV input line.
    Function<String, Sighting> createSighting =
        sighting -> {
          String[] parts = sighting.split(",");
          if (parts.length == NUMBER_OF_FIELDS) {
            try {
              int spotter = Integer.parseInt(parts[SPOTTER].trim());
              String animal = parts[ANIMAL].trim();
              int count = Integer.parseInt(parts[COUNT].trim());
              int area = Integer.parseInt(parts[AREA].trim());
              int period = Integer.parseInt(parts[PERIOD].trim());
              return new Sighting(animal, spotter, count, area, period);
            } catch (NumberFormatException e) {
              System.out.println("Sighting record has a malformed integer: " + sighting);
              return null;
            }
          } else {
            System.out.println("Sighting record has the wrong number of fields: " + sighting);
            return null;
          }
        };
    ArrayList<Sighting> sightings;
    try {
      sightings = Files.lines(Paths.get(filename))
          .filter(sighting -> sighting.length() > 0 && sighting.charAt(0) != '#')
          .map(createSighting)
          .filter(sighting -> sighting != null)
          .collect(Collectors.toCollection(ArrayList::new));
    } catch (IOException e) {
      System.out.println("Unable to open " + filename);
      sightings = new ArrayList<>();
    }
    return sightings;
  }
}
