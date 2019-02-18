package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class DiagonalReflect implements Reflectable {
    @Override
    public void reflect(LaserPointer laserPointer, Position position) {

    }

    @Override
    public boolean canDead(LaserPointer laserPointer, Position position) {
        return false;
    }
}
