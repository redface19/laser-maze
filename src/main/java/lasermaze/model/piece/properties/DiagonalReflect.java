package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;

public class DiagonalReflect extends CommonReflect {

    private static DiagonalReflect diagonalReflect;

    private DiagonalReflect() {
    }

    public static DiagonalReflect getInstance() {
        if(diagonalReflect != null) return diagonalReflect;

        diagonalReflect = new DiagonalReflect();
        return diagonalReflect;
    }

    @Override
    public void reflect(LaserPointer laserPointer, Direction direction) {
        laserPointer.reflect(direction);
    }
}
