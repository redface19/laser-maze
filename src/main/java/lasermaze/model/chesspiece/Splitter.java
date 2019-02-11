package lasermaze.model.chesspiece;

import lasermaze.model.LaserPointer;

public class Splitter extends ChessPiece implements Reflectable, Penetable, ChessPieceable {

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
        penetrate(laserPointer);
        reflect();
    }

    @Override
    public void reflect() {

    }

    @Override
    public void penetrate(LaserPointer laserPointer) {

    }
}
