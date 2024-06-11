package org.example.day3;

public class Student extends Person implements ComparableByID {

    private int studentId;
    private String course;

    public Student(int age, String name, String address,int studentId,String course) {
        super(age, name, address);
        validateStudentID(studentId);
        this.studentId = studentId;
        this.course = course;
    }

    private void validateStudentID(int studentID){
        if (studentID <= 0){
            throw new IllegalArgumentException("Student ID must be positive");
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student( " + "Student ID: " + studentId + ", Course: " + course + "Name: " + getName() + "Age: " + getAge() +" Address" + getAddress() +")";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Student ID: " +  studentId + ", Course: " + course;
    }

    @Override
    public boolean ComparableByID(int id) {
        return this.studentId == id;
    }

}
