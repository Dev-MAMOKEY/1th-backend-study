package view;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProductSelect {
    Scanner sc = new Scanner(System.in);
    public int productSelect(){
        int choice =0;
        while(true){
            try{
                System.out.println("제품 하나를 선택하시오");
                System.out.println("1. TV");
                System.out.println("2. 에어컨");
                System.out.println("3. TV/에어컨 동시조작 ");
                choice =sc.nextInt();
                if(choice ==1 || choice ==2 || choice ==3){
                    break;
                }else{
                    System.out.println("1번 2번 3번만 입력가능합니다");
                }

            }catch (InputMismatchException e){
                System.out.println("숫자만 가능합니다");
                sc.nextLine();
            }
        }
        return choice;
    }

    public int stateSelect(){
        int choice = 0;
        while(true){
            try{
                System.out.println("-----------------------");
                System.out.println("상태를 선택하세요(번호 입력)");
                System.out.println("1. turnOn");
                System.out.println("2. turnOff");
                System.out.println("3. volumUp");
                System.out.println("4. volumDown");
                System.out.println("5. 현재 전원상태");
                System.out.println("6. 현재 volum 상태");
                System.out.println("7. stop ");
                choice = sc.nextInt();
                if(choice >= 1 && choice <= 7){
                    break;
                }else{
                    System.out.println("1~7번까지만 입력가능합니다");
                }
            }catch (InputMismatchException e){
                System.out.println("숫자만 입력가능합니다");
                sc.nextLine();
            }

        }
        return choice;
    }
}
