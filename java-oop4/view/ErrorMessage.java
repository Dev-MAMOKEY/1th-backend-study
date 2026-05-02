package view;

public class ErrorMessage {
    public static void volumeupError(String name, int maxVolume){
        System.out.printf("%s의 최대 volume은 %d입니다",name,maxVolume);
    }
    public static void volumedownError(String name, int minVolume){
        System.out.printf("%s의 최소 volume은 %d입니다",name,minVolume);
    }
    public static void powerCondition(){
        System.out.println("*전원이 켜져있을때만 volum 조절 가능합니다*");
    }
    public static void errorInput(){
        System.out.println("*잘못 입력하셨습니다*");
    }

}
