package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Rotation;

public interface Playable {
    void move(Direction direction);
    void rotate(Rotation rotation);
}