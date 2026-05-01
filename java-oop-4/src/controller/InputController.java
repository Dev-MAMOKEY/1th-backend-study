package controller;

import model.RemoteControl;
import view.RemoteView;

public class InputController {

    private RemoteView view;

    public InputController(RemoteView view) {
        this.view = view;
    }

    public int validTurnOn(RemoteControl device) {
        while (true) {
            int answer = view.askTurnOn(device);

            if (answer == 1 || answer == 2) {
                return answer;
            } else {
                view.printWrongNumber();
            }
        }
    }

    public int validMenu() {
        while (true) {
            int menu = view.selectVolumeMenu();

            if (menu == 1 || menu == 2) {
                return menu;
            } else {
                view.printWrongNumber();
            }
        }
    }

    public int validAmount(RemoteControl device, int menu) {
        while (true) {
            int amount = view.inputAmount();

            if (menu == 1 && device.getVolume() + amount >= 100) {
                System.out.println("100보다 작게 입력하세요.");
            } else if (menu == 2 && amount > device.getVolume()) {
                System.out.println("10보다 작게 입력하세요.");
            } else {
                return amount;
            }
        }
    }
}