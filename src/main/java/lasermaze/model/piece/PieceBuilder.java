package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Rotation;
import lasermaze.model.user.User;

public class PieceBuilder {

    private User user;
    private Direction direction;
    private Rotation rotation;

    private Reflectable reflectable;
    private Playable playable;
    private Penetable penetable;
    private Shootable shootable;

    public PieceBuilder(User user, Direction direction, Rotation rotation) {
        this.user = user;
        this.direction = direction;
        this.rotation = rotation;
    }

    public PieceBuilder applyReflectable(Reflectable reflectable) {
        this.reflectable = reflectable;
        return this;
    }

    public PieceBuilder applyPlayable(Playable playable) {
        this.playable = playable;
        return this;
    }

    public PieceBuilder applyPenetable(Penetable penetable) {
        this.penetable = penetable;
        return this;
    }

    public PieceBuilder applyShootable(Shootable shootable) {
        this.shootable = shootable;
        return this;
    }

    public static Piece build() {
        return new King(new User("brad"), new NonLaserPiece());
    }
}
