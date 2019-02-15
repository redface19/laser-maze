package lasermaze.model;

import lasermaze.model.piece.Piece;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Command {
    private static final Logger log = getLogger(Command.class);

    /* 해당 Piece */
    private Piece piece;
    /* 이동 (1~8) 회전(9, 10) */
    private int commandNumber;

    public Command(int[] input) {
//        if (!isValid(input[2])) throw new IllegalArgumentException();
        /* 사용자의 입력은 '행, 열, 명령어' */
        piece = Board.getChessSquare(input[0], input[1]);
        commandNumber = input[2];
    }

    public void execute() {
        log.debug("piece : {}", piece);
        if(commandNumber <= 8) piece.move(Direction.getDirection(commandNumber));
        if(commandNumber > 8) piece.rotate(Rotation.getRotation(commandNumber));
    }

}
