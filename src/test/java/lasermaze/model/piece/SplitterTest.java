package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.common.PropertyBundle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;

public class SplitterTest {

    private static final Logger log = LoggerFactory.getLogger(SplitterTest.class);

    @Test
    public void hitTest1() {
        Splitter splitter = new Splitter(DOBY, new Position(Direction.NORTHEAST, new Point(3,3 ))
                , PropertyBundle.SPLITTER_PROPRTY.getProperty());
        Board board = new Board(DOBY, BRAD);
        LaserPointer laserPointer = new LaserPointer(board, new Position(Direction.NORTH, new Point(3,3 )));
        splitter.hit(laserPointer);

        log.debug("Laser Pointer Direction : {}", laserPointer); // west
        log.debug("Piece Pointer Direction : {}", splitter);
    }

    @Test
    public void hitTest2() {
        Splitter splitter = new Splitter(DOBY, new Position(Direction.SOUTHWEST, new Point(1,1 ))
                , PropertyBundle.SPLITTER_PROPRTY.getProperty());
        Board board = new Board(DOBY, BRAD);
        LaserPointer laserPointer = new LaserPointer(board, new Position(Direction.SOUTH, new Point(1,1 )));
        splitter.hit(laserPointer);

        Splitter targetPiece = new Splitter(DOBY, new Position(Direction.SOUTHWEST, new Point(1,1 ))
                , PropertyBundle.SPLITTER_PROPRTY.getProperty());
        LaserPointer targetPointer = new LaserPointer(board, new Position(Direction.EAST, new Point(1,1 )));

        log.debug("Laser Pointer Direction : {}", laserPointer);
        log.debug("Piece Pointer Direction : {}", splitter);
    }
}