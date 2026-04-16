package view.message.errormessage;

public class WithdrawalError implements Error {
    public void Error_input(){
        System.out.println("0원은 출금할 수 없습니다.");
    }
}
