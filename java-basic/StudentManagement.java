public class StudentManagement {
    static class Student {
        private String name;
        private String studentId;
        private String major;

        public Student(String name, String studentId, String major) {
            this.name = name;
            this.studentId = studentId;
            this.major = major;
        }

        public String getName() {
            return name;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getMajor() {
            return major;
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("최정훈", "20230593", "소프트웨어융합학과");
        Student s2 = new Student("홍길동", "20240594", "방사선학과");
        Student s3 = new Student("김철수", "20250595", "간호학과");

        Student[] students = new Student[3];

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for (int i = 0; i < students.length; i++) {
            System.out.println("이름: " + students[i].getName());
            System.out.println("학번: " + students[i].getStudentId());
            System.out.println("전공: " + students[i].getMajor());
            System.out.println();
        }
    }
}