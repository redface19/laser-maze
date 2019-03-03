package lasermaze.model.game.piece;

import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.*;
import lasermaze.model.game.piece.properties.*;
import lasermaze.model.game.user.GameUser;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Knight extends Piece {
    private static final Logger log = getLogger(Knight.class);

    private Reflectable reflectable;

    public Knight(GameUser gameUser, Direction direction, Point point, Playable playable, Reflectable reflectable) {
        super(gameUser, direction, point, playable);
        this.reflectable = reflectable;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (reflectable.canDead(laserPointer, direction)) {
            laserPointer.setEnd(true);
            return;
        }
        reflectable.reflect(laserPointer, direction);
    }

}
