public class Main {
    public static void main(String[] args) {
        Department[] departments = {
                new Department("소프트웨어융합학과", 50, "기도관"),
                new Department("방사선학과", 45, "은혜관"),
                new Department("간호학과", 60, "말씀관")
        };

        for (Department department : departments) {
            department.printDepartment();
        }
    }
}