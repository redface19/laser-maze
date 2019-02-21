package lasermaze.model;

import lasermaze.model.piece.King;
import lasermaze.model.piece.Laser;
import lasermaze.model.piece.Piece;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.NonLaserPiece;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class ChessSquareTest {

    private static final Logger log = LoggerFactory.getLogger(ChessSquareTest.class);

    ChessSquare chessSquare;

    @Before
    public void setUp() throws Exception {
        chessSquare = new ChessSquare(DOBY, BRAD);
    }

    @Test
    public void putSymmetryPieces() {
        chessSquare.putSymmetryPieces(BRAD, new King(DOBY, Direction.EAST, new Point(4, 0), new NonLaserPiece()));
    }

    @Test
    public void 왕_장기확인() {
        chessSquare.pieceInit();
        assertThat(chessSquare.getPiece(new Point(4, 0)) instanceof King).isTrue();
    }


    @Test
    public void getLaser() {
        chessSquare.pieceInit();
        Laser laser = chessSquare.getLaser(DOBY);
        assertThat(laser instanceof Laser).isTrue();
    }

    @Test
    public void getLaser2() {
        chessSquare.pieceInit();
        Laser laser = chessSquare.getLaser(BRAD);
        assertThat(laser instanceof Laser).isTrue();
    }

    @Test
    public void pieceInitTest() {
        chessSquare.pieceInit();
        log.debug("piece : {}", chessSquare.getPiece(new Point(4, 0)));
        assertThat(chessSquare.getPiece(new Point(4, 0)) instanceof King).isTrue();

    }
}