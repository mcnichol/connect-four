import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectFourTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private ConnectFour connectFour;

    @Before
    public void setUp() {
        connectFour = new ConnectFour();
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
     */

    @Test
    public void discsInsertedInEmptyColumnTakePositionZero() {
        Position expectedPosition = new Position(1, 0);

        Position actualPosition = connectFour.makeMove(1);

        assertThat(actualPosition, equalTo(expectedPosition));
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


}
