package lasermaze.model;

import lasermaze.model.piece.Piece;

public class Board {

    private static final int CHESSBOARD_SIZE = 8;

    public static Piece[][] chessSquares = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    static {
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
}
