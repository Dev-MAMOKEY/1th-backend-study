package view.userinput;

import java.util.Scanner;
public class DepositInput implements UserInput {
    Scanner sc  = new Scanner(System.in);
    @Override
    public int userInput(){
        System.out.println("입금할 금액을 적으시오:");
        return sc.nextInt();
    }
}
