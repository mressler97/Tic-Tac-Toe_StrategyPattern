import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("______________________________________________");
        System.out.println("Welcome to a game of Tic-Tac-Toe...Good luck!");
        System.out.println("______________________________________________");
        System.out.println();
        GameController gc = new GameController(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Scanner sc = new Scanner(System.in);
        gc.startGame();

        while(true) {
            System.out.println("Again? y/n");
            String ans = sc.nextLine();
            if (ans.equals("y")) {
                System.out.println("0, 1, or 2 players?");
                String value = sc.nextLine();
                GameController newGame = new GameController(Integer.parseInt(value), Integer.parseInt(args[1]));
                newGame.startGame();
            } else {
                break;
            }
        }
        sc.close();
    }

}
