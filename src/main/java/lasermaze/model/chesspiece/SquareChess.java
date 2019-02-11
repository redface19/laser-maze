package lasermaze.model.chesspiece;

import lasermaze.model.LaserPointer;

public class SquareChess extends ChessPiece implements Reflectable, ChessPieceable {

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
