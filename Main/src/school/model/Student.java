package school.model;

import java.util.UUID;

public class Student {
    private final String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;

    public Student(String name, String address, String email) {
        this.studentId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void enroll(Course course) {
        this.course = course;
        course.addMoneyEarned();
    }

    @Override
    public String toString() {
        return studentId + ": " + name + " | " + email + " | " + address +
                (course != null ? " | Enrolled in: " + course.getName() : " | Not enrolled");
    }
}
