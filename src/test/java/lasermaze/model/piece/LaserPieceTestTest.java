package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.NotSupportedException;
import lasermaze.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class LaserPieceTestTest {

    @Test(expected = NotSupportedException.class)
    public void 레이저이동() {
        LaserPiece laserPiece = new LaserPiece();
        laserPiece.move(new Point(7, 0), Direction.EAST);
    }
}