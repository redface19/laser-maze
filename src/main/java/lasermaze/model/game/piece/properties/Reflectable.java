package lasermaze.model.game.piece.properties;

import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.Direction;

public interface Reflectable {
    void reflect(LaserPointer laserPointer, Direction direction);
    boolean canDead(LaserPointer laserPointer, Direction direction);
}
