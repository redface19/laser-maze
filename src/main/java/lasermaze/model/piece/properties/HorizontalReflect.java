package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;

public class HorizontalReflect implements Reflectable {

    @Override
    public void reflect(LaserPointer laserPointer, Position piecePosition) {
        laserPointer.reflect(piecePosition);
    }
}
