package lasermaze.model.piece.properties;

import lasermaze.model.*;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.common.Rotation;

public class LaserPiece extends CommonPlay {

    @Override
    public void move(Position position, Direction direction) {
        throw new NotSupportedException("Laser Can not move");
    }

    @Override
    public void rotate(Position position, Rotation rotation) {
        Direction rotatedDirection = position.getRotatedDirection(rotation);
        if(position.isOutOfBound(rotatedDirection)) {
            throw new NotSupportedException("Laser cannot be rotated");
        }
        position.rotate(rotatedDirection);
    }
}
