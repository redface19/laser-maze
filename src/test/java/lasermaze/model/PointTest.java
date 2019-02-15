package lasermaze.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void getPrevPoint() {
        Point point = new Point(4, 1);
        Point prevPoint = point.getPrevPoint(Direction.EAST);
        assertThat(prevPoint.equals(new Point(4, 0))).isTrue();
    }

    @Test
    public void modify() {
        Point piecePoint = new Point(4, 0);
        piecePoint.modify(Direction.EAST);
        assertThat(piecePoint).isEqualTo(new Point(4, 1));
    }
}