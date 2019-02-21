package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Point;

public interface Penetable {
    void penetrate(LaserPointer laserPointer, Point point);
}
