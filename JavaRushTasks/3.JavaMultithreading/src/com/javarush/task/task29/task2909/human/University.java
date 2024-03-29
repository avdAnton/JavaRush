package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student student : students){
            if (student.getAverageGrade() == grade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = students.get(0).getAverageGrade();
        Student studentWithMax = students.get(0);
        for (Student student : students){
            if (student.getAverageGrade() > maxAverageGrade){
                studentWithMax = student;
                maxAverageGrade = student.getAverageGrade();
            }
        }
        return studentWithMax;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = students.get(0).getAverageGrade();
        Student studentWithMin = students.get(0);
        for (Student student : students){
            if (student.getAverageGrade() < minAverageGrade){
                studentWithMin = student;
                minAverageGrade = student.getAverageGrade();
            }
        }
        return studentWithMin;
    }

    public void expel(Student student){
        students.remove(student);
    }
}