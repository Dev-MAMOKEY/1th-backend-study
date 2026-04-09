import model.Department;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Department computer = new Department("컴퓨터공학과", 120, "IT관");
        Department management = new Department("경영학과", 100, "경영관");
        Department electron = new Department("전자공학과", 140, "IT관");

        Scanner sc = new Scanner(System.in);
        Department select = null;
        boolean loop = true;


        while (loop) {
            System.out.println("어떤 과의 정보를 원하시나요?(컴퓨터공학과 / 경영학과 / 전자공학과)");
            String answer = sc.nextLine();
            switch (answer) {
                case "컴퓨터공학과":
                    select = computer;
                    loop = false;
                    break;
                case "경영학과":
                    select = management;
                    loop = false;
                    break;
                case "전자공학과":
                    select = electron;
                    loop = false;
                    break;
                case "stop":
                    loop = false;
                    break;
                default:
                    System.out.println("정확히 입력하세요");
                    System.out.println("멈추고 싶으면 'stop' 입력하세요");
                    break;
            }

        }

        if (select != null) {
            computer.printAll(select);
        } else {
            System.out.println("조회된 정보가 없습니다 ");
        }


    }


}