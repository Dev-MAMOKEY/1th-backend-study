package view;

import java.util.Scanner;
import model.RemoteControl;

public class RemoteView {

    private Scanner sc = new Scanner(System.in);

    public int askTurnOn(RemoteControl device) {
        System.out.println();
        System.out.println(device.getName() + "를 켜시겠습니까?");
        System.out.println("1. 예");
        System.out.println("2. 아니오");
        System.out.print("선택: ");
        return sc.nextInt();
    }

    public int selectVolumeMenu() {
        System.out.println();
        System.out.println("1. 볼륨 올리기");
        System.out.println("2. 볼륨 내리기");
        System.out.print("선택: ");
        return sc.nextInt();
    }

    public int inputAmount() {
        System.out.print("얼마나 조절할까요? ");
        return sc.nextInt();
    }

    public void printStatus(RemoteControl device) {
        System.out.println();
        System.out.println("현재 기기: " + device.getName());
        System.out.println("현재 볼륨: " + device.getVolume());
    }

    public void printWrongNumber() {
        System.out.println("잘못된 숫자입니다.");
    }
}