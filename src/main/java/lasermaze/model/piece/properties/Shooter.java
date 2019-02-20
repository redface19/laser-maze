package lasermaze.model.piece.properties;

import lasermaze.model.Board;
import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;

public class Shooter implements Shootable {

    @Override
    public void shoot(Board board, Position position) {
        LaserPointer laserPointer = new LaserPointer(board, position.generateNewPosition());
        laserPointer.move();
    }
}
