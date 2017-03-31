
public class ConnectFour {

    public static final int MAX_COLUMNS = 7;
    public static final int MAX_ROWS = 6;
    private int[] row = new int[7];
    private int numberOfDiscsPlayed = 0;

    public int getNumberOfDiscs() {
        return numberOfDiscsPlayed;
    }

    public Position makeMove(int column) {
        validateMove(column);

        numberOfDiscsPlayed++;

        return new Position(column, row[column]++);
    }

    private void validateMove(int column) {
        if (column > MAX_COLUMNS) {
            throw new IllegalGameMove("Outside the boundaries of game board");
        }else if (row[column] == MAX_ROWS) {
            throw new IllegalGameMove("Can only have six discs in a column");
        }
    }
}
