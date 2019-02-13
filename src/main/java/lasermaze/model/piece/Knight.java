package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Knight extends Piece implements Pieceable {

    private Reflectable reflectable;

    public Knight(User user, Reflectable reflectable, Playable playable) {
        super(user, playable);
        this.reflectable = reflectable;
    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (canDead()) {
            terminated();
            return;
        }
        reflectable.reflect(laserPointer, direction);
    }

    @Override
    public boolean canDead() {
        return false;
    }

}
