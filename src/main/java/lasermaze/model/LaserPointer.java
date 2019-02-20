package lasermaze.model;

import lasermaze.model.piece.Position;

import java.util.Objects;

public class LaserPointer {
    private Board board;
    private Position position;
    private boolean end = false;

    public LaserPointer(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    public LaserPointer(Position position) {
        this.position = position;
    }

    public void move() {
        position.move();
    }

    public void removePiece() {
        board.deleteChess(position);
    }

    public boolean canRemove(Position piecePosition) {
        return !position.isReflectable(piecePosition);
    }

    public void reflect(Position piecePosition) {
        position.reflect(piecePosition);
    }

    public LaserPointer generateNewLaserPointer(Position piecePosition) {
        return new LaserPointer(board, piecePosition.generateNewPosition(position));
    }

    public LaserPointer generateNewLaserPointer() {
        return new LaserPointer(position.generateNewPosition());
    }

    public boolean isEnd() {
        return this.end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Point getPoint() {
        return position.getPoint();
    }

    @Override
    public String toString() {
        return "LaserPointer{" +
                "position=" + position +
                '}';
    }

    public boolean isOutOfBound() {
        return position.isOutOfBound();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaserPointer that = (LaserPointer) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
