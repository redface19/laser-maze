package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;
import lasermaze.model.user.User;

public class Laser extends Piece {

    public Laser(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    public void shoot() {
        pieceProperties.shoot(position);
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
