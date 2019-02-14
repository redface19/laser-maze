package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public interface Penetable extends Property {
    void penetrate(LaserPointer laserPointer);
}
