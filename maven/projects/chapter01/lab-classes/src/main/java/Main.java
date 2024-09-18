/**
 * The startingpoint of the application. This class holds the
 * main()-method amking it possible to open and run the project in a professional IDE
 */
public class Main {
  public static void main(String[] args) {
    // Create a labclass with maximum 20 students.
    LabClass labClass = new LabClass(20);

    // Add some students
    labClass.enrollStudent(new Student("Lise", "32323"));
    labClass.enrollStudent(new Student("John", "23232"));
    labClass.enrollStudent(new Student("Kari", "54545"));
    labClass.enrollStudent(new Student("Ole", "23232"));

    // Print the number of students in the class
    System.out.println("Number of students: " + labClass.numberOfStudents());

    // Set the room number
    labClass.setRoom("A-123");

    // Set the time and day
    labClass.setTime("Friday, 10am");

    // Set instructor
    labClass.setInstructor("Mr. Smith");

    // Print all enrolled students
    labClass.printList();


  }
}
