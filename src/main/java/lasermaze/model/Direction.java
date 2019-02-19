package lasermaze.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Direction {
    NONE(0),
    NORTH(1), NORTHEAST(2), EAST(3), SOUTHEAST(4),
    SOUTH(5), SOUTHWEST(6), WEST(7), NORTHWEST(8);

    private static final Logger log = LoggerFactory.getLogger(Direction.class);

    private int commandNumber;

    Direction(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static Direction getDirection(int commandNumber) {
        for (Direction value : values()) {
            if(value.commandNumber == commandNumber) return value;
        }
        return null;
    }

    public Direction getRotatedDirection(Rotation rotation) {
        int operand = rotation.equals(Rotation.COUNTERCLOCKWISE)? -1 : 1;
        int newDirection = commandNumber + (2 * operand);

        if(newDirection <= 0 || newDirection > Board.CHESSBOARD_SIZE)
            return getDirection(newDirection - (Board.CHESSBOARD_SIZE * operand));

        return getDirection(newDirection);
    }

    public boolean isReflectable(Direction pieceDirection) {
        if(pieceDirection.isSquareKnight()) {
            return pieceDirection.commandNumber == getDiametricalNumber();
        }
        return pieceDirection.commandNumber + 1 != commandNumber && pieceDirection.commandNumber - 1 != commandNumber;
    }

    public boolean isSquareKnight() {
        return commandNumber % 2 == 1;
    }

    public Direction getDiametricalDirection() {
        return getRotatedDirection(Rotation.COUNTERCLOCKWISE).getRotatedDirection(Rotation.COUNTERCLOCKWISE);
    }

    public int getDiametricalNumber() {
        return getDiametricalDirection().commandNumber;
    }

    public Rotation getTriangleRotation(Direction pieceDirection) {
        if(pieceDirection.commandNumber - commandNumber == 3) return Rotation.CLOCKWISE;
        return Rotation.COUNTERCLOCKWISE;
    }
}
