package lasermaze.model.piece;

import lasermaze.model.*;

public class LaserPiece extends CommonPlay {

    @Override
    public void move(Position position, Direction direction) {
        throw new NotSupportedException("Laser Can not move");
    }

    @Override
    public void rotate(Position position, Rotation rotation) {
        Direction rotatedDirection = position.getRotatedDirection(rotation);
        if(position.hasBarrier(rotatedDirection)) {
            throw new NotSupportedException("Laser cannot be rotated");
        }
        position.rotate(rotatedDirection);
    }
}
