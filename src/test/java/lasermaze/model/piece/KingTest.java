package lasermaze.model.piece;

import lasermaze.model.LaserPointer;
import lasermaze.model.fixture.LaserPointerFixture;
import lasermaze.model.fixture.PieceFixture;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;
import org.junit.Test;

import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class KingTest {

    @Test
    public void move() {
        King king = PieceFixture.createKing(DOBY, Direction.EAST, new Point(4, 1));
        king.move(Direction.SOUTH);
        assertThat(king.direction).isEqualTo(Direction.EAST);
        assertThat(king.point).isEqualTo(new Point(5, 1));
    }

    @Test
    public void rotate() {
        King king = PieceFixture.createKing(DOBY, Direction.EAST, new Point(4, 1));
        king.rotate(Rotation.COUNTERCLOCKWISE);
        assertThat(king.direction).isEqualTo(Direction.NORTH);
        assertThat(king.point).isEqualTo(new Point(4, 1));
    }

    @Test
    public void rotate2() {
        King king = PieceFixture.createKing(DOBY, Direction.EAST, new Point(7, 7));
        king.rotate(Rotation.CLOCKWISE);
        assertThat(king.direction).isEqualTo(Direction.SOUTH);
        assertThat(king.point).isEqualTo(new Point(7, 7));
    }

    @Test
    public void hit() {
        King king = PieceFixture.createKing(DOBY, Direction.EAST, new Point(7, 0));
        LaserPointer laserPointer = LaserPointerFixture.LASER_POINTER1;
        king.hit(laserPointer);
        assertThat(laserPointer.isEnd()).isTrue();
    }
}