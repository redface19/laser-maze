package lasermaze.model.fixture;

import lasermaze.model.ChessSquare;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.user.User;

public class BoardFixture {

    public static void putDummy(ChessSquare chessSquare, Point point) {
        chessSquare.putPiece(point, PieceFixture.createDummy(point));
    }

    public static void putKing(ChessSquare chessSquare, User user, Direction direction, Point point) {
        chessSquare.putPiece(point, PieceFixture.createKing(user, direction, point));
    }

    public static void putSquareNight(ChessSquare chessSquare, Direction direction, Point point) {
        chessSquare.putPiece(point, PieceFixture.createSquareNight(direction, point));
    }

    public static void putTriangleNight(ChessSquare chessSquare, Direction direction, Point point) {
        chessSquare.putPiece(point, PieceFixture.createTriangleNight(direction, point));
    }

    public static void putSplitter(ChessSquare chessSquare, Direction direction, Point point) {
        chessSquare.putPiece(point, PieceFixture.createSplitter(direction, point));
    }

    public static void putLaser(ChessSquare chessSquare, Direction direction, Point point) {
        chessSquare.putPiece(point, PieceFixture.createLaser(direction, point));
    }
}
