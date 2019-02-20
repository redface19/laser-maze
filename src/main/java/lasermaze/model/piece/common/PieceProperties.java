package lasermaze.model.piece.common;

import lasermaze.model.*;
import lasermaze.model.piece.properties.Penetable;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.piece.properties.Reflectable;
import lasermaze.model.piece.properties.Shootable;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class PieceProperties {
    private static final Logger log = getLogger(PieceProperties.class);

    private Playable playable;
    private Reflectable reflectable;
    private Shootable shootable;
    private Penetable penetable;

    private PieceProperties(PiecesPropertiesBuilder piecesPropertiesBuilder) {
        this.playable = piecesPropertiesBuilder.playable;
        this.reflectable = piecesPropertiesBuilder.reflectable;
        this.shootable = piecesPropertiesBuilder.shootable;
        this.penetable = piecesPropertiesBuilder.penetable;
    }

    public void move(Position position, Direction direction) {
        playable.move(position, direction);
    }

    public void rotate(Position position, Rotation rotation) {
        playable.rotate(position, rotation);
    }

    public void shoot(Board board, Position position) {
        shootable.shoot(board, position);
    }

    public void reflect(LaserPointer laserPointer, Position position) {
        reflectable.reflect(laserPointer, position);
    }

    public void penetrate(LaserPointer laserPointer, Position position) {
        penetable.penetrate(laserPointer, position);
    }

    public static class PiecesPropertiesBuilder {
        private Playable playable;
        private Reflectable reflectable;
        private Shootable shootable;
        private Penetable penetable;

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

        public PiecesPropertiesBuilder applyPenetable(Penetable penetable) {
            this.penetable = penetable;
            return this;
        }

        public PieceProperties build() {
            return new PieceProperties(this);
        }
    }
}
