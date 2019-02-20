package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;

public interface Reflectable {
    void reflect(LaserPointer laserPointer, Position position);
}
