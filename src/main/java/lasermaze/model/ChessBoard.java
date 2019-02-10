package lasermaze.model;

public class ChessBoard {

    private static final int CHESSBOARD_SIZE = 8;

    public static ChessSquare[][] chessSquares = new ChessSquare[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    static {
        /* ChessSquare 내부에 ChessPiece 배정 */
    }
}
