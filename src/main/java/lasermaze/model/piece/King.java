package lasermaze.model.piece;

import lasermaze.model.LaserPointer;

public class King extends Piece {

    /* 이동, 회전, 파괴가능 */

    public King(Playable playable) {
        super(playable);
    }


    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public boolean canDead() {
        /* hit 이호에 생존여부 거울기사같은 경우는 거울을 맞았을 경우 살수 있기 때문에 */
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {

    }
}
