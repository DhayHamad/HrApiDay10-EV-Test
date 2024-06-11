package org.example.day3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {
    private List<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        students.removeIf(student -> student.ComparableByID(studentId));
    }

    public void displayAllStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentName() {
        students.sort(Comparator.comparing(Person::getName));
    }

    public Student findStudentID(int studentId) {
        return students.stream().filter(student -> student.ComparableByID(studentId))
                .findFirst().orElse(null);
    }

    public void readStudentFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                String name = details[0];
                int age = Integer.parseInt(details[1]);
                String address = details[2];
                int studentId = Integer.parseInt(details[3]);
                String course = details[4];

                Student student = new Student(age, name, address, studentId, course);
                addStudent(student);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wtiteStudentToFile(String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Student student : students) {
                try {
                    writer.write(student.getDetails());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
