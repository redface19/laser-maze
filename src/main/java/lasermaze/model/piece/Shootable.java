package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.LaserPointer;

public interface Shootable {
    void shoot(Board board, Position position);
}
