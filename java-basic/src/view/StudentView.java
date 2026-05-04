package view;

import model.Student;

public class StudentView {

    public void printStudent(Student student) {
        System.out.println("이름 : " + student.getName() + ", 학번 : " + student.getStudentId() + ", 전공 : " + student.getMajor());
    }
}