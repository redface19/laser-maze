package lasermaze.model.piece;

import lasermaze.model.*;

public class LaserPiece extends CommonPlay {

    @Override
    public void move(Point point, Direction direction) {
        throw new NotSupportedException("Laser Can not move");
    }

    @Override
    public void rotate(Point point, Direction direction, Rotation rotation) {
        Direction rotatedDirection = direction.getRotatedDirection(rotation);
        if(Command.hasBarrier(point, rotatedDirection)) {
            throw new NotSupportedException("Laser cannot be rotated");
        }

    }
}
