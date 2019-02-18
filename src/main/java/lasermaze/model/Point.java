package lasermaze.model;

import lasermaze.model.piece.Piece;

import java.util.HashMap;
import java.util.Map;

import static lasermaze.model.Board.CHESSBOARD_SIZE;

public class Point {
    private static final Map<Direction, Point> MOVE_TABLE = new HashMap<>();

    static {
        MOVE_TABLE.put(Direction.NORTH, new Point(-1, 0));
        MOVE_TABLE.put(Direction.NORTHEAST, new Point(-1, 1));
        MOVE_TABLE.put(Direction.EAST, new Point(0, 1));
        MOVE_TABLE.put(Direction.SOUTHEAST, new Point(1, 1));
        MOVE_TABLE.put(Direction.SOUTH, new Point(1, 0));
        MOVE_TABLE.put(Direction.SOUTHWEST, new Point(1, -1));
        MOVE_TABLE.put(Direction.WEST, new Point(0, -1));
        MOVE_TABLE.put(Direction.NORTHEAST, new Point(-1, -1));
    }

    private int row;
    private int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void move(Direction direction) {
        modify(direction);
    }

    public Point getNextPoint(Direction direction) {
        Point nextPoint = new Point(this.row, this.col);
        return nextPoint.modify(direction);
    }

    public Point modify(Direction direction) {
        Point moveStandard = MOVE_TABLE.get(direction);
        this.row += moveStandard.row;
        this.col += moveStandard.col;
        return this;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isOutOfBound() {
        return row < 0 || row >= CHESSBOARD_SIZE || col < 0 || col >= CHESSBOARD_SIZE;
    }

    @Override
    public String toString() {
        return "Point[row=" + row + ", col=" + col + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col;
    }
}
