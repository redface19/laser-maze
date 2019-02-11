package lasermaze.model;

import lasermaze.model.chesspiece.ChessPiece;

public class ChessBoard {

    private static final int CHESSBOARD_SIZE = 8;

    public static ChessPiece[][] chessSquares = new ChessPiece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    static {
        /* ChessSquare 내부에 ChessPiece 배정 */
    }

    public static ChessPiece getChessSquare(int row, int col) {
        return chessSquares[row][col];
    }

    public static void swap(Point point, Direction direction) {

    }

    public static void deleteChess(Point point) {
        point.delete(chessSquares);
    }
}
