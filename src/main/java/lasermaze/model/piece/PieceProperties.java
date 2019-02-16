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

    public void move(Position position, Direction direction) {
        playable.move(position, direction);
    }

    public void rotate(Position position, Rotation rotation) {
        playable.rotate(position, rotation);
    }

    public void shoot(Position position) {
        shootable.shoot(position);
    }

    public void reflect(LaserPointer laserPointer, Position position) {
        reflectable.reflect(laserPointer, position);
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
