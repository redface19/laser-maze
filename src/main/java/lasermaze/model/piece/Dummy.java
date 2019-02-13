package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Dummy extends Piece implements Penetable {

    public Dummy(User user, Playable playable) {
        super(user, playable);
    }

    @Override
    public boolean isDefaultChessPiece() {
        return true;
    }

    @Override
    public boolean canDead() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        penetrate(laserPointer);
    }

    @Override
    public void penetrate(LaserPointer laserPointer) {

    }
}
