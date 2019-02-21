package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;

public interface Reflectable {
    void reflect(LaserPointer laserPointer, Direction direction);
}
