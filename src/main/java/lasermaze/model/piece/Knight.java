package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Knight extends Piece implements Pieceable {

    public Knight(User user, PieceProperties pieceProperties) {
        super(user, pieceProperties);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (canDead()) {
            terminated();
            return;
        }
        reflectable.reflect(laserPointer, direction);
    }

    @Override
    public boolean canDead() {
        return false;
    }

}
