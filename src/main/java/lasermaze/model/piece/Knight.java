package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.PieceProperties;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Knight extends Piece {
    private static final Logger log = getLogger(Knight.class);

    private Reflectable reflectable;

    public Knight(User user, Position position, Playable playable, Reflectable reflectable) {
        super(user, position, playable);
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
