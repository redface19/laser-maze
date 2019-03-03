package lasermaze.model.game;

import lasermaze.model.game.piece.Piece;
import lasermaze.model.game.piece.Splitter;
import lasermaze.model.game.piece.common.Direction;
import lasermaze.model.game.piece.common.Point;
import lasermaze.model.game.user.GameUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Board {
    private static final Logger log = LoggerFactory.getLogger(Board.class);

    private ChessSquare chessSquare;

    public Board(ChessSquare chessSquare) {
        this.chessSquare = chessSquare;
    }

    public void shoot(GameUser gameUser) {
        List<LaserPointer> lasers = new ArrayList<>();
        LaserPointer laserPointer = chessSquare.getLaser(gameUser).generateLaserPointer();
        lasers.add(laserPointer);

        for (int i = 0; i < lasers.size(); i++) {
            LaserPointer currentPointer = move(lasers, i);
            if(currentPointer.isEnd()) deletePiece(lasers.get(i));
        }
    }

    public LaserPointer move(List<LaserPointer> lasers, int index) {
        LaserPointer laserPointer = lasers.get(index);
        while(!laserPointer.isEnd() && !laserPointer.getNextPoint().isOutOfBound()) {
            laserPointer.move();
            log.debug("pointer : {}", laserPointer.getPoint());

            Piece nextPiece = getPiece(laserPointer.getPoint());
            if (nextPiece instanceof Splitter) {
                lasers.add(laserPointer.generateNewLaserPointer());
            }
            nextPiece.hit(laserPointer);
        }

        return laserPointer;
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
