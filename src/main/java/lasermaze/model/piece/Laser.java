package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.PieceProperties;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.properties.LaserPiece;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;

public class Laser extends Piece {

    public Laser(User user, Position position, Playable playable) {
        super(user, position, playable);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }


    public Position generateNewPosition() {
        return position.generateNewPosition();
    }
}
