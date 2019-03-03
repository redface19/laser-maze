package lasermaze.model.game.piece.properties;

import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.Direction;

public abstract class CommonReflect implements Reflectable{

    @Override
    public boolean canDead(LaserPointer laserPointer, Direction direction) {
        return !laserPointer.getDirection().isReflectable(direction);
    }
}
