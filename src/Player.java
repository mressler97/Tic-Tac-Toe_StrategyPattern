import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Player implements iPlayers{

    Scanner sc = new Scanner(System.in);
    private String symbol;
    public Boolean goesFirst;

    public void play(List<String> board, List<Integer> movesLeft) {

        System.out.print("Your move => ");
        String move = sc.nextLine();

        while (!board.contains(move)) {
            System.out.println("Invalid move silly!\n");
            System.out.print("Your move => ");
            move = sc.nextLine();
        }
        board.set(Integer.parseInt(move)-1, symbol);

        Iterator<Integer> itr = movesLeft.iterator();
        while (itr.hasNext())
        {
            String x = String.valueOf(itr.next());
            if (x.equals(move))
                itr.remove();
        }
        checkWin(board);

    }

    public Boolean checkWin(List<String> board) {
        return (board.get(0).equals(symbol) && board.get(1).equals(symbol) && board.get(2).equals(symbol))     // top row
                | (board.get(3).equals(symbol) && board.get(4).equals(symbol) && board.get(5).equals(symbol))   // middle row
                | (board.get(6).equals(symbol) && board.get(7).equals(symbol) && board.get(8).equals(symbol))   // bottom row
                | (board.get(0).equals(symbol) && board.get(3).equals(symbol) && board.get(6).equals(symbol))   // first col
                | (board.get(1).equals(symbol) && board.get(4).equals(symbol) && board.get(7).equals(symbol))   // second col
                | (board.get(2).equals(symbol) && board.get(5).equals(symbol) && board.get(8).equals(symbol))   // third col
                | (board.get(0).equals(symbol) && board.get(4).equals(symbol) && board.get(8).equals(symbol))   // diagonal
                | (board.get(2).equals(symbol) && board.get(4).equals(symbol) && board.get(6).equals(symbol));  // diagonal
    }

    @Override
    public void setSymbol() {
        if (this.goesFirst) {
            this.symbol = "x";
        } else {
            this.symbol = "o";
        }
    }

    @Override
    public void setGoFirst(boolean b) {
        this.goesFirst = b;
    }
}
