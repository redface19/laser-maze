package lasermaze.model;

public interface Playable {
    void move(Command command);
    void rotate(Command command);
}
