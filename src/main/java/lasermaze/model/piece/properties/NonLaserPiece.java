package lasermaze.model.piece.properties;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.piece.common.Position;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class NonLaserPiece extends CommonPlay {
    private static final Logger log = getLogger(NonLaserPiece.class);

    @Override
    public void move(Position position, Direction direction) {
        position.move(direction);
    }

    @Override
    public void rotate(Position position, Rotation rotation) {
        position.rotate(position.getRotatedDirection(rotation));
        // 시계 방향 num - 8
        // 반시계 num + 8
    }

}
