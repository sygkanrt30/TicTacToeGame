package progect.oop.tic_tac_toe;

import progect.oop.tic_tac_toe.mode.GameHumanVsHuman;
import progect.oop.tic_tac_toe.mode.GameIoVsHuman;
import progect.oop.tic_tac_toe.mode.GameIoVsIo;

import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Добро пожаловать в игру крестики-нолики ***\n");
        int checkedSize, checkedMode;
        String size, mode;
        do {
            System.out.println("Выберите размер поля, для этого ведите длину одной стороны (длина стороны не может быть больше 9 и меньше 3): ");
            size = scanner.next();
        } while (!checkInputSize(size));
        System.out.println("""
                Выберите режим, для выбора режима введите соответствующую цифру:
                Игрок против игрока - 1
                Игрок против компьютера - 2
                Компьютера против компьютера - 3""");
        do {
            System.out.println("Введите цифру,соответствующую выбранному режиму: ");
            mode = scanner.next();
        } while (!checkInputMode(mode));
        checkedSize = Integer.parseInt(size);
        checkedMode = Integer.parseInt(mode);
        switch (checkedMode) {
            case 1:
                GameHumanVsHuman gameHumanVsHuman = new GameHumanVsHuman(checkedSize);
                gameHumanVsHuman.game();
                break;
            case 2:
                GameIoVsHuman gameIoVsHuman = new GameIoVsHuman(checkedSize);
                gameIoVsHuman.game();
                break;
            case 3:
                GameIoVsIo gameIoVsIo = new GameIoVsIo(checkedSize);
                gameIoVsIo.game();
                break;
        }
    }

    public static boolean checkParceIntError(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException checkInput) {
            return false;
        }
        return true;
    }

    public static boolean checkInputSize(String inputSize) {
        int size;
        if (checkParceIntError(inputSize)) {
            size = Integer.parseInt(inputSize);
            return size > 2 && size < 10;
        }
        return false;
    }

    public static boolean checkInputMode(String inputMode) {
        int size;
        if (checkParceIntError(inputMode)) {
            size = Integer.parseInt(inputMode);
            return size > 0 && size < 4;
        }
        return false;
    }

}
