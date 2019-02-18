package lasermaze.model;

import lasermaze.model.piece.Position;

public class LaserPointer {
    private Position position;

    public LaserPointer(Position position) {
        this.position = position;
    }


    public void move(Board board) {
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
