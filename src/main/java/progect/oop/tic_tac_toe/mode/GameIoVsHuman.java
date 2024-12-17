package progect.oop.tic_tac_toe.mode;

public class GameIoVsHuman extends TicTacToeGame {

    public GameIoVsHuman(int size) {
        super(size);
    }

    public void game() {
        int k = 1;
        init();
        printMap();
        while (true) {
            humanMove();
            System.out.println();
            System.out.println(k + " ход:");
            printMap();
            if (checkWin(charX, dotsToWin)) {
                System.out.println("Победил игрок!");
                System.out.println("Сделано " + k + " ходов.");
                return;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                return;
            }
            k++;
            ioMove();
            System.out.println();
            System.out.println(k + " ход:");
            printMap();
            if (checkWin(charO, dotsToWin)) {
                System.out.println("Победил бот!");
                System.out.println("Сделано " + k + " ходов.");
                return;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                return;
            }
            k++;
        }
    }


}
