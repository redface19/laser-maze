package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public interface Pieceable {
    boolean isDefaultChessPiece();
    boolean canDead();
    void hit(LaserPointer laserPointer);
}
