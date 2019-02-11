package lasermaze.model.chesspiece;

import lasermaze.model.LaserPointer;

public interface ChessPieceable {
    boolean isDefaultChessPiece();
    boolean canDead();
    void hit(LaserPointer laserPointer);
}
