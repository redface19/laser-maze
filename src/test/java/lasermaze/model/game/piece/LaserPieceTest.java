package lasermaze.model.game.piece;

import lasermaze.model.game.NotSupportedException;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.piece.properties.LaserPiece;
import org.junit.Test;

public class LaserPieceTest {

    @Test(expected = NotSupportedException.class)
    public void 레이저말_이동() {
        LaserPiece laserPiece = new LaserPiece();
        laserPiece.move(new Point(7, 0), Direction.NORTHEAST);
    }
}