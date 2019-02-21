package lasermaze.model.piece;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class Piece implements Pieceable, Cloneable {
    private static final Logger log = getLogger(Piece.class);

    private User user;
    protected Position position;
    private Playable playable;

    public Piece(User user, Position position, Playable playable) {
        this.user = user;
        this.position = position;
        this.playable = playable;
    }

    public Piece makeEnemy(Point point, User user) throws CloneNotSupportedException {
        Piece enemy = clone();
        enemy.position = position.getOppositePosition(point);
        enemy.user = user;
        return enemy;
    }

    public boolean isSameUser(User user) {
        return this.user.equals(user);
    }

    @Override
    public void move(Direction direction) {
        playable.move(position, direction);
    }

    @Override
    public void rotate(Rotation rotation) {
        playable.rotate(position, rotation);
    }

    @Override
    public Piece clone() throws CloneNotSupportedException {
        return (Piece) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(user, piece.user) &&
                Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, position);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "user=" + user +
                ", position=" + position +
                '}';
    }
}
