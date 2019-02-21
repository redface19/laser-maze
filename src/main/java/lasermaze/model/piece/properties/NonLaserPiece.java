package lasermaze.model.piece.properties;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class NonLaserPiece extends CommonPlay {
    private static final Logger log = getLogger(NonLaserPiece.class);

    @Override
    public void move(Point point, Direction direction) {
        point.move(direction);
    }

    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        return direction.getRotatedDirection(rotation);
        // 시계 방향 num - 8
        // 반시계 num + 8
    }

}
