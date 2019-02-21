package lasermaze.model;

import lasermaze.model.piece.*;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Position;
import lasermaze.model.piece.common.PropertyBundle;
import lasermaze.model.piece.properties.*;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Board {
    private static final Logger log = LoggerFactory.getLogger(Board.class);

    public static final int CHESSBOARD_SIZE = 8;

    private Piece[][] chessSquares = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    public Board(User user1, User user2) {
        dummyInit();
        pieceInit(user1, user2);
    }

    private void pieceInit(User user1, User user2) {
        putSymmetryPieces(4, 0, user2, new King(user1, new Position(Direction.EAST, new Point(4, 0)), new NonLaserPiece()));
        putSymmetryPieces(7, 0, user2, new Laser(user1, new Position(Direction.EAST, new Point(7, 0)), new LaserPiece()));
        putSymmetryPieces(7, 7, user2, new Splitter(user1, new Position(Direction.NORTHEAST, new Point(7, 7)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(7, 4, user2, new Knight(user1, new Position(Direction.NORTHWEST, new Point(7, 4)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(1, 7, user2, new Knight(user1, new Position(Direction.NORTHWEST, new Point(1, 7)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(2, 0, user2, new Knight(user1, new Position(Direction.NORTHEAST, new Point(2, 0)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(3, 3, user2, new Knight(user1, new Position(Direction.NORTHEAST, new Point(3, 3)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(4, 3, user2, new Knight(user1, new Position(Direction.SOUTHEAST, new Point(4, 3)), new NonLaserPiece(), new DiagonalReflect()));
        putSymmetryPieces(3, 0, user2, new Knight(user1, new Position(Direction.EAST, new Point(3, 0)), new NonLaserPiece(), new HorizontalReflect()));
        putSymmetryPieces(5, 0, user2, new Knight(user1, new Position(Direction.EAST, new Point(5, 0)), new NonLaserPiece(), new HorizontalReflect()));
    }

    private void dummyInit() {
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            for (int col = 0; col < CHESSBOARD_SIZE; col++) {
                putDummy(row, col);
            }
        }
    }

    public void putDummy(int row, int col) {
        chessSquares[row][col] = new Dummy(User.DUMMY_USER, new Position(Direction.NONE, new Point(row, col)), new CommonPlay());
    }

    public Piece getChessSquare(int row, int col) {
        return chessSquares[row][col];
    }

    public Piece getChessSquare(Point point) {
        return chessSquares[point.getRow()][point.getCol()];
    }

    public void swap(Point prevPoint, Direction direction) {
        Point nextPoint = prevPoint.getNextPoint(direction);
        chessSquares[nextPoint.getRow()][nextPoint.getCol()] = getChessSquare(prevPoint);
        putDummy(prevPoint.getRow(), prevPoint.getCol());
    }

    public void deleteChess(Position position) {
        position.delete(chessSquares);
    }

    public void putSymmetryPieces(int row, int col, User user2, Piece piece) {
        try {
            chessSquares[row][col] = piece;
            chessSquares[getOpposite(row)][getOpposite(col)] = piece.makeEnemy(new Point(getOpposite(row), getOpposite(col)), user2);
        } catch (CloneNotSupportedException e) {
            log.error("말 생성 오류 발생 : {}", e);
        }
    }

    int getOpposite(int num) {
        return CHESSBOARD_SIZE - num - 1;
    }

    public boolean isDummy(Point nextPoint) {
        return getChessSquare(nextPoint) instanceof Dummy;
    }

    public Laser getLaser(User user) {
        for (Piece[] chessSquare : chessSquares) {
            for (Piece piece : chessSquare) {
                if (piece.isSameUser(user) && piece instanceof Laser) return (Laser) piece;
            }
        }
        throw new NotSupportedException("cannot find laser piece");
    }

    public void shoot(User user) {
        Position laserPosition = getLaser(user).generateNewPosition();

        Queue<LaserPointer> lasers = new LinkedList<>();
        LaserPointer laserPointer = new LaserPointer(laserPosition.generateNewPosition());
        lasers.add(laserPointer);

        while (!lasers.isEmpty()) {
            int size = lasers.size();
            for (int i = 0; i < size; i++) {
                LaserPointer pointer = lasers.poll();
                pointer.move();
                Piece nextPiece = getChessSquare(pointer.getPoint());
                if (nextPiece instanceof Splitter && !pointer.isOutOfBound()) {
                    lasers.offer(pointer.generateNewLaserPointer());
                }
                nextPiece.hit(pointer);
                if (!(pointer.isEnd() || pointer.isOutOfBound())) {
                    lasers.offer(pointer);
                }
            }
        }
    }
}
