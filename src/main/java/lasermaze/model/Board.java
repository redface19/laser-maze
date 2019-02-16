package lasermaze.model;

import lasermaze.model.piece.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {
    private static final Logger log = LoggerFactory.getLogger(Board.class);

    public static final int CHESSBOARD_SIZE = 8;

    private Piece[][] chessSquares = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    public Board(User user1, User user2) {
        dummyInit();
        pieceInit(user1, user2);
    }

    private void pieceInit(User user1, User user2) {
        putSymmetryPieces(4, 0, user2, new King(user1, new Point(4, 0), Direction.EAST, PropertyBundle.KING_PROPRTY.getProperty()));
        putSymmetryPieces(7, 0, user2, new Laser(user1, new Point(7, 0), Direction.EAST, PropertyBundle.LASER_PROPERTY.getProperty()));
        putSymmetryPieces(7, 7, user2, new Splitter(user1, new Point(4, 0), Direction.EAST, PropertyBundle.SPLITTER_PROPRTY.getProperty()));
        putSymmetryPieces(7, 4, user2, new Knight(user1, new Point(7, 4), Direction.NORTHWEST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(1, 7, user2, new Knight(user1, new Point(1, 7), Direction.NORTHWEST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(2, 0, user2, new Knight(user1, new Point(2, 0), Direction.NORTHEAST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(3, 3, user2, new Knight(user1, new Point(3, 3), Direction.NORTHEAST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(4, 3, user2, new Knight(user1, new Point(4, 3), Direction.SOUTHEAST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(3, 0, user2, new Knight(user1, new Point(3, 0), Direction.EAST, PropertyBundle.SQUARE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(5, 0, user2, new Knight(user1, new Point(5, 0), Direction.EAST, PropertyBundle.SQUARE_KNIGHT_PROPERTY.getProperty()));
    }

    private void dummyInit() {
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            for (int col = 0; col < CHESSBOARD_SIZE; col++) {
                putDummy(row, col);
            }
        }
    }

    private void putDummy(int row, int col) {
        chessSquares[row][col] = new Dummy(User.DUMMY_USER, new Point(row, col), Direction.NONE, PropertyBundle.DUMMY_PROPERTY.getProperty());
    }

    public Piece getChessSquare(int row, int col) {
        return chessSquares[row][col];
    }

    public Piece getChessSquare(Point point) {
        return chessSquares[point.getRow()][point.getCol()];
    }

    public void swap(Point prevPoint, Direction direction) {
        Point nextPoint = prevPoint.getNextPoint(direction);
        chessSquares[nextPoint.getRow()][nextPoint.getCol()] = getChessSquare(prevPoint);
        putDummy(prevPoint.getRow(), prevPoint.getCol());
    }

    public void deleteChess(Point point) {
        point.delete(chessSquares);
    }

    public void putSymmetryPieces(int row, int col, User user2, Piece piece) {
        try {
            chessSquares[row][col] = piece;
            chessSquares[getOpposite(row)][getOpposite(col)] = piece.makeEnemy(new Point(getOpposite(row), getOpposite(col)), user2);
        } catch (CloneNotSupportedException e) {
            log.error("말 생성 오류 발생 : {}", e);
        }
    }

    int getOpposite(int num) {
        return CHESSBOARD_SIZE - num - 1;
    }

    public boolean isDummy(Point nextPoint) {
        return getChessSquare(nextPoint) instanceof Dummy;
    }
}
