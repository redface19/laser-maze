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
        position.move();
        position.getNextPiece(board).hit(this);
    }

    @Override
    public String toString() {
        return "LaserPointer{" +
                "position=" + position +
                '}';
    }
}
