package controller;

import model.Student;
import view.PrintAll;


public class StudentController {
    private final Student[] student;
    private final PrintAll printAll;

    public StudentController(Student[] student, PrintAll printAll){
        this.student =student;
        this.printAll = printAll;
    }

    public void run(){
        printAll.printAll(student);
    }
}
