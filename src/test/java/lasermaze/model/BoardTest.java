package lasermaze.model;

import lasermaze.model.fixture.BoardFixture;
import lasermaze.model.fixture.LaserPointerFixture;
import lasermaze.model.fixture.PieceFixture;
import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.King;
import lasermaze.model.piece.Laser;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import org.junit.Before;
import org.junit.Test;

import static lasermaze.model.ChessSquareTest.CHESS_SQUARE;
import static lasermaze.model.user.UserTest.BRAD;
import static lasermaze.model.user.UserTest.DOBY;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;
    private ChessSquare chessSquare;

    @Before
    public void setUp() throws Exception {
        chessSquare = new ChessSquare(DOBY, BRAD);
        board = new Board(chessSquare);
    }

    @Test
    public void deletePieceTest() {
        Point point = new Point(4, 0);
        LaserPointer laserPointer = LaserPointerFixture.createLaserPointer(Direction.WEST, point);
        board.deletePiece(laserPointer);

        assertThat(board.getPiece(point) instanceof Dummy).isTrue();
    }

    @Test
    public void hasObstacle() {
        Board board = new Board(new ChessSquare(DOBY, BRAD).pieceInit());
        assertThat(board.hasObstacle(new Point(6, 1), Direction.WEST)).isTrue();
    }

    @Test
    public void hasObstacle2() {
        Board board = new Board(new ChessSquare(DOBY, BRAD).pieceInit());
        assertThat(board.hasObstacle(new Point(6, 1), Direction.EAST)).isFalse();
    }

    @Test
    public void swap() {
        Board board = new Board(new ChessSquare(DOBY, BRAD).pieceInit());
        board.swap(new Point(3, 7), Direction.WEST);
        assertThat(board.getPiece(new Point(3, 7)) instanceof Dummy).isTrue();
        assertThat(board.getPiece(new Point(3, 6)) instanceof King).isTrue();
    }

    @Test
    public void shoot() {
        BoardFixture.putLaser(chessSquare, Direction.EAST, new Point(4, 0));
        BoardFixture.putTriangleNight(chessSquare, Direction.SOUTHWEST, new Point(4, 4));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHWEST, new Point(5, 4));
        BoardFixture.putSquareNight(chessSquare, Direction.NORTH, new Point(5, 2));
        board.shoot(DOBY);
        assertThat(board.getPiece(new Point(5, 2)) instanceof Dummy).isTrue();
    }

    @Test
    public void shoot2() {
        BoardFixture.putLaser(chessSquare, Direction.EAST, new Point(4, 0));
        BoardFixture.putSplitter(chessSquare, Direction.NORTHEAST, new Point(4, 4));
        BoardFixture.putSquareNight(chessSquare, Direction.WEST, new Point(4, 7));
        BoardFixture.putSquareNight(chessSquare, Direction.NORTH, new Point(1, 4));
        BoardFixture.putSquareNight(chessSquare, Direction.SOUTH, new Point(7, 4));
        board.shoot(DOBY);
        assertThat(board.getPiece(new Point(7, 4)) instanceof Dummy).isTrue();
        assertThat(board.getPiece(new Point(1, 4)) instanceof Dummy).isTrue();
    }

    @Test
    public void shoot3() {
        BoardFixture.putLaser(chessSquare, Direction.WEST, new Point(4, 7));
        BoardFixture.putSplitter(chessSquare, Direction.NORTHEAST, new Point(4, 4));
        BoardFixture.putKing(chessSquare, DOBY, Direction.EAST, new Point(4, 0));
        BoardFixture.putKing(chessSquare, BRAD, Direction.EAST, new Point(0, 4));
        board.shoot(DOBY);
        assertThat(board.getPiece(new Point(4, 0)) instanceof Dummy).isTrue();
        assertThat(board.getPiece(new Point(0, 4)) instanceof Dummy).isTrue();
    }

    @Test
    public void shoot_삼각기사_오른쪽반사() {
        BoardFixture.putLaser(chessSquare, Direction.WEST, new Point(4, 7));
        BoardFixture.putTriangleNight(chessSquare, Direction.NORTHEAST, new Point(4, 4));
        BoardFixture.putKing(chessSquare, BRAD, Direction.EAST, new Point(0, 4));
        board.shoot(DOBY);
        assertThat(board.getPiece(new Point(0, 4)) instanceof Dummy).isTrue();
    }

    @Test
    public void shoot_삼각기사_왼쪽반사() {
        BoardFixture.putLaser(chessSquare, Direction.EAST, new Point(4, 0));
        BoardFixture.putTriangleNight(chessSquare, Direction.SOUTHWEST, new Point(4, 4));
        BoardFixture.putKing(chessSquare, BRAD, Direction.EAST, new Point(7, 4));
        board.shoot(DOBY);
        assertThat(board.getPiece(new Point(7, 4)) instanceof Dummy).isTrue();
    }
}