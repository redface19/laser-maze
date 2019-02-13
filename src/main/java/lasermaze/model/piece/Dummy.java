package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Dummy extends Piece implements Penetable {
    
    public Dummy(Playable playable) {
        super(playable);
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
