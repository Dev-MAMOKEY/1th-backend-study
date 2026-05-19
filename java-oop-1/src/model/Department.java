package model;

public class Department {
    private String name;
    private int studentCount;
    private String building;

    public Department(String name, int studentCount, String building) {
        this.name = name;
        this.studentCount = studentCount;
        this.building = building;
    }

    public Department(String name, int studentCount) {
        this(name, studentCount, "건물 미정");
    }

    public Department(String name) {
        this(name, 0, "건물 미정");
    }

    public Department() {
        this("학과명 미정", 0, "건물 미정");
    }

    public String getName() {
        return name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public String getBuilding() {
        return building;
    }
}