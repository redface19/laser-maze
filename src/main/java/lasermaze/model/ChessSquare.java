package lasermaze.model;

import lasermaze.model.piece.*;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ChessSquare {
    private static final Logger log = LoggerFactory.getLogger(ChessSquare.class);

    public static final int CHESSBOARD_SIZE = 8;

    private List<List<Piece>> chessSquares = new ArrayList<>();
    private User user1;
    private User user2;

    public ChessSquare(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        dummyInit();
    }

    private void dummyInit() {
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            List<Piece> line = new ArrayList<>();
            for (int col = 0; col < CHESSBOARD_SIZE; col++) {
                line.add(createDummy(new Point(row, col)));
            }
            this.chessSquares.add(line);
        }
    }

    public ChessSquare pieceInit() {
        putSymmetryPieces(user2, new King(user1, Direction.EAST, new Point(4, 0), NonLaserPiece.getInstance()));
        putSymmetryPieces(user2, new Laser(user1, Direction.EAST, new Point(7, 0), LaserPiece.getInstance()));
        putSymmetryPieces(user2, new Splitter(user1, Direction.NORTHEAST, new Point(7, 7), NonLaserPiece.getInstance(), DiagonalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHWEST, new Point(7, 4), NonLaserPiece.getInstance(), DiagonalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHWEST, new Point(1, 7), NonLaserPiece.getInstance(), DiagonalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHEAST, new Point(2, 0), NonLaserPiece.getInstance(), DiagonalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.NORTHEAST, new Point(3, 3), NonLaserPiece.getInstance(), DiagonalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.SOUTHEAST, new Point(4, 3), NonLaserPiece.getInstance(), DiagonalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.EAST, new Point(3, 0), NonLaserPiece.getInstance(), HorizontalReflect.getInstance()));
        putSymmetryPieces(user2, new Knight(user1, Direction.EAST, new Point(5, 0), NonLaserPiece.getInstance(), HorizontalReflect.getInstance()));
        return this;
    }

    public void putSymmetryPieces(User otherUser, Piece piece) {
        try {
            Point point = piece.getPoint();
            putPiece(point, piece);
            putPiece(point.getSymmetrical(), piece.makeEnemy(otherUser));
        } catch (CloneNotSupportedException e) {
            log.error("말 생성 오류 발생 : {}", e);
        }
    }

    public Dummy createDummy(Point point) {
        return new Dummy(User.DUMMY_USER, Direction.NONE, point, CommonPlay.getInstance());
    }

    public void putPiece(Point point, Piece piece) {
        chessSquares.get(point.getRow()).set(point.getCol(), piece);
    }

    public Piece getPiece(Point point) {
        return chessSquares.get(point.getRow()).get(point.getCol());
    }

    public void swap(Point prevPoint, Direction direction) {
        Point nextPoint = prevPoint.getNextPoint(direction);
        putPiece(nextPoint, getPiece(prevPoint));
        putPiece(prevPoint, createDummy(prevPoint));
    }

    public boolean isDummy(Point point) {
        return getPiece(point) instanceof Dummy;
    }

    public Laser getLaser(User user) {
        for (List<Piece> line : chessSquares) {
            for (Piece piece : line) {
                if (piece.isSameUser(user) && piece instanceof Laser) return (Laser) piece;
            }
        }
        throw new NotSupportedException("cannot find laser piece");
    }
}
