package view;
import model.Department;

public class DepartmentView {
    public void printDepartment(Department department) {
        System.out.printf("""
                학과명: %s
                학생 수: %d
                건물: %s\n
                """, department.getName(), department.getStudentCount(), department.getBuilding());
    }
}
