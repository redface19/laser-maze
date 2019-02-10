package lasermaze.model;

public enum Direction {
    NORTH(1), NORTHEAST(2), EAST(3), SOUTHEAST(4),
    WEST(5), SOUTHWEST(6), SOUTH(7), NORTHWEST(8);

    private int commandNumber;

    Direction(int commandNumber) {
        this.commandNumber = commandNumber;
    }
}
