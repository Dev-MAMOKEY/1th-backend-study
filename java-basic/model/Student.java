package model;

public class Student{
    private final String name;
    private final String studentId;
    private final String major;


    public Student(String name,String studentId,String major){
        this.name = name;
        this.studentId = studentId;
        this. major = major;
    }

    public String getName() {
        return name;
    }
    public String getStudentId(){
        return studentId;
    }

    public String getMajor() {
        return major;
    }
}