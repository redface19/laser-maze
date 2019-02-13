package lasermaze.model;

import lasermaze.model.piece.King;
import lasermaze.model.piece.NonLaserPiece;
import lasermaze.model.piece.Piece;
import lasermaze.model.user.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void 상대편말_배치하기() {
        int row = 4, col = 0;
        User user = new User("Brad");
        Piece piece = new King(user, new NonLaserPiece());
        Board.putSymmetryPiece(row, col, piece);
        assertThat(Board.getChessSquare(3, 7)).isEqualTo(true);
    }

    @Test
    public void getOppositeAbs() {
        assertThat(Board.getOpposite(3)).isEqualTo(4);
    }

    @Test
    public void getOppositeAbs2() {
        assertThat(Board.getOpposite(1)).isEqualTo(6);
    }
}