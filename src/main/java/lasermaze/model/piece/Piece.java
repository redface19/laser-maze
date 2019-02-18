package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class Piece implements Pieceable, Cloneable {
    private static final Logger log = getLogger(Piece.class);

    private User user;
    protected Position position;
    protected PieceProperties pieceProperties;

    public Piece(User user, Position position, PieceProperties pieceProperties) {
        this.user = user;
        this.position = position;
        this.pieceProperties = pieceProperties;
    }

    @Override
    public void move(Direction direction) {
        pieceProperties.move(position, direction);
    }

    @Override
    public void rotate(Rotation rotation) {
        pieceProperties.rotate(position, rotation);
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
    public Piece clone() throws CloneNotSupportedException {
        return (Piece) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return user.equals(piece.user) &&
                position.equals(piece.position) &&
                pieceProperties.equals(piece.pieceProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, position, pieceProperties);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "user=" + user +
                ", position=" + position +
                ", pieceProperties=" + pieceProperties +
                '}';
    }
}
