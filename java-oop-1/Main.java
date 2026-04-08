// 실행 클래스
public class Main {
    public static void main(String[] args) {

        // 객체 생성
        Department d1 = new Department("컴퓨터공학과", 65, "기도관");
        Department d2 = new Department("경영학과", 200, "에벤에셀관");
        Department d3 = new Department("에너지공학과", 60, "기도관");

     /* Department[] departments = {d1, d2, d3};

        for (Department d : departments) {
          System.out.println("학과명 : " + d.name + ", 학생수 : " + d.studentCount + ", 건물 : " + d.building);
        } */

        // 메서드 호출
        d1.printInfo();
        d2.printInfo();
        d3.printInfo();
    }
}