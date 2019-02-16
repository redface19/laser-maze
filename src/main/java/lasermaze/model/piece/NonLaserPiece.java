package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.NotSupportedException;
import lasermaze.model.Point;
import lasermaze.model.Rotation;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class NonLaserPiece extends CommonPlay {
    private static final Logger log = getLogger(NonLaserPiece.class);

    @Override
    public void move(Point point, Direction direction) {
        point.move(direction);
    }

    @Override
    public void rotate(Direction direction, Rotation rotation) {

    }

}
