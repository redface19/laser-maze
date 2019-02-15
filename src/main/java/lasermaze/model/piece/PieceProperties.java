package lasermaze.model.piece;

import lasermaze.model.*;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class PieceProperties {
    private static final Logger log = getLogger(PieceProperties.class);

    private Playable playable;
    private Reflectable reflectable;
    private Shootable shootable;

    private PieceProperties(PiecesPropertiesBuilder piecesPropertiesBuilder) {
        this.playable = piecesPropertiesBuilder.playable;
        this.reflectable = piecesPropertiesBuilder.reflectable;
        this.shootable = piecesPropertiesBuilder.shootable;
    }

    public void move(Point point, Direction direction) {
        playable.move(point, direction);
    }

    public void rotate(Direction direction, Rotation rotation) {
        playable.rotate(direction, rotation);
    }

    public void shoot(Point point, Direction direction) {
        shootable.shoot(point, direction);
    }

    public void reflect(LaserPointer laserPointer, Direction direction) {
        reflectable.reflect(laserPointer, direction);
    }

    public static class PiecesPropertiesBuilder {
        private Playable playable;
        private Reflectable reflectable;
        private Shootable shootable;

        public PiecesPropertiesBuilder(Playable playable) {
            this.playable = playable;
        }

        public PiecesPropertiesBuilder applyReflectable(Reflectable reflectable) {
            this.reflectable = reflectable;
            return this;
        }

        public PiecesPropertiesBuilder applyShootable(Shootable shootable) {
            this.shootable = shootable;
            return this;
        }

        public PieceProperties build() {
            return new PieceProperties(this);
        }
    }
}
