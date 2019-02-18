package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Laser extends Piece {

    public Laser(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    public void shoot(Board board) {
        pieceProperties.shoot(board, position);
    }

    @Override
    public void hit(LaserPointer laserPointer) {
    }
}
