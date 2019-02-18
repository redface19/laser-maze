package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class King extends Piece {

    /* 이동, 회전, 파괴가능 */

    public King(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {

    }
}
