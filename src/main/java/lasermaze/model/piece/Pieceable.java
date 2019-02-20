package lasermaze.model.piece;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Rotation;

public interface Pieceable {
    void hit(LaserPointer laserPointer);

    void move(Direction direction);

    void rotate(Rotation rotation);
}
