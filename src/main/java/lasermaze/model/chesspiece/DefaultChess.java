package lasermaze.model.chesspiece;

import lasermaze.model.LaserPointer;

public class DefaultChess extends ChessPiece implements Penetable {

    @Override
    public boolean isDefaultChessPiece() {
        return true;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        penetrate(laserPointer);
    }

    @Override
    public void penetrate(LaserPointer laserPointer) {

    }
}
