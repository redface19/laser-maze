package lasermaze.model;

import lasermaze.model.piece.Position;

public class LaserPointer {
    private Board board;
    private Position position;

    public LaserPointer(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    public void move() {
        if(!position.isOutOfBound()) {
            position.move();
            position.getNextPiece(board).hit(this);
        }
    }

    public void removePiece() {
        board.deleteChess(position);
    }

    public boolean canRemove(Position piecePosition) {
        return !position.isReflectable(piecePosition);
    }

    public void reflect(Position piecePosition) {
        position.reflect(piecePosition);
    }

    public LaserPointer generateNewLaserPointer(Position piecePosition) {
        return new LaserPointer(board, piecePosition.generateNewPosition(position));
    }

    @Override
    public String toString() {
        return "LaserPointer{" +
                "position=" + position +
                '}';
    }
}
