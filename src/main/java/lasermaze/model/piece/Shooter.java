package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;

public class Shooter implements Shootable {

    @Override
    public LaserPointer shoot(Position position) {
        return new LaserPointer(position);
    }
}
