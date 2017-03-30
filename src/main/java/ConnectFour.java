
public class ConnectFour {

    private int row = 0;
    private int numberOfDiscsPlayed = 0;

    public int getNumberOfDiscs() {
        return numberOfDiscsPlayed;
    }

    public Position makeMove(int column) {
        numberOfDiscsPlayed++;
        
        return new Position(column, row++);
    }
}
