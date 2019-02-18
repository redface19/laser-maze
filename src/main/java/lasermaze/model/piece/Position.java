package lasermaze.model.piece;

import lasermaze.model.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Position {
    private static final Logger log = getLogger(Position.class);

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

    public void delete(Piece[][] chessSquares) {
        chessSquares[point.getRow()][point.getCol()] = new Dummy(User.DUMMY_USER, this, PropertyBundle.DUMMY_PROPERTY.getProperty());
    }

    public boolean canDead(Position piecePosition) {
        return direction.canDead(piecePosition.direction);
    }

    public void reflect(Position piecePosition) {
        if(piecePosition.direction.isSquareKnight()) {
            return;
        }
        Rotation reflectedRotation = direction.getTriangleRotation(piecePosition.direction);
        Direction rotatedDirection = direction.getRotatedDirection(reflectedRotation);
        this.direction = rotatedDirection;
    }

    @Override
    public String toString() {
        return "Position{" +
                "direction=" + direction +
                ", point=" + point +
                '}';
    }
}
