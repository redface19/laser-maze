package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;

public class HorizontalReflect implements Reflectable {

    @Override
    public void reflect(LaserPointer laserPointer, Direction direction) {
        laserPointer.reflect(direction);
    }
}
