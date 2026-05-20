package controller;

import model.CreateDevice;
import model.RemoteControl;
import view.Select;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeviceController {
    private final CreateDevice createDevice = new CreateDevice();
    private final Select select = new Select();
    private final MenuController menuController = new MenuController();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        RemoteControl[] devices = createDevice.createDevices();

        for (RemoteControl device : devices) {
            device.turnOn();
        }

        while (true) {
            int firstSelect;
            select.firstSelect();

            try {
                firstSelect = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("위의 숫자 중 하나를 입력하여 주십시오.");
                scanner.next();
                continue;
            }

            RemoteControl selectedDevice = null;

            switch (firstSelect) {
                case 1:
                    selectedDevice = devices[0];
                    break;
                case 2:
                    selectedDevice = devices[1];
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    continue;
            }

            while (true) {
                int secondSelect;
                select.secondSelect(selectedDevice.getVolumeLabel());

                try {
                    secondSelect = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("위의 숫자 중 하나를 입력하여 주십시오.");
                    scanner.next();
                    continue;
                }

                if (secondSelect == 0) {
                    break;
                }

                menuController.featureSelect(secondSelect, selectedDevice);
            }
        }
    }
}
