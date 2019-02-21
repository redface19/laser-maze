package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.*;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Knight extends Piece {
    private static final Logger log = getLogger(Knight.class);

    private Reflectable reflectable;

    public Knight(User user, Direction direction, Point point, Playable playable, Reflectable reflectable) {
        super(user, direction, point, playable);
        this.reflectable = reflectable;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (laserPointer.canRemove(position)) {
            laserPointer.removePiece();
            laserPointer.setEnd(true);
            return;
        }
//        pieceProperties.reflect(laserPointer, position);
    }
}
