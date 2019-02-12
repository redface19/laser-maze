package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Rotation;

public class NonLaserable implements Playable {

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void rotate(Rotation rotation) {

    }

    private boolean hasBarrier(Direction direction) {
        return false;
    }

    private boolean hasObstacle(Direction direction) {
        return false;
    }

}
