package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;

public interface Playable {
    void move(Position position, Direction direction);
    void rotate(Position position, Rotation rotation);
}
