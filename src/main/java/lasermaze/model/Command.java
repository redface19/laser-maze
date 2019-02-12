package lasermaze.model;

import lasermaze.model.piece.Piece;

public class Command {

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
        if(commandNumber <= 8) piece.move(Direction.getDirection(commandNumber));
        if(commandNumber > 8) piece.rotate(Rotation.getRotation(commandNumber));
    }

//    /* 해당 명령이 수행 가능한지 검사하는 메소드 --> 가능하지 않는 명령어일 경우, 예외발생 */
//    public boolean isValid(int commandNumber) {
//        /* ChessSquare 에게 명령 수행유무를 확인 */
//        return piece.isValid(commandNumber);
//    }

}
