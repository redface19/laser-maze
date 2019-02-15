package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Rotation;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class NonLaserPiece extends CommonPlay {
    private static final Logger log = getLogger(NonLaserPiece.class);

    @Override
    public void move(Direction direction) {
        if(hasBarrier(direction)) {

        }
        log.debug("direction : {}", direction);
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
