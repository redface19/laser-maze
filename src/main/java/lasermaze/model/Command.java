package lasermaze.model;

import lasermaze.model.piece.Laser;
import lasermaze.model.piece.Piece;
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

    public void execute(Board board) {
        Piece piece = board.getChessSquare(point);
        if (commandNumber <= 8) {
            Direction direction = Direction.getDirection(commandNumber);
            if(hasBarrier(point, direction) || hasObstacle(board, direction)) {
                throw new NotSupportedException("Can not move Chess Piece");
            }
            piece.move(direction);
            board.swap(point, direction);
        }

        if (commandNumber > 8) {
            piece.rotate(Rotation.getRotation(commandNumber));
        }
    }

    public static boolean hasBarrier(Point point, Direction direction) {
        return point.getNextPoint(direction).isOutOfBound();
    }

    boolean hasObstacle(Board board, Direction direction) {
        return !board.isDummy(point.getNextPoint(direction));
    }


}
