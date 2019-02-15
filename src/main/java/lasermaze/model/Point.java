package lasermaze.model;

import lasermaze.model.piece.Piece;

public class Point {
    private int row;
    private int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void delete(Piece[][] chessSquares) {
        //chessSquares[row][col] = new Dummy(User.DUMMY_USER, new CommonPlay());
    }

    @Override
    public String toString() {
        return "Point[row=" + row + ", col=" + col + "]";
    }
}
