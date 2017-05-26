public class Board {
    private static final String EMPTY_BOARD_TOKEN = "\0";

    private String[][] boardState;
    private int row;

    Board(int row, int column) {
        this.row = row;
        this.boardState = new String[row][column];
        initializeEmptyBoard();
    }

    public String generateFormattedBoard() {
        StringBuilder formattedBoard = new StringBuilder();

        for (String[] row : boardState) {
            formattedBoard.append(generateFormattedRow(row));
            formattedBoard.append("\n-----------------------------");
        }

        return formattedBoard.toString();
    }

    private String generateFormattedRow(String[] row) {
        StringBuilder formattedRow = new StringBuilder();
        formattedRow.append("\n|");

        for (String cell : row) {
            formattedRow.append(" ").append(getCellValue(cell)).append(" |");
        }

        return formattedRow.toString();
    }

    void makeMove(Position position, String currentPlayer) {
        boardState[getCellDepth(position)][position.getColumn() - 1] = currentPlayer;
    }

    private String getCellValue(String cellToken) {
        return cellToken.equals(EMPTY_BOARD_TOKEN) ? " " : cellToken;
    }

    private int getCellDepth(Position position) {
        return (row - 1) - position.getDepth();
    }

    private void initializeEmptyBoard() {
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                boardState[i][j] = EMPTY_BOARD_TOKEN;
            }
        }
    }

    @Override
    public String toString() {
        return generateFormattedBoard();
    }

    public void makeMove(int column) {

    }
}
