package lasermaze.model;

import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;

import java.util.Objects;

public class LaserPointer {
    private Direction direction;
    private Point point;
    private boolean end = false;

    public LaserPointer(Direction direction, Point point) {
        this.direction = direction;
        this.point = point;
    }

    public void move() {
        point.move(direction);
    }

    public boolean canRemove(Direction pieceDirection) {
        return !direction.isReflectable(pieceDirection);
    }

    public void reflect(Direction pieceDirection) {
        if(pieceDirection.isSquareKnight()) {
            direction = pieceDirection;
            return;
        }
        Rotation reflectedRotation = direction.getTriangleRotation(pieceDirection);
        Direction rotatedDirection = direction.getRotatedDirection(reflectedRotation);
        this.direction = rotatedDirection;
    }

    public LaserPointer generateNewLaserPointer() {
        return new LaserPointer(direction, point);
    }

    public boolean isEnd() {
        return this.end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Point getPoint() {
        return point;
    }


    public boolean isOutOfBound() {
        return point.isOutOfBound();
    }

    @Override
    public String toString() {
        return "LaserPointer{" +
                "direction=" + direction +
                ", point=" + point +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaserPointer that = (LaserPointer) o;
        return end == that.end &&
                direction == that.direction &&
                Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, point, end);
    }
}
