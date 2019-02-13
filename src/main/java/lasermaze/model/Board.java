package lasermaze.model;

import lasermaze.model.piece.King;
import lasermaze.model.piece.NonLaserPiece;
import lasermaze.model.piece.Piece;
import lasermaze.model.user.User;

public class Board {

    private static final int CHESSBOARD_SIZE = 8;

    private static final User user1 = new User("user1");
    private static final User user2 = new User("user2");

    public static Piece[][] chessSquares = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];


    static {
        putSymmetryPiece(4, 0, new King(user1, new NonLaserPiece()));
        /* ChessSquare 내부에 Piece 배정 */
    }

    public static Piece getChessSquare(int row, int col) {
        return chessSquares[row][col];
    }

    public static void swap(Point point, Direction direction) {

    }

    public static void deleteChess(Point point) {
        point.delete(chessSquares);
    }

    public static void putSymmetryPiece(int row, int col, Piece piece) {
        chessSquares[row][col] = piece;
        chessSquares[getOpposite(row)][getOpposite(col)] = piece.makeEnemy(new Point(row, col), user2);
    }

    static int getOpposite(int num) {
        return CHESSBOARD_SIZE - num - 1;
    }
}
