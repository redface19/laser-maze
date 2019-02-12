package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.Rotation;

public abstract class Piece implements Pieceable {
    protected Point point;
    protected Direction direction;

    public void terminated() {
        Board.deleteChess(point);
    }
}
