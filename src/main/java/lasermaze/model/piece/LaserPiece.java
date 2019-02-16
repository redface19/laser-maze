package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.NotSupportedException;
import lasermaze.model.Point;
import lasermaze.model.Rotation;

public class LaserPiece extends CommonPlay {

    @Override
    public void move(Point point, Direction direction) {
        throw new NotSupportedException("Laser Can not move");
    }

    @Override
    public void rotate(Direction direction, Rotation rotation) {
        Direction rotatedDirection = direction.getRotatedDirection(rotation);
    }
}
