package view;

import model.Student;

public class PrintAll {
    public void printAll(Student[] students){
        for(Student student : students){
            System.out.printf("이름:%s 학번:%s 전공:%s\n",student.getName(),student.getStudentId(),student.getMajor());
        }
    }
}
