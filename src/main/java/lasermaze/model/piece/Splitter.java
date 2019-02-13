package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class Splitter extends Piece implements Penetable, Pieceable {

    private Reflectable reflectable;
    private Shootable shootable;

    public Splitter(Reflectable reflectable, Shootable shootable, Playable playable) {
        super(playable);
        this.reflectable = reflectable;
        this.shootable = shootable;
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
        reflectable.reflect(laserPointer, direction);
    }

    @Override
    public void penetrate(LaserPointer laserPointer) {
        // 레이저 생성후 반사
        shootable.shoot(point, direction);
    }
}
