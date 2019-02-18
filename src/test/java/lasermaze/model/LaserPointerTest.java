package lasermaze.model;

import lasermaze.model.piece.Position;
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
        Board board = new Board(DOBY, BRAD);
        LaserPointer laserPointer = new LaserPointer(board, new Position(Direction.EAST, new Point(7, 0)));
        laserPointer.move();
        log.debug("laserPoint : {}", laserPointer);
    }
}