package lasermaze.model.fixture;

import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.King;
import lasermaze.model.piece.Knight;
import lasermaze.model.piece.Splitter;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.CommonPlay;
import lasermaze.model.piece.properties.DiagonalReflect;
import lasermaze.model.piece.properties.HorizontalReflect;
import lasermaze.model.piece.properties.NonLaserPiece;
import lasermaze.model.user.User;

import static lasermaze.model.user.UserTest.DOBY;

public class PieceFixture {

    public static Dummy createDummy(Point point) {
        return new Dummy(User.DUMMY_USER, Direction.NONE, point, new CommonPlay());
    }

    public static King createKing(Direction direction, Point point) {
        return new King(DOBY, direction, point, new NonLaserPiece());
    }

    public static Knight createSquareNight(Direction direction, Point point) {
        return new Knight(DOBY, direction, point, new NonLaserPiece(), new HorizontalReflect());
    }

    public static Knight createTriangleNight(Direction direction, Point point) {
        return new Knight(DOBY, direction, point, new NonLaserPiece(), new DiagonalReflect());
    }

    public static Splitter createSplitter(Direction direction, Point point) {
        return new Splitter(DOBY, direction, point, new NonLaserPiece(), new DiagonalReflect());
    }
}
