package lasermaze.model.piece;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.piece.properties.Playable;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class Piece implements Pieceable, Cloneable {
    private static final Logger log = getLogger(Piece.class);

    private User user;
    protected Direction direction;
    protected Point point;
    private Playable playable;

    public Piece(User user, Direction direction, Point point, Playable playable) {
        this.user = user;
        this.direction = direction;
        this.point = point;
        this.playable = playable;
    }

    public Piece makeEnemy(User user) throws CloneNotSupportedException {
        Piece enemy = clone();
        enemy.point = point.getSymmetrical();
        enemy.direction = direction.getDiametricalDirection();
        enemy.user = user;
        return enemy;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isSameUser(User user) {
        return this.user.equals(user);
    }

    @Override
    public void move(Direction direction) {
        playable.move(point, direction);
    }

    @Override
    public void rotate(Rotation rotation) {
        playable.rotate(direction, rotation);
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
                direction == piece.direction &&
                Objects.equals(point, piece.point) &&
                Objects.equals(playable, piece.playable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, direction, point, playable);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "user=" + user +
                ", direction=" + direction +
                ", point=" + point +
                ", playable=" + playable +
                '}';
    }
}
