package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Laser extends Piece {

    public Laser(User user, PieceProperties pieceProperties) {
        super(user, pieceProperties);
    }

    public void shoot() {
        shootable.shoot(point, direction);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public boolean canDead() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }
}
