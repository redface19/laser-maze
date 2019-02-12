package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;

public interface Reflectable {
    void reflect(LaserPointer laserPointer, Direction direction);
}
