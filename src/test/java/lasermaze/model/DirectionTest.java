package lasermaze.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectionTest {

    @Test
    public void getPrevDirection() {
        assertThat(Direction.EAST.getPrevDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void getPrevDirection2() {
        assertThat(Direction.NORTHWEST.getPrevDirection()).isEqualTo(Direction.SOUTHEAST);
    }

    @Test
    public void getPrevDirection3() {
        assertThat(Direction.SOUTH.getPrevDirection()).isEqualTo(Direction.NORTH);
    }
}