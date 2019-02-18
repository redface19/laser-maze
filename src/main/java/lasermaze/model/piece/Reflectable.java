package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public interface Reflectable {
    void reflect(LaserPointer laserPointer, Position position);
}
