package lasermaze.model;

import lasermaze.model.piece.Piece;
import lasermaze.model.user.User;
import org.junit.Test;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void winnerCheck() {
        Game game = new Game(DOBY, BRAD);
        Board board = new Board(DOBY, BRAD);
        Piece piece = board.getChessSquare(4, 0);
        assertThat(game.winnerCheck(piece, DOBY)).isTrue();
    }

    @Test
    public void winnerCheck2() {
        Game game = new Game(DOBY, BRAD);
        Board board = new Board(DOBY, BRAD);
        Piece piece = board.getChessSquare(4, 0);
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
       Board board = new Board(DOBY, BRAD);
       board.putDummy(4, 0);

       Game game = new Game(DOBY, BRAD);
       assertThat(game.getWinner()).isEqualTo(BRAD);
    }

    @Test
    public void getWinner2() {
        Game game = new Game(DOBY, BRAD);
        assertThat(game.getWinner().isDummyUser()).isTrue();
    }
}