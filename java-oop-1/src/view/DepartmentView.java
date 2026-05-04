package view;

import model.Department;

public class DepartmentView {

    // 한 개 출력
    public void display(Department d) {
        System.out.println(d.getInfo());
    }

    // 여러 개 출력 (확장 for문 사용)
    public void displayAll(Department[] departments) {
        for (Department d : departments) {
            System.out.println(d.getInfo());
        }
    }
}