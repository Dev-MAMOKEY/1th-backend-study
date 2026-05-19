package controller;
import model.Department;
import view.DepartmentView;

public class DepartmentController {

    private final DepartmentView departmentView =  new DepartmentView();

    public void run() {
        Department[] departments = {
                new Department("소프트웨어융합학과", 50, "기도관"),
                new Department("방사선학과", 45, "은혜관"),
                new Department("간호학과", 60, "말씀관")
        };

        for (Department department : departments) {
            departmentView.printDepartment(department);
        }
    }
}
