package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Splitter extends Piece implements Reflectable, Penetable, Pieceable {

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
