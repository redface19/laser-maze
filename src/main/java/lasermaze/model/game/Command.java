package lasermaze.model.game;

import lasermaze.model.game.piece.Piece;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.piece.common.Rotation;
import lasermaze.model.game.user.GameUser;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Command {
    private static final Logger log = getLogger(Command.class);

    private Point point;
    private int commandNumber;

    public Command(Point point, int commandNumber) {
        this.point = point;
        this.commandNumber = commandNumber;
    }

    public void execute(Board board, GameUser gameUser) {
        Piece piece = board.getPiece(point);
        if(!piece.isSameUser(gameUser)) {
            throw new NotSupportedException("this gameUser cannot control this piece");
        }

        int countOfDirection = Direction.values().length;
        if (commandNumber < countOfDirection) {
            move(board, piece);
        }

        if (commandNumber >= countOfDirection) {
            piece.rotate(Rotation.getRotation(commandNumber));
        }

        board.shoot(gameUser);
    }

    private void move(Board board, Piece piece) {
        Direction direction = Direction.getDirection(commandNumber);
        if(hasBarrier(point, direction) || hasObstacle(board, direction)) {
            throw new NotSupportedException("Can not move Chess Piece");
        }
        piece.move(direction);
        board.swap(point, direction);
    }

    public static boolean hasBarrier(Point point, Direction direction) {
        return point.getNextPoint(direction).isOutOfBound();
    }

    public boolean hasObstacle(Board board, Direction direction) {
        return board.hasObstacle(point, direction);
    }


}
