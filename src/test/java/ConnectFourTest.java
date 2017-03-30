import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectFourTest {

    private ConnectFour connectFour;

    @Before
    public void setUp() throws Exception {
        connectFour = new ConnectFour();
    }

    /* Requirement 1:
     * The board is composed of seven columns and six rows, all positions are empty.
     */

    @Test
    public void initializesWithEmptySixBySevenGameBoard() throws Exception {
        assertThat(connectFour.getNumberOfDiscs(), equalTo(0));
    }

    /* Requirement 2:
     * Players introduce discs on the top of the columns.
     * An introduced disc drops down the board if the column is empty.
     * Future discs introduced in the same column will stack over the previous ones.
     */

    @Test
    public void discsInsertedInEmptyColumnTakePositionZero() throws Exception {
        Position expectedPosition = new Position(1, 0);

        Position actualPosition = connectFour.makeMove(1);

        assertThat(actualPosition, equalTo(expectedPosition));
    }

    @Test
    public void discsInsertedInColumnWithOneDiscTakePositionOne() throws Exception {

    }

    // When a disc is inserted into the board, the total number of discs increases
    @Test
    public void discInsertedIncreasesTotalDiscsOnBoard() throws Exception {

    }

    // When a disc is put outside the boundaries, a Runtime Exception is thrown
    @Test
    public void discPlacedOutsideBoundariesThrowsRuntimeException() throws Exception {

    }

    // When a disc is inserted in to a column and there's no room available for it, then a Runtime Exception is thrown
    @Test
    public void discInsertedInFullColumnThrowsRuntimeException() throws Exception {

    }


}
