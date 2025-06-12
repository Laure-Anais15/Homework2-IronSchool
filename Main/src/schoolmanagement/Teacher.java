package schoolmanagement;

import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;

    // Constructor
    public Teacher(String name, double salary) {
        this.teacherId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

