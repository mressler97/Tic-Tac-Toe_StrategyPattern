import java.lang.Math;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class GameController {

    private final boolean human;
    private final int verbose;

    String[] strArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    ArrayList<Integer> movesLeft = new ArrayList<>();
    List<String> board = Arrays.asList(strArray);

    Scanner sc = new Scanner(System.in);
    TypeOfPlayers p1 = new TypeOfPlayers();
    TypeOfPlayers p2 = new TypeOfPlayers();

    public GameController(int players, int verbose) {
        movesLeft.addAll(Arrays.asList(intArray));
        this.verbose = verbose;
        if (players == 0) {
            human = false;
            p1.setPlayerStrategy(new AI());
            p2.setPlayerStrategy(new AI());
            int turn = (int) (Math.random() * 10);
            if (turn % 2 == 0) {
                System.out.println("Player 1 going first");
                p1.setGoFirst(true);
                p2.setGoFirst(false);
            } else {
                System.out.println("Player 2 going first");
                p1.setGoFirst(false);
                p2.setGoFirst(true);

            }
            p1.setSymbol();
            p2.setSymbol();
        } else if (players == 1) {
            p1.setPlayerStrategy(new Player());
            p2.setPlayerStrategy(new AI());
            human = true;
        } else {
            p1.setPlayerStrategy(new Player());
            p2.setPlayerStrategy(new Player());
            human = true;
        }
    }

    public void startGame() {

        if (human) {
            System.out.println("Let's see who goes first! odds or evens?");
            String choice = sc.nextLine();

            if (!(choice.equals("odds") | choice.equals("evens"))) {
                System.out.println("defaulting to evens since you're special...");
                choice = "evens";
            }

            int turn = (int) (Math.random() * 10);
            System.out.print(turn + " => ");
            if ((turn % 2 == 0 && choice.equals("evens")) | (turn % 2 != 0 && choice.equals("odds"))) {
                System.out.println("You go first!");
                p1.setGoFirst(true);
                p2.setGoFirst(false);

            } else {
                System.out.println("Player 2 goes first!");
                p2.setGoFirst(true);
                p1.setGoFirst(false);
            }
            p1.setSymbol();
            p2.setSymbol();
        }
            playGame();

    }

    private void playGame() {
        drawBoard();
        if (p1.goesFirst) {
            System.out.println("choose a position to play!");
            p1.play(board, movesLeft);
            drawBoard();
            if (verbose == 1) {
                System.out.println("\nmoves left: " + movesLeft);
                System.out.println("board: " + board + "\n");
            }
        }

        p2.play(board, movesLeft);
        drawBoard();
        if (verbose == 1) {
            System.out.println("\nmoves left: " + movesLeft);
            System.out.println("board: " + board + "\n");
        }
        while (movesLeft.size() != 0) {
            if (winner(p1)) break;
            else if (winner(p2)) break;
        }
        if (p1.checkWin(board)) {
            System.out.println("Player 1 wins!");
        } else if (p2.checkWin(board)) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Cat Game -_-");
        }

    }

    private boolean winner(TypeOfPlayers player) {
        if (!p1.checkWin(board) && !p2.checkWin(board)) {
            player.play(board, movesLeft);
            drawBoard();
            if (verbose == 1) {
                System.out.println("\nmoves left: " + movesLeft);
                System.out.println("board: " + board + "\n");
            }
        } else {
            return true;
        }
        return false;
    }

    private void drawBoard() {

        System.out.println(board.get(0) + " | " + board.get(1) + " | " + board.get(2));
        System.out.println("-----------");
        System.out.println(board.get(3) + " | " + board.get(4) + " | " + board.get(5));
        System.out.println("-----------");
        System.out.println(board.get(6) + " | " + board.get(7) + " | " + board.get(8));
        System.out.println();
    }

}
