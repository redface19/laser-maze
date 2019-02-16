package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public interface Shootable {
    LaserPointer shoot(Position position);
}
