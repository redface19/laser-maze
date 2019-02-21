package lasermaze.model.piece;

import lasermaze.model.NotSupportedException;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.LaserPiece;
import org.junit.Test;

public class LaserPieceTest {

    @Test(expected = NotSupportedException.class)
    public void 레이저말_이동() {
        LaserPiece laserPiece = new LaserPiece();
        laserPiece.move(new Point(7, 0), Direction.NORTHEAST);
    }
}