import java.util.List;

public interface iPlayers {
    void play(List<String> board, List<Integer> movesLeft);

    Boolean checkWin(List<String> board);

    void setSymbol();

    void setGoFirst(boolean b);
}
