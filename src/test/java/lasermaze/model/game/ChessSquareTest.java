package lasermaze.model.game;

import lasermaze.model.fixture.PieceFixture;
import lasermaze.model.game.piece.Dummy;
import lasermaze.model.game.piece.King;
import lasermaze.model.game.piece.Laser;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.piece.properties.NonLaserPiece;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lasermaze.model.game.user.UserTest.BRAD;
import static lasermaze.model.game.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class ChessSquareTest {
    private static final Logger log = LoggerFactory.getLogger(ChessSquareTest.class);

    public static final ChessSquare CHESS_SQUARE = new ChessSquare(DOBY, BRAD);

    @Test
    public void putSymmetryPieces() {
        CHESS_SQUARE.putSymmetryPieces(BRAD, new King(DOBY, Direction.EAST, new Point(4, 0), NonLaserPiece.getInstance()));
        Point point = new Point(3, 7);
        assertThat(CHESS_SQUARE.getPiece(point)).isEqualTo(PieceFixture.createKing(BRAD, Direction.WEST, point));
    }

    @Test
    public void 왕_장기확인() {
        CHESS_SQUARE.pieceInit();
        assertThat(CHESS_SQUARE.getPiece(new Point(4, 0)) instanceof King).isTrue();
    }


    @Test
    public void getLaser() {
        CHESS_SQUARE.pieceInit();
        Laser laser = CHESS_SQUARE.getLaser(DOBY);
        assertThat(laser instanceof Laser).isTrue();
    }

    @Test
    public void getLaser2() {
        CHESS_SQUARE.pieceInit();
        Laser laser = CHESS_SQUARE.getLaser(BRAD);
        assertThat(laser instanceof Laser).isTrue();
    }

    @Test
    public void pieceInitTest() {
        CHESS_SQUARE.pieceInit();
        log.debug("piece : {}", CHESS_SQUARE.getPiece(new Point(4, 0)));
        assertThat(CHESS_SQUARE.getPiece(new Point(4, 0)) instanceof King).isTrue();
    }

    @Test
    public void swap() {
        ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
        chessSquare.pieceInit();
        chessSquare.swap(new Point(3, 7), Direction.WEST);
        assertThat(chessSquare.getPiece(new Point(3, 6)) instanceof King).isTrue();
        assertThat(chessSquare.getPiece(new Point(3, 7)) instanceof Dummy).isTrue();
    }
}