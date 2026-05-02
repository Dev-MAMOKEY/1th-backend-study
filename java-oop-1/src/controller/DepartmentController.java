package controller;

import model.Department;
import view.DepartmentView;

public class DepartmentController {

    private Department[] departments;
    private DepartmentView view;

    public DepartmentController() {
        view = new DepartmentView();

        // 데이터 생성
        departments = new Department[] {
                new Department("컴퓨터공학과", 65, "기도관"),
                new Department("경영학과", 200, "에벤에셀관"),
                new Department("에너지공학과", 60, "기도관")
        };
    }

    // 실행 로직
    public void run() {
        view.displayAll(departments);
    }
}