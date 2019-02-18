package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Point;
import org.junit.Test;
import org.slf4j.Logger;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class PositionTest {
    private static final Logger log = getLogger(PositionTest.class);

    @Test
    public void reflect() {
        Position laserPosition = new Position(Direction.EAST, new Point(7, 4));
        Position piecePosition = new Position(Direction.NORTHWEST, new Point(7, 4));
        laserPosition.reflect(piecePosition);
        log.debug(laserPosition.toString());
    }
}