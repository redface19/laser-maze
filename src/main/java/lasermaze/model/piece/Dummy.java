package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.properties.CommonPlay;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;

public class Dummy extends Piece {

    public Dummy(User user, Position position, Playable playable) {
        super(user, position, playable);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }
}
