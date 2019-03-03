package lasermaze.model.game.piece;

import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.Rotation;

public interface Pieceable {
    void hit(LaserPointer laserPointer);

    void move(Direction direction);

    void rotate(Rotation rotation);
}
