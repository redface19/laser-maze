package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public interface Penetable {
    void penetrate(LaserPointer laserPointer);
}
