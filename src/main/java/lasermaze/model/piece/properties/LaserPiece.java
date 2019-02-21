package lasermaze.model.piece.properties;

import lasermaze.model.*;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;

public class LaserPiece extends CommonPlay {

    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        int rotatedDirection = direction.getRotatedDirection(rotation).getDirectionNumber();

        if ((direction.getDirectionNumber() == 1 || direction.getDirectionNumber() == 3) && rotatedDirection == 5 || rotatedDirection == 7) {
            throw new NotSupportedException("Laser cannot be rotated");
        }

        if ((direction.getDirectionNumber() == 5 || direction.getDirectionNumber() == 7) && rotatedDirection == 1 || rotatedDirection == 3) {
            throw new NotSupportedException("Laser cannot be rotated");
        }

        return Direction.getDirection(rotatedDirection);
    }
}
