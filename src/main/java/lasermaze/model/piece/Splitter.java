package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;
import lasermaze.model.Rotation;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Splitter extends Piece {

    private static final Logger log = LoggerFactory.getLogger(Splitter.class);

    public Splitter(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
//        pieceProperties.penetrate(laserPointer, position);

        if (laserPointer.canRemove(position)) {
            position.rotate(position.getRotatedDirection(Rotation.COUNTERCLOCKWISE).getRotatedDirection(Rotation.COUNTERCLOCKWISE));
        }
        log.debug("laser Pointer : {}", laserPointer);
        log.debug("position : {}", position);
        pieceProperties.reflect(laserPointer, position);
    }
}
