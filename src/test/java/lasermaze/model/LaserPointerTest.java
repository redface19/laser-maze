package lasermaze.model;

import lasermaze.model.fixture.LaserPointerFixture;
import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import org.junit.Test;
import org.slf4j.Logger;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LaserPointerTest {
    private static final Logger log = getLogger(LaserPointerTest.class);

    @Test
    public void move() {
        ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
        Board board = new Board(chessSquare);
        LaserPointer laserPointer = new LaserPointer(Direction.EAST, new Point(7, 0));
        laserPointer.move();
        log.debug("laserPoint : {}", laserPointer);
        log.debug("laser : {}", board.getPiece(new Point(7, 0)));
    }

    @Test
    public void removePiece() {
        ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
        Board board = new Board(chessSquare);
        LaserPointer laserPointer = new LaserPointer(Direction.EAST, new Point(3, 3));
        board.deletePiece(laserPointer);
        assertThat(board.getPiece(new Point(3, 3)) instanceof Dummy).isTrue();
    }
}