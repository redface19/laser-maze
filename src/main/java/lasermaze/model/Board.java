package lasermaze.model;

import lasermaze.model.piece.Piece;
import lasermaze.model.piece.Splitter;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class Board {
    private static final Logger log = LoggerFactory.getLogger(Board.class);

    private ChessSquare chessSquare;

    public Board(ChessSquare chessSquare) {
        this.chessSquare = chessSquare;
    }

    public void shoot(User user) {
        Queue<LaserPointer> lasers = new LinkedList<>();
        LaserPointer laserPointer = chessSquare.getLaser(user).generateLaserPointer();
        lasers.add(laserPointer);

        while (!lasers.isEmpty()) {
            int size = lasers.size();
            for (int i = 0; i < size; i++) {
                LaserPointer pointer = lasers.poll();
                pointer.move();

                if(pointer.isOutOfBound()) {
                    continue;
                }

                Piece nextPiece = getPiece(pointer.getPoint());
                if (nextPiece instanceof Splitter && !pointer.isOutOfBound()) {
                    lasers.offer(pointer.generateNewLaserPointer());
                }

                nextPiece.hit(pointer);

                if(pointer.isEnd()) {
                    deletePiece(pointer);
                }

                if (!(pointer.isEnd() || pointer.isOutOfBound())) {
                    lasers.offer(pointer);
                }

                log.debug("pointer : {}", pointer.getPoint());
            }
        }
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
