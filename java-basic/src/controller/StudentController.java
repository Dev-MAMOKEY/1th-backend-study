package controller;

import model.Student;
import view.StudentView;

public class StudentController {

    private Student[] students;
    private StudentView view;

    public StudentController() {
        this.students = new Student[3];
        this.view = new StudentView();
    }

    public void run() {
        Students();
        printStudents();
    }

    private void Students() {
        students[0] = new Student("김멋사", 20260001, "software");
        students[1] = new Student("유소영", 20231374, "software");
        students[2] = new Student("김소영", 20251111, "design");
    }

    private void printStudents() {
        for (int i = 0; i < students.length; i++) {
            view.printStudent(students[i]);
        }
    }
}