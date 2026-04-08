// Department 클래스 정의
public class Department {
    
    // 필드 정의
    String name;
    int studentCount;
    String building;

    // 생성자
    public Department(String name, int studentCount, String building) {
        this.name = name; // 전달받은 것을 필드에 저장
        this.studentCount = studentCount;
        this.building = building;
    }

    // 메서드
    // 학과 정보를 출력하는 메서드
    public void printInfo() {
      System.out.println("학과명: " + name);
      System.out.println("학생수: " + studentCount);
      System.out.println("건물: " + building);
    }
}
