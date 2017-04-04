import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ConnectFourTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private ConnectFour connectFour;
    private OutputStream output;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        connectFour = new ConnectFour(new PrintStream(output));
    }

    /* Requirement 1:
     * The board is composed of seven columns and six rows, all positions are empty.
     */

    @Test
    public void initializesWithEmptySixBySevenGameBoard() {
        assertThat(connectFour.getNumberOfDiscs(), equalTo(0));
    }

    /* Requirement 2:
     * Players introduce discs on the top of the columns.
     * An introduced disc drops down the board if the column is empty.
     * Future discs introduced in the same column will stack over the previous ones.
     * Throws errors when introduced outside of boundaries
     */

    @Test
    public void discsInsertedInEmptyColumnTakePositionZero() {
        Position expectedPosition = new Position(1, 0);

//        Position actualPosition = connectFour.makeMove(1);
//
//        assertThat(actualPosition, equalTo(expectedPosition));
    }

    @Test
    public void discsInsertedInColumnWithOneDiscTakePositionOne() {
        Position expectedPosition = new Position(1, 1);
        connectFour.makeMove(1);

        Position actualPosition = connectFour.makeMove(1);

        assertThat(actualPosition, equalTo(expectedPosition));
    }

    @Test
    public void discCanBeInsertedIntoColumnsOtherThanOne() {
        Position expectedPosition = new Position(2, 0);

        Position actualPosition = connectFour.makeMove(2);

        assertThat(actualPosition, equalTo(expectedPosition));
    }

    @Test
    public void eachColumnHasIndependentCountOfDiscsInStack() {
        Position expectedPosition = new Position(2, 0);

        connectFour.makeMove(1);
        Position actualPosition = connectFour.makeMove(2);

        assertThat(actualPosition, equalTo(expectedPosition));
    }

    @Test
    public void discInsertedIncreasesTotalDiscsOnBoard() {
        connectFour.makeMove(1);
        connectFour.makeMove(1);
        connectFour.makeMove(1);

        assertThat(connectFour.getNumberOfDiscs(), equalTo(3));
    }

    @Test
    public void discPlacedOutsideBoundariesThrowsRuntimeException() {
        exception.expect(IllegalGameMove.class);
        connectFour.makeMove(8);
    }

    @Test
    public void discInsertedInFullColumnThrowsRuntimeException() {
        connectFour.makeMove(1);
        connectFour.makeMove(1);
        connectFour.makeMove(1);
        connectFour.makeMove(1);
        connectFour.makeMove(1);
        connectFour.makeMove(1);

        exception.expect(IllegalGameMove.class);
        connectFour.makeMove(1);
    }

    /*
     *  Requirement 3:
     *  It is a two-person game, so there is one colour for each player.
     *  One player uses red ('R') and the other one uses green ('G').
     *  Players alternate turns, inserting one disc every time.
     */

    @Test
    public void playerOneIsRed() throws Exception {
        String expectedPlayer = "R";

        String actualPlayer = connectFour.getCurrentPlayer();

        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void playerTwoIsGreen() throws Exception {
        String expectedPlayer = "G";
        connectFour.makeMove(1);

        String actualPlayer = connectFour.getCurrentPlayer();

        assertEquals(expectedPlayer, actualPlayer);
    }

    /*  Requirement 4:
     *  We want feedback when either an event or an error occurs
     *  within the game. The output shows the status of the
     *  board on every move.
     */

    @Test
    public void getCurrentPlayer_printsPlayerToOutputStream() throws Exception {
        connectFour.getCurrentPlayer();

        assertThat(output.toString(), containsString("Player R turn"));
    }

    @Test
    public void makeMove_printsBoardPositionToOutputStream() throws Exception {
        connectFour.makeMove(1);

        assertThat(output.toString(), containsString("| R |   |   |   |   |   |   |"));
    }
}
