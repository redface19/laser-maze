package lasermaze.model;

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
        log.debug("piece : {}", piece);
        if (commandNumber <= 8) {
            Direction direction = Direction.getDirection(commandNumber);
            piece.move(direction);
            board.swap(point, direction);
        }
        if (commandNumber > 8) piece.rotate(Rotation.getRotation(commandNumber));
    }

}
