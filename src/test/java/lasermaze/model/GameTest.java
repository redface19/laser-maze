package lasermaze.model;

import lasermaze.model.piece.Piece;
import lasermaze.model.piece.common.Point;
import lasermaze.model.user.User;
import org.junit.Before;
import org.junit.Test;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
    private Board board;

    @Before
    public void setUp() throws Exception {
         board = new Board(chessSquare);
    }

    @Test
    public void winnerCheck() {
        Game game = new Game(DOBY, BRAD);
        Piece piece = board.getPiece(new Point(4, 0));
        assertThat(game.winnerCheck(piece, DOBY)).isTrue();
    }

    @Test
    public void winnerCheck2() {
        Game game = new Game(DOBY, BRAD);
        Piece piece = board.getPiece(new Point(4, 0));
        assertThat(game.winnerCheck(piece, BRAD)).isFalse();
    }

    @Test
    public void decideWinner() {
        Game game = new Game(DOBY, BRAD);
        assertThat(game.decideWinner(false, true)).isEqualTo(BRAD);
    }


    @Test
    public void decideWinner2() {
        Game game = new Game(DOBY, BRAD);
        assertThat(game.decideWinner(true, true)).isEqualTo(User.DUMMY_USER);
    }

    @Test
    public void getWinner() {
       Game game = new Game(DOBY, BRAD);
       assertThat(game.getWinner()).isEqualTo(BRAD);
    }

    @Test
    public void getWinner2() {
        Game game = new Game(DOBY, BRAD);
        assertThat(game.getWinner().isDummyUser()).isTrue();
    }
}