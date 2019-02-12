package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;

public interface Shootable {
    LaserPointer shoot(Point point, Direction direction);
}
