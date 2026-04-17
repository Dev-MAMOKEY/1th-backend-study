package view.message.errormessage;

public enum  ErrorMessage {
    DEPOSIT("0원은 입금할 수 없습니다."),
    WITHDRAWAL("0원은 출금할 수 없습니다"),
    INPUT("잘못 입력하셨습니다");
    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public void printError(){
        System.out.println(message);
    }


}
