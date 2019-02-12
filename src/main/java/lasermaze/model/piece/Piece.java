package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;

public abstract class Piece implements Playable, Pieceable {
    private Point point;
    protected Direction direction;

    @Override
    public void move(Direction direction) {
        if (this instanceof Laser || hasObstacle(direction) || hasBarrier(direction))
            throw new IllegalArgumentException();
        Board.swap(point, direction);
    }

    @Override
    public void rotate(Rotation rotation) {
        if (this instanceof Laser && !direction.isRotable(rotation)) throw new IllegalArgumentException();
        this.direction = direction.rotate(rotation);
    }

    private boolean hasBarrier(Direction direction) {
        return false;
    }

    private boolean hasObstacle(Direction direction) {
        return false;
    }

    public void terminated() {
        Board.deleteChess(point);
    }
}
