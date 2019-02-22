package lasermaze.model.fixture;

import lasermaze.model.piece.*;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;

import static lasermaze.model.user.UserTest.DOBY;

public class PieceFixture {

    public static Dummy createDummy(Point point) {
        return new Dummy(User.DUMMY_USER, Direction.NONE, point, CommonPlay.getInstance());
    }

    public static King createKing(User user, Direction direction, Point point) {
        return new King(user, direction, point, NonLaserPiece.getInstance());
    }

    public static Knight createSquareNight(Direction direction, Point point) {
        return new Knight(DOBY, direction, point, NonLaserPiece.getInstance(), HorizontalReflect.getInstance());
    }

    public static Knight createTriangleNight(Direction direction, Point point) {
        return new Knight(DOBY, direction, point, NonLaserPiece.getInstance(), DiagonalReflect.getInstance());
    }

    public static Splitter createSplitter(Direction direction, Point point) {
        return new Splitter(DOBY, direction, point, NonLaserPiece.getInstance(), DiagonalReflect.getInstance());
    }

    public static Laser createLaser(Direction direction, Point point) {
        return new Laser(DOBY, direction, point, LaserPiece.getInstance());
    }

}
