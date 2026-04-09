public class Department {
    private String name;
    private int studentCount;
    private String building;

    public Department(String name, int studentCount, String building) {
        this.name = name;
        this.studentCount = studentCount;
        this.building = building;
    }

    public void printDepartment() {
        System.out.println("학과명: " + name);
        System.out.println("학생 수: " + studentCount);
        System.out.println("건물: " + building);
        System.out.println();
    }
}