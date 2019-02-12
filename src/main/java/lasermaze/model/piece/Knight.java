package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Knight extends Piece implements Pieceable {

    private Reflectable reflectable;
    private Playable playable;

    public Knight(Reflectable reflectable, Playable playable) {
        this.reflectable = reflectable;
        this.playable = playable;
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
