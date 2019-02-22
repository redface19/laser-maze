package lasermaze.model.piece.properties;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class NonLaserPiece extends CommonPlay {
    private static final Logger log = getLogger(NonLaserPiece.class);

    private static NonLaserPiece nonLaserPiece;

    private NonLaserPiece() {
    }

    public static NonLaserPiece getInstance() {
        if(nonLaserPiece != null) return nonLaserPiece;

        nonLaserPiece = new NonLaserPiece();
        return nonLaserPiece;
    }

    @Override
    public void move(Point point, Direction direction) {
        point.move(direction);
    }

    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        return direction.getRotatedDirection(rotation, 2);
    }

}
