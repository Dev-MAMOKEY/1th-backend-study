package view;

public class ErrorMessage {
    public static void volumeupError(){
        System.out.println("100이 최대 볼륨 입니다");
    }
    public static void volumedownError(){
        System.out.println("0이하로 볼륨을 낮출 수 없습니다 ");
    }
    public static void powerCondition(){
        System.out.println("*전원이 켜져있을때만 volum 조절 가능합니다*");
    }
    public static void errorInput(){
        System.out.println("*잘못 입력하셨습니다*");
    }

}
