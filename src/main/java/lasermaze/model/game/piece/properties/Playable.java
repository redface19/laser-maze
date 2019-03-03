package lasermaze.model.game.piece.properties;

import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.piece.common.Rotation;

public interface Playable {
    void move(Point point, Direction direction);
    Direction rotate(Direction direction, Rotation rotation);
}
