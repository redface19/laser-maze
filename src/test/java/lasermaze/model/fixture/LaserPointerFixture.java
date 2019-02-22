package lasermaze.model.fixture;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;

public class LaserPointerFixture {
    public static final LaserPointer LASER_POINTER1 = new LaserPointer(Direction.EAST, new Point(7, 0));
    public static final LaserPointer LASER_POINTER2 = new LaserPointer(Direction.WEST, new Point(0, 7));

    public static LaserPointer createLaserPointer(Direction direction, Point point) {
        return new LaserPointer(direction, point);
    }

    public static LaserPointer createEndLaserPointer(Direction direction, Point point) {
        LaserPointer laserPointer = createLaserPointer(direction, point);
        laserPointer.setEnd(true);
        return laserPointer;
    }
}
