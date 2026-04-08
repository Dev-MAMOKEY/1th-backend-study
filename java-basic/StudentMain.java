public class StudentMain {
    public static void main(String[] args) {

        Student s1 = new Student("김멋사", 20260001, "software");
        Student s2 = new Student("유소영", 20231374, "software");
        Student s3 = new Student("김소영", 20251111, "design");

        // Student[] students = {s1, s2, s3};

        Student[] students = new Student[3];

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println("이름 : " + s.name + ", 학번 : " + s.studentId + ", 전공 : " + s.major);
        }

    }
}
