package controller;

import model.RemoteControl;
import view.RemoteView;

import java.util.Scanner;

public class InputController {

    private RemoteView view;
    private Scanner sc = new Scanner(System.in);

    public InputController(RemoteView view) {
        this.view = view;
    }

    public int validTurnOn(RemoteControl device) {
        while (true) {
            view.printTurnOnQuestion(device);

            int answer = inputNumber();

            if (answer == 1 || answer == 2) {
                return answer;
            }

            view.printRangeError();
        }
    }

    public int validMenu(RemoteControl device) {
        while (true) {
            view.printControlMenu(device);

            int menu = inputNumber();

            if (menu == 1 || menu == 2) {
                return menu;
            }

            view.printRangeError();
        }
    }

    public int validAmount(RemoteControl device, int menu) {
        while (true) {
            view.printAmountQuestion();

            int amount = inputNumber();

            int resultValue = device.getValue();

            if (menu == 1) {
                resultValue += amount;
            } else if (menu == 2) {
                resultValue -= amount;
            }

            if (amount <= 0) {
                view.printRangeError();
            } else if (resultValue < device.getMinValue() || resultValue > device.getMaxValue()) {
                view.printLimitError(device);
            } else {
                return amount;
            }
        }
    }

    private int inputNumber() {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                sc.nextLine();
                return number;
            }

            sc.nextLine();
            view.printInputError();
            view.printRetry();
        }
    }
}