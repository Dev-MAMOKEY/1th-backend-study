package view.message.errormessage;

public class DepositError implements Error {
    public void Error_input(){
        System.out.println("0원은 입금할 수 없습니다.");
    }
}
