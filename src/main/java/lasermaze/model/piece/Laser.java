package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;
import lasermaze.model.user.User;

public class Laser extends Piece {

    public Laser(User user, Point point, Direction direction, PieceProperties pieceProperties) {
        super(user, point, direction, pieceProperties);
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
