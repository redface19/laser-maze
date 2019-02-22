package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;

public abstract class CommonReflect implements Reflectable{

    @Override
    public boolean canDead(LaserPointer laserPointer, Direction direction) {
        return !laserPointer.getDirection().isReflectable(direction);
    }
}
