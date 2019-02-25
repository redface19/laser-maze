package lasermaze.model;

import lasermaze.model.piece.Piece;
import lasermaze.model.piece.Splitter;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Board {
    private static final Logger log = LoggerFactory.getLogger(Board.class);

    private ChessSquare chessSquare;

    public Board(ChessSquare chessSquare) {
        this.chessSquare = chessSquare;
    }

    public void shoot(User user) {
        List<LaserPointer> lasers = new ArrayList<>();
        LaserPointer laserPointer = chessSquare.getLaser(user).generateLaserPointer();
        lasers.add(laserPointer);

        while (!lasers.isEmpty()) {
            ListIterator<LaserPointer> iterator = lasers.listIterator();
            int size = lasers.size();
            for (int i = 0; i < size; i++) {
                LaserPointer pointer = iterator.next();
                pointer.move();

                Piece nextPiece = getPiece(pointer.getPoint());
                if (nextPiece instanceof Splitter) {
                    lasers.add(pointer.generateNewLaserPointer());
                }
                nextPiece.hit(pointer);

                if(isRemovable(pointer)) iterator.remove();

                log.debug("pointer : {}", pointer.getPoint());
            }
        }
    }

    private boolean isRemovable(LaserPointer pointer) {
        if(pointer.isEnd()) {
            deletePiece(pointer);
            return true;
        }
        return pointer.getNextPoint().isOutOfBound();
    }

    public void deletePiece(LaserPointer pointer) {
        chessSquare.putPiece(pointer.getPoint(), chessSquare.createDummy(pointer.getPoint()));
    }

    public Piece getPiece(Point point) {
        return chessSquare.getPiece(point);
    }

    public void swap(Point prevPoint, Direction direction) {
        chessSquare.swap(prevPoint, direction);
    }

    public boolean hasObstacle(Point point, Direction direction) {
        return !chessSquare.isDummy(point.getNextPoint(direction));
    }

}
