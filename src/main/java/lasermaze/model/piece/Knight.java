package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;
import lasermaze.model.user.User;

public class Knight extends Piece implements Pieceable {

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
