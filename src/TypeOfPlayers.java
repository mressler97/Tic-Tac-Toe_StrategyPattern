import java.util.List;

public class TypeOfPlayers {

    private iPlayers strategy;
    public Boolean goesFirst;

    public void setPlayerStrategy(iPlayers strategy) {
        this.strategy = strategy;
    }

    public void play(List<String> board, List<Integer> movesLeft) {
        strategy.play(board, movesLeft);
    }

    public Boolean checkWin(List<String> board) {
        return strategy.checkWin(board);
    }

    public void setSymbol() {
        strategy.setSymbol();
    }


    public void setGoFirst(boolean b) {
        this.goesFirst = b;
        strategy.setGoFirst(b);
    }
}
