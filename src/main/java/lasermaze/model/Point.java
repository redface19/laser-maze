package lasermaze.model;

import lasermaze.model.chesspiece.ChessPiece;
import lasermaze.model.chesspiece.DefaultChess;

public class Point {
    private int col;
    private int row;

    public Point(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void delete(ChessPiece[][] chessSquares) {
        chessSquares[row][col] = new DefaultChess();
    }
}
