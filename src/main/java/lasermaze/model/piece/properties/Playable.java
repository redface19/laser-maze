package lasermaze.model.piece.properties;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.piece.common.Position;

public interface Playable {
    void move(Position position, Direction direction);
    void rotate(Position position, Rotation rotation);
}
