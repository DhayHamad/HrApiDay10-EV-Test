package org.example.day3;

public class Person extends PersonRecord{
    private String name;
    private int age;
    private String address;

    public Person(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    private void ageValidate(int age){
        if (age < 0 || age > 150){
            throw  new IllegalArgumentException("Age must be between 0 and 150.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person( Name:"  + name + ", Age: " + age +", Address: " + address +')';
    }

    @Override
    public String getDetails() {
        return "Name:"  + name + ", Age: " + age +", Address: " + address;
    }
}
