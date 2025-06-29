package school.controller;

import school.model.Teacher;
import school.model.Course;
import school.model.Student;

import java.util.*;

public class SchoolService {
    private final Map<String, Teacher> teachers = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();
    private final Map<String, Student> students = new HashMap<>();

    public void addTeacher(Teacher t) {
        teachers.put(t.getTeacherId(), t);
    }

    public void addCourse(Course c) {
        courses.put(c.getCourseId(), c);
    }

    public void addStudent(Student s) {
        students.put(s.getStudentId(), s);
    }

    public void enrollStudent(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student == null) throw new RuntimeException("Student ID not found");
        if (course == null) throw new RuntimeException("Course ID not found");
        student.enroll(course);
        System.out.println("Student " + student.getName() + " enrolled in course " + course.getName());
    }

    public void assignTeacher(String teacherId, String courseId) {
        Teacher teacher = teachers.get(teacherId);
        Course course = courses.get(courseId);
        if (teacher == null) throw new RuntimeException("Teacher ID not found");
        if (course == null) throw new RuntimeException("Course ID not found");
        course.setTeacher(teacher);
        System.out.println("Teacher " + teacher.getName() + " assigned to course " + course.getName());
    }

    public void handleShowCommand(String[] parts) {
        if (parts.length < 2) throw new RuntimeException("Missing SHOW argument (TEACHERS/STUDENTS/COURSES).");
        switch (parts[1].toUpperCase()) {
            case "TEACHERS":
                teachers.values().forEach(System.out::println);
                break;
            case "STUDENTS":
                students.values().forEach(System.out::println);
                break;
            case "COURSES":
                courses.values().forEach(System.out::println);
                break;
            default:
                throw new RuntimeException("Invalid SHOW command.");
        }
    }

    public void handleLookupCommand(String[] parts) {
        if (parts.length < 3) throw new RuntimeException("Missing LOOKUP argument (LOOKUP TEACHER/STUDENT/COURSE + ID).");
        String id = parts[2];
        switch (parts[1].toUpperCase()) {
            case "TEACHER":
                Teacher teacher = teachers.get(id);
                if (teacher != null) { System.out.println(teacher); }
                else { System.out.println("Teacher not found"); }
                break;
            case "STUDENT":
                Student student = students.get(id);
                if (student != null) { System.out.println(student); }
                else { System.out.println("Student not found"); }
                break;
            case "COURSE":
                Course course = courses.get(id);
                if (course != null) { System.out.println(course); }
                else { System.out.println("Course not found"); }
                break;
            default:
                throw new RuntimeException("Invalid LOOKUP command.");
        }
    }

    public double calculateProfit() {
        double totalEarned = courses.values().stream().mapToDouble(Course::getMoneyEarned).sum();
        double totalSalaries = teachers.values().stream().mapToDouble(Teacher::getSalary).sum();
        return totalEarned - totalSalaries;
    }
}