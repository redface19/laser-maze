package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;

public class Laser extends Piece {

    public Laser(User user, Direction direction, Point point, Playable playable) {
        super(user, direction, point, playable);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }


    public LaserPointer generateLaserPointer() {
        return new LaserPointer(direction, point.generateNewPoint());
    }
}
