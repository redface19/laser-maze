package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;

public interface Penetable {
    void penetrate(LaserPointer laserPointer, Position position);
}
