package lasermaze.model.piece.properties;

import lasermaze.model.LaserPointer;
import lasermaze.model.piece.common.Position;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class DiagonalReflect implements Reflectable {
    private static final Logger log = getLogger(DiagonalReflect.class);

    @Override
    public void reflect(LaserPointer laserPointer, Position piecePosition) {
        laserPointer.reflect(piecePosition);
    }
}
