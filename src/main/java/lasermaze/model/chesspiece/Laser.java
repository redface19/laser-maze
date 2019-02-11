package lasermaze.model.chesspiece;

import lasermaze.model.LaserPointer;

public class Laser extends ChessPiece {

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
