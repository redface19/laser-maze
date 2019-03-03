package lasermaze.model.game.piece;

import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.piece.properties.Playable;
import lasermaze.model.game.user.GameUser;

public class Dummy extends Piece {
    public Dummy(GameUser gameUser, Direction direction, Point point, Playable playable) {
        super(gameUser, direction, point, playable);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }
}
