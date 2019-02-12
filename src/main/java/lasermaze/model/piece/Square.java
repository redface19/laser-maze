package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Square extends Piece implements Reflectable, Pieceable {

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
        reflect();
    }

    @Override
    public boolean canDead() {
        return false;
    }

    @Override
    public void reflect() {

    }
}
