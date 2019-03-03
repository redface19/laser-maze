package lasermaze.model.game.piece.properties;

import lasermaze.model.game.NotSupportedException;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Rotation;

public class LaserPiece extends CommonPlay {

    private static LaserPiece laserPiece;

    public static LaserPiece getInstance() {
        if(laserPiece != null) return laserPiece;

        laserPiece = new LaserPiece();
        return laserPiece;
    }

    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        int rotatedDirection = direction.getRotatedDirection(rotation, 2).getDirectionNumber();

        if ((direction.getDirectionNumber() == 1 || direction.getDirectionNumber() == 3) && rotatedDirection == 5 || rotatedDirection == 7) {
            throw new NotSupportedException("Laser cannot be rotated");
        }

        if ((direction.getDirectionNumber() == 5 || direction.getDirectionNumber() == 7) && rotatedDirection == 1 || rotatedDirection == 3) {
            throw new NotSupportedException("Laser cannot be rotated");
        }

        return Direction.getDirection(rotatedDirection);
    }
}
