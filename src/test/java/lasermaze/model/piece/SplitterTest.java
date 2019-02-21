package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.ChessSquare;
import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.DiagonalReflect;
import lasermaze.model.piece.properties.NonLaserPiece;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;

public class SplitterTest {

    private static final Logger log = LoggerFactory.getLogger(SplitterTest.class);

    @Test
    public void hitTest1() {
        Splitter splitter = new Splitter(DOBY, Direction.NORTHEAST, new Point(3,3 ), new NonLaserPiece(), new DiagonalReflect());
        ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
        Board board = new Board(chessSquare);
        LaserPointer laserPointer = new LaserPointer(Direction.NORTH, new Point(3,3 ));
        splitter.hit(laserPointer);

        log.debug("Laser Pointer Direction : {}", laserPointer); // west
        log.debug("Piece Pointer Direction : {}", splitter);
    }

    @Test
    public void hitTest2() {Splitter splitter = new Splitter(DOBY, Direction.SOUTHWEST, new Point(1,1 ), new NonLaserPiece(), new DiagonalReflect());
        ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
        Board board = new Board(chessSquare);
        LaserPointer laserPointer = new LaserPointer(Direction.SOUTH, new Point(1,1 ));
        splitter.hit(laserPointer);

        Splitter targetPiece = new Splitter(DOBY, Direction.SOUTHWEST, new Point(1,1 ), new NonLaserPiece(), new DiagonalReflect());

        LaserPointer targetPointer = new LaserPointer(Direction.EAST, new Point(1,1 ));

        log.debug("Laser Pointer Direction : {}", laserPointer);
        log.debug("Piece Pointer Direction : {}", splitter);
    }
}