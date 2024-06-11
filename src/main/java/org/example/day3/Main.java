package org.example.day3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        //var person1 = new Person(21,"Dhay Alduaylij","Saudi Arabia,Riyadh,Hatayn");
        //var person2 = new Person(30,"Saad Fahad","Saudi Arabia,Riyadh,Al-Suwaidi");

        Student student1 = new Student(18,"Ali Hamad","Saudi Arabia,Riyadh,Al-Aqiq",12345,"Computer Science");
        Student student2 = new Student(18,"Tahani Mohammed","Saudi Arabia,Riyadh,Al-Narjis",125678,"Biology");

        school.addStudent(student1);
        school.addStudent(student2);

        System.out.println("Student:");
        school.displayAllStudent();

        school.sortStudentName();
        System.out.println("Student sorted by name: ");
        school.displayAllStudent();

        Student studentFound = school.findStudentID(12345);
        System.out.println("Found student with ID 125678: " +studentFound);

        try {
            school.wtiteStudentToFile("students.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Student writting to file.");

        //System.out.println(person1.toString());
        //System.out.println(person2.toString());

        //System.out.println("*****************************************************************");

        //System.out.println(student1.toString());
        //System.out.println(student2.toString());

        School newschool = new School();
        newschool.readStudentFile("students.txt");
        System.out.println("Student read from file.");
        newschool.displayAllStudent();
    }
}
