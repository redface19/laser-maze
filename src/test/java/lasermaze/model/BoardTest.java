package lasermaze.model;

import lasermaze.model.piece.King;
import lasermaze.model.piece.NonLaserPiece;
import lasermaze.model.piece.Position;
import lasermaze.model.piece.PropertyBundle;
import org.junit.Before;
import org.junit.Test;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(DOBY, BRAD);
    }

    @Test
    public void putSymmetryPieces() {
        board.putSymmetryPieces(4, 0, BRAD, new King(DOBY, new Position(Direction.EAST, new Point(4, 0)), PropertyBundle.KING_PROPRTY.getProperty()));
    }

    @Test
    public void 왕_장기확인() {
        assertThat(board.getChessSquare(4, 0) instanceof King).isTrue();
    }

    @Test
    public void getOpposite() {
        assertThat(board.getOpposite(3)).isEqualTo(4);
    }

    @Test
    public void getOpposite2() {
        assertThat(board.getOpposite(1)).isEqualTo(6);
    }

}