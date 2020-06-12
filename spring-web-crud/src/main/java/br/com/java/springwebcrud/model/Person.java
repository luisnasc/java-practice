package br.com.java.springwebcrud.model;

import javax.validation.constraints.NotBlank;

public class Person {

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;


    private int age;

    @NotBlank
    private String number;

    public Person(int id, String name, String lastName, int age, String number) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
    }

    public Person(){  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }
}
