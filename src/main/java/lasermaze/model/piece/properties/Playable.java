package lasermaze.model.piece.properties;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;

public interface Playable {
    void move(Point point, Direction direction);
    Direction rotate(Direction direction, Rotation rotation);
}
