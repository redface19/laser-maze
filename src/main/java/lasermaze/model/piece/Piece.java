package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;

public abstract class Piece implements Pieceable {
    protected Point point;
    protected Direction direction;
    private Playable playable;

    public Piece(Playable playable) {
        this.playable = playable;
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
}
