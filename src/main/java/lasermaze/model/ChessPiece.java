package lasermaze.model;

public abstract class ChessPiece implements ChessPieceable, Playable {
    private Point point;
    private boolean isDead;
    private Direction direction;
}
