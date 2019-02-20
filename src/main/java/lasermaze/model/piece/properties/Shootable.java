package lasermaze.model.piece.properties;

import lasermaze.model.Board;
import lasermaze.model.piece.common.Position;

public interface Shootable {
    void shoot(Board board, Position position);
}
