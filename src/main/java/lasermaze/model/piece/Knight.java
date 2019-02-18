package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Knight extends Piece {

    public Knight(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (canDead()) {
//            terminated();
            return;
        }
        pieceProperties.reflect(laserPointer, position);
    }

    @Override
    public boolean canDead() {
        return false;
    }

}
