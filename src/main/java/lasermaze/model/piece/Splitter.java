package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Splitter extends Piece {

    public Splitter(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        pieceProperties.penetrate(laserPointer, position);
        pieceProperties.reflect(laserPointer, position);
    }

}
