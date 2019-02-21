package lasermaze.model;

import lasermaze.model.piece.Piece;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;
import lasermaze.model.user.User;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Command {
    private static final Logger log = getLogger(Command.class);

    private Point point;
    private int commandNumber;

    public Command(Point point, int commandNumber) {
//        if (!isValid(input[2])) throw new IllegalArgumentException();
        this.point = point;
        this.commandNumber = commandNumber;
    }

    public void execute(Board board, User user) {
        Piece piece = board.getPiece(point);
        if(!piece.isSameUser(user)) {
            throw new NotSupportedException("this user cannot control this piece");
        }

        int countOfDirection = Direction.values().length;
        if (commandNumber < countOfDirection) {
            Direction direction = Direction.getDirection(commandNumber);
            if(hasBarrier(point, direction) || hasObstacle(board, direction)) {
                throw new NotSupportedException("Can not move Chess Piece");
            }
            piece.move(direction);
            board.swap(point, direction);
        }

        if (commandNumber >= countOfDirection) {
            piece.rotate(Rotation.getRotation(commandNumber));
        }

        board.shoot(user);
    }

    public static boolean hasBarrier(Point point, Direction direction) {
        return point.getNextPoint(direction).isOutOfBound();
    }

    boolean hasObstacle(Board board, Direction direction) {
        return !board.isDummy(point.getNextPoint(direction));
    }


}
