package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class Piece implements Pieceable, Cloneable {
    private static final Logger log = getLogger(Piece.class);

    private User user;
    protected Point point;
    protected Direction direction;

    protected Playable playable;
    protected Reflectable reflectable;
    protected Shootable shootable;

    public Piece(User user, Point point, Direction direction, PieceProperties pieceProperties) {
        this.user = user;
        this.point = point;
        this.direction = direction;
        pieceProperties.inject(playable, reflectable, shootable);
    }

    @Override
    public void move(Direction direction) {
        playable.move(direction);
    }

    @Override
    public void rotate(Rotation rotation) {
        playable.rotate(rotation);
    }

    public void terminated() {
        Board.deleteChess(point);
    }

    public Piece makeEnemy(Point point, User user) throws CloneNotSupportedException {
        Piece enemy = clone();
        enemy.point = point;
        enemy.user = user;
        log.debug("enemy : {}", enemy);
        return enemy;
    }

    @Override
    public Piece clone() throws CloneNotSupportedException {
        return (Piece) super.clone();
    }

    @Override
    public String toString() {
        return "Piece[point=" + point + ", direction=" + direction + ", user=" + user +"]";
    }
}
