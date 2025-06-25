package school.model;

import java.util.UUID;

public class Course {
    private final String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.moneyEarned = 0.0;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addMoneyEarned() {
        this.moneyEarned += this.price;
    }

    @Override
    public String toString() {
        return courseId + ": " + name + " ($" + price + ") - Earned: $" + moneyEarned +
                (teacher != null ? " | Teacher: " + teacher.getName() : " | No teacher assigned");
    }
}
