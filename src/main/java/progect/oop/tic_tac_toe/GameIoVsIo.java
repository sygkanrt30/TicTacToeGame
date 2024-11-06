package progect.oop.tic_tac_toe;


public class GameIoVsIo extends TicTacToeGame {
    public GameIoVsIo(int size) {
        super(size);
    }

    public void game() {
        int k = 0;
        init();
        printMap();
        while (true) {
            if (k % 2 == 0) {
                ioMove(charX);
                System.out.println();
                System.out.println((k + 1) + " ход:");
                printMap();
                if (checkWin(charX, dotsToWin)) {
                    System.out.println("Победил бот1!");
                    System.out.println("Сделано " + (k + 1) + " ходов.");
                    break;
                }
            } else {
                ioMove(charO);
                System.out.println();
                System.out.println((k + 1) + " ход:");
                printMap();
                if (checkWin(charO, dotsToWin)) {
                    System.out.println("Победил бот2!");
                    System.out.println("Сделано " + (k + 1) + " ходов.");
                    break;
                }
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
            k++;
        }
    }

    public void ioMove(char symbol) {
        int x, y;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == charEmpty) {
                    map[i][j] = symbol;
                    if (checkWin(symbol, dotsToWin)) {
                        return;
                    }
                    map[i][j] = charEmpty;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == charEmpty) {
                    if (symbol == charO) {
                        map[i][j] = charX;
                        if (checkWin(charX, dotsToWin)) {
                            map[i][j] = charO;
                            return;
                        }
                    } else {
                        map[i][j] = charO;
                        if (checkWin(charO, dotsToWin)) {
                            map[i][j] = charX;
                            return;
                        }
                    }
                    map[i][j] = charEmpty;
                }
            }
        }
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (isCellValidIo(x, y));
        map[x][y] = symbol;
    }
}
