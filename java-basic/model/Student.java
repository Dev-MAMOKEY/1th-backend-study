package model;

public class Student{
    private  String name;
    private String studentId;
    private String major;


    public Student(String name,String studentId,String major){
        this.name = name;
        this.studentId = studentId;
        this. major = major;
    }
    // 출력 메소드
    public static void printAll(Student[] students){
        for(Student student : students){
            System.out.printf("이름:%s 학번:%s 전공:%s\n",student.name,student.studentId,student.major);
        }
    }


}