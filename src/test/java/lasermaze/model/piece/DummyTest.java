package lasermaze.model.piece;

import lasermaze.model.NotSupportedException;
import lasermaze.model.fixture.PieceFixture;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;
import org.junit.Test;

public class DummyTest {

    @Test(expected = NotSupportedException.class)
    public void move() {
        Dummy dummy = PieceFixture.createDummy(new Point(3, 3));
        dummy.move(Direction.EAST);
    }

    @Test(expected = NotSupportedException.class)
    public void rotate() {
        Dummy dummy = PieceFixture.createDummy(new Point(3, 3));
        dummy.rotate(Rotation.CLOCKWISE);
    }
}