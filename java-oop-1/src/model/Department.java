package model;

public class Department {
    // 캡슐화
    private String name;
    private int studentCount;
    private String building;

    // 생성자
    public Department(String name, int studentCount, String building) {
        this.name = name;
        this.studentCount = studentCount;
        this.building = building;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public String getBuilding() {
        return building;
    }

    // 출력용 문자열 (줄바꿈 활용 의견 반영)
    public String getInfo() {
        return "학과명: " + name + "\n" + "학생수: " + studentCount + "\n" + "건물: " + building + "\n";
    }
}