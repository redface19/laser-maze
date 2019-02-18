package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Knight extends Piece {
    private static final Logger log = getLogger(Knight.class);

    public Knight(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        log.debug("삼각기사 도착");
//            terminated();
        pieceProperties.reflect(laserPointer, position);
    }

}
