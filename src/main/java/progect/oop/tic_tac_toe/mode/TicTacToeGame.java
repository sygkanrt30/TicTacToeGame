package progect.oop.tic_tac_toe.mode;


import progect.oop.tic_tac_toe.MainApp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    protected static final Scanner scanner = new Scanner(System.in);
    protected static final Random random = new Random();
    protected final char charX;
    protected final char charO;
    protected final char charEmpty;
    protected char[][] map;
    protected final int size;
    protected final int dotsToWin;

    public TicTacToeGame(int size) {
        this.charX = 'X';
        this.charO = 'O';
        this.charEmpty = '.';
        this.size = size;
        this.map = new char[size][size];
        this.dotsToWin = 3;
    }

    public int getDotsToWin() {
        return dotsToWin;
    }

    public void init() {
        for (char[] chars : map) {
            Arrays.fill(chars, charEmpty);
        }
    }

    public void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkLine(int cx, int cy, int offsetX, int offsetY, char symbol, int dotsToWin) {
        if (cx + offsetX * (dotsToWin - 1) > size - 1 || cy + offsetY * (dotsToWin - 1) > size - 1 ||
                cy + offsetY * (dotsToWin - 1) < 0) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[cx + i * offsetX][cy + i * offsetY] != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char symbol, int dotsToWin) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkLine(i, j, 0, 1, symbol, dotsToWin) ||
                        checkLine(i, j, 1, 0, symbol, dotsToWin) ||
                        checkLine(i, j, 1, 1, symbol, dotsToWin) ||
                        checkLine(i, j, 1, -1, symbol, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCellValidHuman(String x, String y) {
        int checkedX, checkedY;
        if (MainApp.checkParceIntError(x) && MainApp.checkParceIntError(y)) {
            checkedX = Integer.parseInt(x);
            checkedY = Integer.parseInt(y);
            if (checkedX - 1 >= size || checkedY - 1 >= size || checkedX < 0 || checkedY < 0) {
                return true;
            }
        } else
            return true;
        return map[checkedX - 1][checkedY - 1] != charEmpty;
    }

    public boolean isCellValidIo(int x, int y) {
        if (x >= size || y >= size || x < 0 || y < 0) {
            return true;
        }
        return map[x][y] != charEmpty;
    }

    public void humanMove() {
        String x, y;
        do {
            System.out.println("Введите координаты X Y");
            x = scanner.next();
            y = scanner.next();
        } while (isCellValidHuman(x, y));
        int checkedX = Integer.parseInt(x) - 1;
        int checkedY = Integer.parseInt(y) - 1;
        map[checkedX][checkedY] = charX;
    }

    public void ioMove() {
        int x, y;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == charEmpty) {
                    map[i][j] = charO;
                    if (checkWin(charO, dotsToWin)) {
                        return;
                    }
                    map[i][j] = charEmpty;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == charEmpty) {
                    map[i][j] = charX;
                    if (checkWin(charX, dotsToWin)) {
                        map[i][j] = charO;
                        return;
                    }
                    map[i][j] = charEmpty;
                }

            }
        }
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (isCellValidIo(x, y));
        map[x][y] = charO;
    }

}

