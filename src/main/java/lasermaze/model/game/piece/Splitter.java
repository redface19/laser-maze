package lasermaze.model.game.piece;

import lasermaze.model.game.LaserPointer;
import lasermaze.model.game.piece.common.*;
import lasermaze.model.game.piece.properties.*;
import lasermaze.model.game.user.GameUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Splitter extends Piece {

    private static final Logger log = LoggerFactory.getLogger(Splitter.class);

    private Reflectable reflectable;

    public Splitter(GameUser gameUser, Direction direction, Point point, Playable playable, Reflectable reflectable) {
        super(gameUser, direction, point, playable);
        this.reflectable = reflectable;
    }

    @Override
    public void hit(LaserPointer laserPointer) {
        if (reflectable.canDead(laserPointer, direction)) {
            direction = direction.getDiametricalDirection();
        }
        reflectable.reflect(laserPointer, direction);
    }
}
