package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.PieceProperties;
import lasermaze.model.piece.common.Position;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Knight extends Piece {
    private static final Logger log = getLogger(Knight.class);

    public Knight(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (laserPointer.canRemove(position)) {
            laserPointer.removePiece();
            laserPointer.setEnd(true);
            return;
        }
        pieceProperties.reflect(laserPointer, position);
    }

}
