import model.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("김멋사","20260001","Software");
        Student s2 = new Student("김동사","20250001","Hardware");
        Student s3 = new Student("김수사","20240001","AI");

        Student[] students = {s1,s2,s3};

        Student.printAll(students);




    }
}