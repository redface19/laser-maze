package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Laser extends Piece {

    public void shoot() {
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
