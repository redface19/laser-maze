package lasermaze.model.game.piece.properties;

import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.Direction;

public class HorizontalReflect extends CommonReflect {

    private static HorizontalReflect horizontalReflect;

    private HorizontalReflect() {
    }

    public static HorizontalReflect getInstance() {
        if(horizontalReflect != null) return horizontalReflect;

        horizontalReflect = new HorizontalReflect();
        return horizontalReflect;
    }

    @Override
    public void reflect(LaserPointer laserPointer, Direction direction) {
        laserPointer.reflect(direction);
    }
}
