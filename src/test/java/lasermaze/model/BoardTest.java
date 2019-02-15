package lasermaze.model;

import lasermaze.model.piece.King;
import lasermaze.model.piece.PropertyBundle;
import lasermaze.model.user.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void putSymmetryPieces() {
        Board.putSymmetryPieces(4, 0, new King(new User("Doby"), new Point(4, 0), Direction.EAST, PropertyBundle.KING_PROPRTY.getProperty()));
    }

    @Test
    public void 왕_장기확인() {
        assertThat(Board.getChessSquare(4, 0) instanceof King).isTrue();
    }

    @Test
    public void getOppositeAbs() {
        assertThat(Board.getOpposite(3)).isEqualTo(4);
    }

    @Test
    public void getOppositeAbs2() {
        assertThat(Board.getOpposite(1)).isEqualTo(6);
    }

    @Test
    public void swap() {

    }
}