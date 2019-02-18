package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.LaserPointer;

public class Shooter implements Shootable {

    @Override
    public void shoot(Board board, Position position) {
        LaserPointer laserPointer = new LaserPointer(board, position.generateNewPosition());
        laserPointer.move();
    }
}
