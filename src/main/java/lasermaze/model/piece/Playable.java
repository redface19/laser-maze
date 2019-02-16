package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;

public interface Playable {
    void move(Point point, Direction direction);
    void rotate(Point point, Direction direction, Rotation rotation);
}
