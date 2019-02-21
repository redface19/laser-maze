package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;

public class King extends Piece {

    public King(User user, Direction direction, Point point, Playable playable) {
        super(user, direction, point, playable);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        laserPointer.removePiece();
        laserPointer.setEnd(true);
    }
}
