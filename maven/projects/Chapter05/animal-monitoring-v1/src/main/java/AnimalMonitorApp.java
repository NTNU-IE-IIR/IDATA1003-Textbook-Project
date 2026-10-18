import java.util.ArrayList;
import java.util.List;

/**
 * Small application that tries out the AnimalMonitor with sightings
 * found in the file "sightings.csv".
 */
public class AnimalMonitorApp
{
    /**
     * Create a monitor, record some sightings and print results.
     * @param args Not used.
     */
    public static void main(String[] args)
    {
        AnimalMonitor monitor = new AnimalMonitor();
        // Sighting(animal, spotter, count, area, period)
        monitor.addSightings("sightings.csv");

        System.out.println("All sightings:");
        monitor.printList();

        System.out.println("\nSightings of Elk:");
        monitor.printSightingsOf("Elk");

        System.out.println("\nSightings by spotter 1:");
        monitor.printSightingsBy(1);

        System.out.println("\nTotal Elk count: " + monitor.getCount("Elk"));

        System.out.println("\nEndangered (threshold 1):");
        monitor.printEndangered(new ArrayList<>(List.of("Elk", "Lynx", "Wolf")), 1);

        monitor.removeZeroCounts();
        System.out.println("\nAfter removing zero counts:");
        monitor.printList();
    }
}
