package lasermaze.model;

import lasermaze.model.piece.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {

    private static final Logger log = LoggerFactory.getLogger(Board.class);

    private static final int CHESSBOARD_SIZE = 8;

    private static final User user1 = new User("user1");
    private static final User user2 = new User("user2");

    public static Piece[][] chessSquares = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    static {
        init();
        putSymmetryPieces(4, 0, new King(user1, new Point(4, 0), Direction.EAST, PropertyBundle.KING_PROPRTY.getProperty()));
        putSymmetryPieces(7, 0, new Laser(user1, new Point(7, 0), Direction.EAST, PropertyBundle.LASER_PROPERTY.getProperty()));
        putSymmetryPieces(7, 7, new Splitter(user1, new Point(4, 0), Direction.EAST, PropertyBundle.SPLITTER_PROPRTY.getProperty()));

        putSymmetryPieces(7, 4, new Knight(user1, new Point(7, 4), Direction.NORTHWEST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(1, 7, new Knight(user1, new Point(1, 7), Direction.NORTHWEST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(2, 0, new Knight(user1, new Point(2, 0), Direction.NORTHEAST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(3, 3, new Knight(user1, new Point(3, 3), Direction.NORTHEAST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(4, 3, new Knight(user1, new Point(4, 3), Direction.SOUTHEAST, PropertyBundle.TRIANGLE_KNIGHT_PROPERTY.getProperty()));

        putSymmetryPieces(3, 0, new Knight(user1, new Point(3, 0), Direction.EAST, PropertyBundle.SQUARE_KNIGHT_PROPERTY.getProperty()));
        putSymmetryPieces(5, 0, new Knight(user1, new Point(5, 0), Direction.EAST, PropertyBundle.SQUARE_KNIGHT_PROPERTY.getProperty()));
    }

    private static void init() {
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            for (int col = 0; col < CHESSBOARD_SIZE; col++) {
                chessSquares[row][col] = new Dummy(User.DUMMY_USER, new Point(row, col), Direction.NONE, PropertyBundle.DUMMY_PROPERTY.getProperty());
            }
        }
    }

    public static Piece getChessSquare(int row, int col) {
        return chessSquares[row][col];
    }

    public static void swap(Point point, Direction direction) {

    }

    public static void deleteChess(Point point) {
        point.delete(chessSquares);
    }

    public static void putSymmetryPieces(int row, int col, Piece piece) {
        try {
            chessSquares[row][col] = piece;
            chessSquares[getOpposite(row)][getOpposite(col)] = piece.makeEnemy(new Point(getOpposite(row), getOpposite(col)), user2);
        } catch (CloneNotSupportedException e) {
            log.error("말 생성 오류 발생 : {}", e);
        }
    }

    static int getOpposite(int num) {
        return CHESSBOARD_SIZE - num - 1;
    }
}
