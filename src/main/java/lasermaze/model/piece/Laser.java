package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Laser extends Piece {

    private Shootable shootable;

    public Laser(Shootable shootable, Playable playable) {
        super(playable);
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
