package lasermaze.model;

import lasermaze.model.piece.CommonPlay;
import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.Piece;
import lasermaze.model.user.User;

public class Point {
    private int col;
    private int row;

    public Point(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void delete(Piece[][] chessSquares) {
        chessSquares[row][col] = new Dummy(User.DUMMY_USER, new CommonPlay());
    }

    @Override
    public String toString() {
        return "Point[col=" + col + ", row=" + row + ']';
    }
}
