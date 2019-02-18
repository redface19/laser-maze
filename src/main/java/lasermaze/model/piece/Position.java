package lasermaze.model.piece;

import lasermaze.model.*;

public class Position {

    private Direction direction;
    private Point point;

    public Position(Direction direction, Point point) {
        this.direction = direction;
        this.point = point;
    }

    public Position getOppositePosition(Point point) {
        return new Position(direction.getDiametricalDirection() , point);
    }

    public Direction getRotatedDirection(Rotation rotation) {
        return direction.getRotatedDirection(rotation);
    }

    public void rotate(Direction rotatedDirection) {
        this.direction = rotatedDirection;
    }

    public boolean hasBarrier(Direction rotatedDirection) {
        return point.getNextPoint(rotatedDirection).isOutOfBound();
    }

    public void move(Direction direction) {
        point.move(direction);
    }

    public void move() {
        point.move(direction);
    }

    public Pieceable getNextPiece(Board board) {
        return board.getChessSquare(point);
    }

    @Override
    public String toString() {
        return "Position{" +
                "direction=" + direction +
                ", point=" + point +
                '}';
    }
}
