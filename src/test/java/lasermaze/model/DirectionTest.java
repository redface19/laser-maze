package lasermaze.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void getRotatedDirection() {
        Direction direction = Direction.NORTH;
        Rotation rotation = Rotation.COUNTERCLOCKWISE;
        assertThat(direction.getRotatedDirection(rotation)).isEqualTo(Direction.WEST);
    }

    @Test
    public void getRotatedDirection2() {
        Direction direction = Direction.WEST;
        Rotation rotation = Rotation.CLOCKWISE;
        assertThat(direction.getRotatedDirection(rotation)).isEqualTo(Direction.NORTH);
    }

    @Test
    public void getRotatedDirection3() {
        Direction direction = Direction.SOUTH;
        Rotation rotation = Rotation.CLOCKWISE;
        assertThat(direction.getRotatedDirection(rotation)).isEqualTo(Direction.WEST);
    }

    @Test
    public void getRotatedDirection4() {
        Direction direction = Direction.SOUTH;
        Rotation rotation = Rotation.COUNTERCLOCKWISE;
        assertThat(direction.getRotatedDirection(rotation)).isEqualTo(Direction.EAST);
    }

    @Test
    public void getRotatedDirection5() {
        Direction direction = Direction.EAST;
        Rotation rotation = Rotation.COUNTERCLOCKWISE;
        assertThat(direction.getRotatedDirection(rotation)).isEqualTo(Direction.NORTH);
    }

    @Test
    public void getDiametricalDirection() {
        Direction direction = Direction.NORTHEAST;
        assertThat(direction.getDiametricalDirection()).isEqualTo(Direction.SOUTHWEST);
    }
}