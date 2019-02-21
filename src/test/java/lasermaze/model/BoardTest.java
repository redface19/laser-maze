package lasermaze.model;

import lasermaze.model.piece.King;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.common.PropertyBundle;
import lasermaze.model.piece.properties.NonLaserPiece;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class BoardTest {
    private static final Logger log = getLogger(BoardTest.class);

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(DOBY, BRAD);
    }

    @Test
    public void putSymmetryPieces() {
        board.putSymmetryPieces(4, 0, BRAD, new King(DOBY, new Position(Direction.EAST, new Point(4, 0)), new NonLaserPiece()));
    }

    @Test
    public void 왕_장기확인() {
        assertThat(board.getChessSquare(4, 0) instanceof King).isTrue();
    }

    @Test
    public void getOpposite() {
        assertThat(board.getOpposite(3)).isEqualTo(4);
    }

    @Test
    public void getOpposite2() {
        assertThat(board.getOpposite(1)).isEqualTo(6);
    }

    @Test
    public void shoot() {
        board.shoot(DOBY);
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()) {
            int num = iterator.next();
            System.out.println(num);
            iterator.add(6);
        }
    }

    @Test
    public void getPoint() {
        LaserPointer laserPointer = new LaserPointer(new Position(Direction.EAST, new Point(7,7)));
        log.debug("laserPoint getPoint : {}", laserPointer.getPoint());
    }
}