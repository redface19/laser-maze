package lasermaze.model;

import lasermaze.model.piece.*;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ChessSquare {

    private static final Logger log = LoggerFactory.getLogger(ChessSquare.class);

    public static final int CHESSBOARD_SIZE = 8;

    private List<List<Piece>> board = new ArrayList<>();
    private User user1;
    private User user2;

    public ChessSquare(User user1, User user2) {
        dummyInit();
        this.user1 = user1;
        this.user2 = user2;
    }

    private void pieceInit(User user1, User user2) {
        putSymmetryPieces(user2, new King(user1, Direction.EAST, new Point(4, 0), new NonLaserPiece()));
        putSymmetryPieces(user2, new Laser(user1, Direction.EAST, new Point(7, 0), new LaserPiece()));
        putSymmetryPieces(user2, new Splitter(user1, Direction.NORTHEAST, new Point(7, 7), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHWEST, new Point(7, 4), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHWEST, new Point(1, 7)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHEAST, new Point(2, 0)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHEAST, new Point(3, 3)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.SOUTHEAST, new Point(4, 3)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.EAST, new Point(3, 0)), new NonLaserPiece(), new HorizontalReflect()));
        putSymmetryPieces(user2, new Knight(user1, Direction.EAST, new Point(5, 0)), new NonLaserPiece(), new HorizontalReflect()));
    }

    private void dummyInit() {
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            List<Piece> line = new ArrayList<>();
            for (int col = 0; col < CHESSBOARD_SIZE; col++) {
                line.add(getDummy(new Point(row, col)));
            }
            this.board.add(line);
        }
    }

    private Dummy getDummy(Point point) {
        return new Dummy(User.DUMMY_USER, new Position(Direction.NONE, point), new CommonPlay());
    }

    public void putPiece(Point point, Piece piece) {
        board.get(point.getRow()).set(point.getCol(), piece);
    }

    public Piece getChessSquare(Point point) {
        return board.get(point.getRow()).get(point.getCol());
    }

    public void swap(Point prevPoint, Direction direction) {
        Point nextPoint = prevPoint.getNextPoint(direction);
        chessSquares[nextPoint.getRow()][nextPoint.getCol()] = getChessSquare(prevPoint);
        putDummy(prevPoint.getRow(), prevPoint.getCol());
    }

    public void deleteChess(Position position) {
        Point point = position.getPoint();
        putPiece(point, getDummy(point));
    }

    public void putSymmetryPieces(User other, Piece piece) {
        try {
            Point point = piece.getPoint();
            putPiece(point, piece);
            putPiece(point.getSymmetrical(), piece.makeEnemy(other));
        } catch (CloneNotSupportedException e) {
            log.error("말 생성 오류 발생 : {}", e);
        }
    }

    public boolean isDummy(Point nextPoint) {
        return getChessSquare(nextPoint) instanceof Dummy;
    }

    public Laser getLaser(User user) {
        for (List<Piece> line : board) {
            for (Piece piece : line) {
                if (piece.isSameUser(user) && piece instanceof Laser) return (Laser) piece;
            }
        }
        throw new NotSupportedException("cannot find laser piece");
    }
}
