package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.user.User;

public class Laser extends Piece {

    private Shootable shootable;

    public Laser(User user, Shootable shootable, Playable playable) {
        super(user, playable);
        this.shootable = shootable;
    }

    public void shoot() {
        shootable.shoot(point, direction);
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
    }
}
