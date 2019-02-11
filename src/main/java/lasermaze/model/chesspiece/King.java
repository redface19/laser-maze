package lasermaze.model.chesspiece;

import lasermaze.model.LaserPointer;

public class King extends ChessPiece {

    /* 이동, 회전, 파괴가능 */

//    @Override
//    public boolean isValid(int CommandNumber) {
//        /* 레이저가 아닐 경우 */
//        /* 이동가능한지 (예 : 벽에 막히지 않았는지?, 다른 장기가 있는지?) --> ChessBoards */
//        /* 회전 무조건 가능 */
//
//        /* 레이저일 경우 */
//        /* 이동불가 */
//        /* 회전가능한지 (레이저는 벽 방향으로 회전불가) --> ChessPiece */
//        return true;
//    }

    @Override
    public boolean isDefaultChessPiece() {
        return false;
    }

    @Override
    public boolean canDead() {
        return false;
    }

    @Override
    public void hit(LaserPointer laserPointer) {

    }
}
