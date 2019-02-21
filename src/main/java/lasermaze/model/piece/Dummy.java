package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.properties.CommonPlay;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;

public class Dummy extends Piece {

    public Dummy(User user, Direction direction, Point point, Playable playable) {
        super(user, direction, point, playable);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }
}
