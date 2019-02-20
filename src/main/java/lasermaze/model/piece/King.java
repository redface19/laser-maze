package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class King extends Piece {

    public King(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        laserPointer.removePiece();
        laserPointer.setEnd(true);
    }
}
