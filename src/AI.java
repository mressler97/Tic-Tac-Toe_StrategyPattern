import java.util.List;
import java.util.Random;

public class AI implements iPlayers{

    private String symbol;
    public Boolean goesFirst;
    Random rand = new Random();

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

    public void play(List<String> board, List<Integer> movesLeft) {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        if (!movesLeft.isEmpty()) {
            int randomIndex = rand.nextInt(movesLeft.size());
            int move = movesLeft.get(randomIndex);
            movesLeft.remove(randomIndex);
            System.out.println("AI move: " + move);
            board.set(move - 1, symbol);
            checkWin(board);
        }

    }


    public Boolean checkWin(List<String> board) {
        return (board.get(0).equals(symbol) && board.get(1).equals(symbol) && board.get(2).equals(symbol))     // top row
                | (board.get(3).equals(symbol) && board.get(4).equals(symbol) && board.get(5).equals(symbol))   // middle row
                | (board.get(6).equals(symbol) && board.get(7).equals(symbol) && board.get(8).equals(symbol))   // bottom row
                | (board.get(0).equals(symbol) && board.get(3).equals(symbol) && board.get(6).equals(symbol))   // first col
                | (board.get(1).equals(symbol) && board.get(4).equals(symbol) && board.get(7).equals(symbol))   // second col
                | (board.get(2).equals(symbol) && board.get(5).equals(symbol) && board.get(8).equals(symbol))   // third col
                | (board.get(0).equals(symbol) && board.get(4).equals(symbol) && board.get(8).equals(symbol))   //diag
                | (board.get(2).equals(symbol) && board.get(4).equals(symbol) && board.get(6).equals(symbol));
    }
}
