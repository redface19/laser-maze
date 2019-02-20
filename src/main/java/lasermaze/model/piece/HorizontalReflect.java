package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class HorizontalReflect implements Reflectable {

    @Override
    public void reflect(LaserPointer laserPointer, Position piecePosition) {
        laserPointer.reflect(piecePosition);
    }
}
