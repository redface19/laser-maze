package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Dummy extends Piece {

    public Dummy(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return true;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        laserPointer.move();
    }
}
