package lasermaze.model;

public class ChessSquare {

    private Point point;
    private ChessPiece chessPiece;

    /* ChessPiece가 있는지 확인하는 메소드 없으면, 디폴트값 */
    public boolean isDefaultChessPiece() {
        return true;
    }

    public boolean isValid(int commandNumber) {
        /* 레이저가 아닐 경우 */
        /* 이동가능한지 (예 : 벽에 막히지 않았는지?, 다른 장기가 있는지?) --> ChessBoards */
        /* 회전 무조건 가능 */

        /* 레이저일 경우 */
        /* 이동불가 */
        /* 회전가능한지 (레이저는 벽 방향으로 회전불가) --> ChessPiece */
        return true;
    }
}
