package controller;

import model.RemoteControl;

public class ControlController {
    // 사용자가 선택한 메뉴와 입력값을 바탕으로 실제 기기의 상태(음량, 온도 등)를 변경하는 역할을 담당
    public void control(RemoteControl device, int menu, int amount) {
        for (int i = 0; i < amount; i++) {

            if (menu == 1) {
                device.controlUp();
            } else if (menu == 2) {
                device.controlDown();
            }
        }
    }
}