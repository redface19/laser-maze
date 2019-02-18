package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Rotation;

public interface Pieceable {
    boolean isDefaultChessPiece();

    void hit(LaserPointer laserPointer);

    void move(Direction direction);

    void rotate(Rotation rotation);
}
