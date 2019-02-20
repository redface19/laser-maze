package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;

public class Penetrate implements Penetable {
    @Override
    public void penetrate(LaserPointer laserPointer, Position piecePosition) {
        LaserPointer newLaserPointer = laserPointer.generateNewLaserPointer(piecePosition);
        newLaserPointer.move();
    }
}
