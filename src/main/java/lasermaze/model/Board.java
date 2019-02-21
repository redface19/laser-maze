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

    private ChessSquare chessSquare;

    public Board(ChessSquare chessSquare) {
        this.chessSquare = chessSquare;
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
