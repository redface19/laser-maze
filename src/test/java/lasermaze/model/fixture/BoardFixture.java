package lasermaze.model.fixture;

import lasermaze.model.game.ChessSquare;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.user.GameUser;

public class BoardFixture {

    public static void putDummy(ChessSquare chessSquare, Point point) {
        chessSquare.putPiece(point, PieceFixture.createDummy(point));
    }

    public static void putKing(ChessSquare chessSquare, GameUser gameUser, Direction direction, Point point) {
        chessSquare.putPiece(point, PieceFixture.createKing(gameUser, direction, point));
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
