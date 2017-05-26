import java.io.PrintStream;

class ConnectFour {

    private static final int MAX_COLUMNS = 7;
    private static final int MAX_ROWS = 6;
    private static final String PLAYER_ONE = "R";
    private static final String PLAYER_TWO = "G";

    private Board board;
    private int[] columnDepth;
    private int numberOfDiscsPlayed;
    private String currentPlayer;
    private PrintStream output;

    ConnectFour(PrintStream output) {
        this.board = new Board(MAX_ROWS, MAX_COLUMNS);
        this.columnDepth = new int[MAX_ROWS];
        this.output = output;
        this.numberOfDiscsPlayed = 0;
        this.currentPlayer = PLAYER_ONE;
    }

    Position makeMove(int column) {
        validateMove(column);
        Position newPosition = populateBoardPosition(column);

        this.output.flush();
        this.output.println(board);
        swapCurrentPlayer();
        this.numberOfDiscsPlayed++;

        return newPosition;
    }

    private Position populateBoardPosition(int column) {
        Position position = new Position(column, columnDepth[column]++);
        board.makeMove(position, getCurrentPlayer());

        return position;
    }

    int getNumberOfDiscs() {
        return numberOfDiscsPlayed;
    }

    private void swapCurrentPlayer() {
        setCurrentPlayer(getCurrentPlayer().equals(PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE);
    }

    private void validateMove(int column) {
        if (column > MAX_COLUMNS) {
            throw new IllegalGameMove("Outside the boundaries of game board");
        } else if (columnDepth[column] == MAX_ROWS) {
            throw new IllegalGameMove("Can only have six discs in a column");
        }
    }

    String getCurrentPlayer() {
        output.flush();
        output.printf("Player %s turn", this.currentPlayer);

        return currentPlayer;
    }

    private void setCurrentPlayer(String nextPlayer) {
        currentPlayer = nextPlayer;
    }

    public boolean isFinished() {
        return false;
    }
}
