public class Board {
    private String[][] boardState;

    Board(int maxColumns, int maxRows) {
        boardState = new String[maxRows][maxColumns];

        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                boardState[i][j] = "\0";
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = generatedFormattedRow();

        return sb.toString();
    }

    private StringBuilder generatedFormattedRow() {
        StringBuilder formattedRow = new StringBuilder();
        for (String[] row : boardState) {
            generateCell(formattedRow, row);
            formattedRow.append("\n-----------------------------");
        }
        return formattedRow;
    }

    private void generateCell(StringBuilder formattedRow, String[] row) {
        formattedRow.append("\n|");

        for (String column : row) {
            formattedRow.append(" ").append(getValue(column)).append(" |");
        }
    }

    private String getValue(String s) {
        return s.equals("\0") ? " " : s;
    }

    void makeMove(Position position, String currentPlayer) {
        boardState[position.getColumn()][position.getRow()] = currentPlayer;
    }
}
