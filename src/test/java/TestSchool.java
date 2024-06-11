import org.example.day3.School;
import org.example.day3.Student;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSchool {

    private School school;

    @BeforeEach
    public void CreateObjects() {
        school = new School();
        Student student1 = new Student(18,"Ali Hamad","Saudi Arabia,Riyadh,Al-Aqiq",12345,"Computer Science");
        Student student2 = new Student(18,"Tahani Mohammed","Saudi Arabia,Riyadh,Al-Narjis",125678,"Biology");
        school.addStudent(student1);
        school.addStudent(student2);
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student(21, "Dhay", "Riyadh", 1004, "Chemistry");
        school.addStudent(newStudent);

        Assertions.assertTrue(school.getStudents().contains(newStudent));
    }

    @Test
    public void testRemoveStudent() {
        school.removeStudent(1002);
        int actual = school.getStudents().size();


        assertEquals(2, actual);
    }

    @Test
    public void sortStudentName() {
        School school = new School();
        Student student1 = new Student(18, "Ali Hamad", "Saudi Arabia,Riyadh,Al-Aqiq", 12345, "Computer Science");
        Student student2 = new Student(18, "Tahani Mohammed", "Saudi Arabia,Riyadh,Al-Narjis", 125678, "Biology");
        school.addStudent(student1);
        school.addStudent(student2);

        ArrayList<Student> expected = new ArrayList<>(Arrays.asList(student1, student2));
        school.sortStudentName();
        ArrayList<Student> actual = school.getStudents();

        try {
            assertEquals(expected, actual);
        } catch (AssertionFailedError e) {
            System.out.println("Assertion failed:");
            for (int i = 0; i < expected.size(); i++) {
                System.out.println("Expected: " + expected.get(i));
                System.out.println("Actual: " + actual.get(i));
            }
            throw e;
        }
    }

    @Test
    public void testFindStudentByBinarySearch() {
        Student foundStudent = school.findStudentID(12345);
        assertEquals("Ali Hamad", foundStudent.getName());
    }

}