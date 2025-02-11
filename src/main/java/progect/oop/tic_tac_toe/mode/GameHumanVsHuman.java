package progect.oop.tic_tac_toe.mode;

public class GameHumanVsHuman extends TicTacToeGame {

    public GameHumanVsHuman(int size) {
        super(size);
    }

    public void game() {
        int k = 0;
        init();
        printMap();
        while (true) {
            humanMove(k);
            System.out.println();
            System.out.println((k + 1) + " ход:");
            printMap();
            if (k % 2 == 0) {
                if (checkWin(charX, dotsToWin)) {
                    System.out.println("Победил первый игрок!");
                    System.out.println("Сделано " + (k + 1) + " ходов.");
                    return;
                } else {
                    if (checkWin(charO, dotsToWin)) {
                        System.out.println("Победил второй игрок!");
                        System.out.println("Сделано " + (k + 1) + " ходов.");
                        return;
                    }
                }
            }
            if (isFull()) {
                System.out.println("Ничья!");
                return;
            }
            k++;
        }
    }

    public void humanMove(int k) {
        String x, y;
        do {
            System.out.println("Введите координаты X Y");
            x = scanner.next();
            y = scanner.next();
        } while (isCellValidHuman(x, y));
        int checkedX = Integer.parseInt(x) - 1;
        int checkedY = Integer.parseInt(y) - 1;
        if (k % 2 == 0) {
            map[checkedX][checkedY] = charX;
        } else {
            map[checkedX][checkedY] = charO;
        }

    }
}
