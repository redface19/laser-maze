package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Direction;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class DiagonalReflect implements Reflectable {

    @Override
    public void reflect(LaserPointer laserPointer, Direction direction) {
        laserPointer.reflect(direction);
    }
}
