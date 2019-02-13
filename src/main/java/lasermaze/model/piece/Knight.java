package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Knight extends Piece implements Pieceable {

    private Reflectable reflectable;

    public Knight(Reflectable reflectable, Playable playable) {
        super(playable);
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
