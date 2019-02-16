package lasermaze.model;

import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.King;
import lasermaze.model.piece.LaserPiece;
import lasermaze.model.piece.NonLaserPiece;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class CommandTest {
    private static final Logger log = getLogger(CommandTest.class);

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(DOBY, BRAD);
    }

    @Test
    public void command_생성() {
        Command command = new Command(new Point(4, 0), 3);
        command.execute(board);
    }

    @Test
    public void 정상적으로_이동() {
        Command command = new Command(new Point(4, 0), 3);
        command.execute(board);
        assertThat(board.getChessSquare(4, 1) instanceof King).isTrue();
        assertThat(board.getChessSquare(4, 0) instanceof Dummy).isTrue();
    }


    @Test
    public void hasBarrier_벽존재() {
        Command command = new Command(new Point(4, 0), 3);
        assertThat(command.hasBarrier(Direction.WEST)).isTrue();
    }

    @Test
    public void hasBarrier_벽존재X() {
        Command command = new Command(new Point(4, 0), 3);
        assertThat(command.hasBarrier(Direction.EAST)).isFalse();
    }

    @Test
    public void isOutOfBound() {
        Point nextPoint = new Point(-1, 0);
        assertThat(nextPoint.isOutOfBound()).isTrue();
    }

    @Test
    public void hasObstacle_장애물존재() {
        Command command = new Command(new Point(4, 0), 3);
        assertThat(command.hasObstacle(board, Direction.NORTH)).isTrue();
    }

    @Test
    public void hasObstacle_장애물존재X() {
        Command command = new Command(new Point(4, 0), 3);
        assertThat(command.hasObstacle(board, Direction.EAST)).isFalse();
    }

    @Test(expected = NotSupportedException.class)
    public void 레이저이동() {
        Command command = new Command(new Point(7, 0), 3);
        command.execute(board);
    }
}