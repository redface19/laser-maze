package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.piece.common.PieceProperties;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Splitter extends Piece {

    private static final Logger log = LoggerFactory.getLogger(Splitter.class);

    private Reflectable reflectable;

    public Splitter(User user, Position position, Playable playable, Reflectable reflectable) {
        super(user, position, playable);
        this.reflectable = reflectable;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (laserPointer.canRemove(position)) {
            position.rotate(position.getRotatedDirection(Rotation.COUNTERCLOCKWISE).getRotatedDirection(Rotation.COUNTERCLOCKWISE));
        }
        log.debug("laser Pointer : {}", laserPointer);
        log.debug("position : {}", position);
        reflectable.reflect(laserPointer, position);
    }
}
