import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void generateFormattedBoard_initialized_returnsEmptyBoard() throws Exception {
        Board board = new Board(6, 7);
        String expectedFormattedBoard =
                "|   |   |   |   |   |   |   |\n" +
                "-----------------------------\n" +
                "|   |   |   |   |   |   |   |\n" +
                "-----------------------------\n" +
                "|   |   |   |   |   |   |   |\n" +
                "-----------------------------\n" +
                "|   |   |   |   |   |   |   |\n" +
                "-----------------------------\n" +
                "|   |   |   |   |   |   |   |\n" +
                "-----------------------------\n" +
                "|   |   |   |   |   |   |   |\n" +
                "-----------------------------";

        String actualFormattedBoard = board.generateFormattedBoard();

        System.out.println(expectedFormattedBoard);
        assertThat(actualFormattedBoard, containsString(expectedFormattedBoard));
    }

    @Test
    public void makeMove_updatesBoardState() throws Exception {
        Board board = new Board(1, 7);

        board.makeMove(1);

//        assertThat(actual)
    }
}