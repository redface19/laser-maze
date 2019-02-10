package lasermaze.model;

public class Command {

    /* 해당 ChessPiece */
    private ChessSquare chessSquare;
    /* 이동 (1~8) 회전(9, 10) */
    private int commandNumber;

    public Command(String input) {
        /* 사용자의 입력은 '가로, 세로, 명령어' */
    }

    /* 해당 명령이 수행 가능한지 검사하는 메소드 --> 가능하지 않는 명령어일 경우, 예외발생 */
    public boolean isValid() {
        /* ChessSquare 에게 명령 수행유무를 확인 */
        return true;
    }

    /*  */

}
