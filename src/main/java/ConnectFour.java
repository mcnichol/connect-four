
public class ConnectFour {

    private static final int MAX_COLUMNS = 7;
    private static final int MAX_ROWS = 6;
    private static final String PLAYER_ONE = "R";
    private static final String PLAYER_TWO = "G";


    private int[] row = new int[7];
    private int numberOfDiscsPlayed = 0;
    private String currentPlayer = PLAYER_ONE;

    int getNumberOfDiscs() {
        return numberOfDiscsPlayed;
    }

    Position makeMove(int column) {
        validateMove(column);

        swapCurrentPlayer();
        numberOfDiscsPlayed++;

        return new Position(column, row[column]++);
    }

    private void swapCurrentPlayer() {
        setCurrentPlayer(getCurrentPlayer().equals(PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE);
    }

    private void validateMove(int column) {
        if (column > MAX_COLUMNS) {
            throw new IllegalGameMove("Outside the boundaries of game board");
        }else if (row[column] == MAX_ROWS) {
            throw new IllegalGameMove("Can only have six discs in a column");
        }
    }

    String getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(String nextPlayer) {
        currentPlayer = nextPlayer;
    }
}
