package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.LaserPointer;
import lasermaze.model.Point;
import lasermaze.model.user.User;

public class Splitter extends Piece implements Penetable, Pieceable {

    private Reflectable reflectable;
    private Shootable shootable;

    public Splitter(User user, Position position, PieceProperties pieceProperties) {
        super(user, position, pieceProperties);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public boolean canDead() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        penetrate(laserPointer);
        reflectable.reflect(laserPointer, position);
    }

    @Override
    public void penetrate(LaserPointer laserPointer) {
        // 레이저 생성후 반사
        shootable.shoot(position);
    }
}
