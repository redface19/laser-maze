package lasermaze.model;

import lasermaze.model.fixture.BoardFixture;
import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.King;
import lasermaze.model.piece.Knight;
import lasermaze.model.piece.Laser;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class CommandTest {
    private static final Logger log = getLogger(CommandTest.class);

    ChessSquare chessSquare = new ChessSquare(DOBY, BRAD);
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(chessSquare);
    }

    @Test
    public void 정상적으로_이동() {
        chessSquare.pieceInit();
        Command command = new Command(new Point(4, 0), 3);
        command.execute(board, DOBY);
        assertThat(board.getPiece(new Point(4, 1)) instanceof King).isTrue();
        assertThat(board.getPiece(new Point(4, 0)) instanceof Dummy).isTrue();
        log.debug("laser : {}", board.getPiece(new Point(7, 0)));
    }


    @Test
    public void hasBarrier_벽존재() {
        Command command = new Command(new Point(4, 0), 3);
        Point point = new Point(4, 0);
        assertThat(command.hasBarrier(point, Direction.WEST)).isTrue();
    }

    @Test
    public void hasBarrier_벽존재X() {
        Command command = new Command(new Point(4, 0), 3);
        Point point = new Point(4, 0);
        assertThat(command.hasBarrier(point, Direction.EAST)).isFalse();
    }

    @Test
    public void hasObstacle_장애물존재() {
        chessSquare.pieceInit();
        Command command = new Command(new Point(4, 0), 3);
        assertThat(command.hasObstacle(board, Direction.NORTH)).isTrue();
    }

    @Test
    public void hasObstacle_장애물존재X() {
        chessSquare.pieceInit();
        Command command = new Command(new Point(4, 0), 3);
        assertThat(command.hasObstacle(board, Direction.EAST)).isFalse();
    }

    @Test(expected = NotSupportedException.class)
    public void 레이저이동() {
        Command command = new Command(new Point(7, 0), 3);
        command.execute(board, DOBY);
    }

    @Test(expected = NotSupportedException.class)
    public void isSameUser() {
        new Command(new Point(4, 7), 2).execute(board, DOBY);
    }

    @Test
    public void execute1() {
        BoardFixture.putLaser(chessSquare, Direction.SOUTH, new Point(0, 7));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHWEST, new Point(1, 7));
        BoardFixture.putTriangleNight(chessSquare, Direction.SOUTHEAST, new Point(1, 0));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHEAST, new Point(4, 0));
        BoardFixture.putSplitter(chessSquare, Direction.NORTHWEST, new Point(4, 4));
        BoardFixture.putSquareNight(chessSquare, Direction.WEST, new Point(4, 7));

        Command command = new Command(new Point(4,7), 10);
        command.execute(board, DOBY);

        assertThat(board.getPiece(new Point(4, 7)) instanceof  Dummy).isTrue();
    }

    @Test
    public void execute2() {
        BoardFixture.putLaser(chessSquare, Direction.SOUTH, new Point(0, 7));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHWEST, new Point(1, 7));
        BoardFixture.putTriangleNight(chessSquare, Direction.SOUTHEAST, new Point(1, 0));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHEAST, new Point(4, 0));
        BoardFixture.putSplitter(chessSquare, Direction.NORTHWEST, new Point(4, 4));
        BoardFixture.putSquareNight(chessSquare, Direction.WEST, new Point(4, 7));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHWEST, new Point(2, 4));

        Command command = new Command(new Point(4,7), 7);
        command.execute(board, DOBY);

        assertThat(board.getPiece(new Point(2, 4)) instanceof  Dummy).isTrue();
        assertThat(board.getPiece(new Point(4, 6)) instanceof Knight).isTrue();
        assertThat(board.getPiece(new Point(4, 7)) instanceof Dummy).isTrue();
    }
}