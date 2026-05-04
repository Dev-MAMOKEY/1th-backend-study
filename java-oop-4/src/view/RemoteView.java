package view;

import model.RemoteControl;

public class RemoteView {

    public void printTurnOnQuestion(RemoteControl device) {
        System.out.println();
        System.out.println("현재 기기: " + device.getName());
        System.out.println("현재 " + device.getControlName() + ": " + device.getValue());
        System.out.println("설정 가능 범위: " + device.getMinValue() + " ~ " + device.getMaxValue());
        System.out.println(device.getName() + "를 켜시겠습니까?");
        System.out.println("1. 예");
        System.out.println("2. 아니오");
        System.out.print("선택: ");
    }

    public void printControlMenu(RemoteControl device) {
        System.out.println();
        System.out.println("현재 " + device.getControlName() + ": " + device.getValue());
        System.out.println("설정 가능 범위: " + device.getMinValue() + " ~ " + device.getMaxValue());
        System.out.println("1. " + device.getControlName() + " 올리기");
        System.out.println("2. " + device.getControlName() + " 내리기");
        System.out.print("선택: ");
    }

    public void printAmountQuestion() {
        System.out.print("얼마나 조절할까요? ");
    }

    public void printPowerOn(RemoteControl device) {
        System.out.println(device.getName() + " 전원 ON");
    }

    public void printPowerOff(RemoteControl device) {
        System.out.println(device.getName() + " 전원 OFF");
    }

    public void printStatus(RemoteControl device) {
        System.out.println();
        System.out.println("현재 기기: " + device.getName());
        System.out.println("현재 " + device.getControlName() + ": " + device.getValue());
    }

    public void printInputError() {
        System.out.println("숫자를 입력해주세요.");
    }

    public void printRangeError() {
        System.out.println("잘못된 숫자입니다.");
    }

    public void printLimitError(RemoteControl device) {
        System.out.println(device.getControlName() + "은 "
                + device.getMinValue() + "부터 "
                + device.getMaxValue() + "까지만 설정할 수 있습니다.");
    }

    public void printRetry() {
        System.out.print("다시 입력: ");
    }

    public void printEnd() {
        System.out.println();
        System.out.println("프로그램을 종료합니다.");
    }
}