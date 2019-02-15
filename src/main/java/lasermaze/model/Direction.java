package lasermaze.model;

public enum Direction {
    NONE(0),
    NORTH(1), NORTHEAST(2), EAST(3), SOUTHEAST(4),
    SOUTH(5), SOUTHWEST(6), WEST(7), NORTHWEST(8);

    private int commandNumber;

    Direction(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static Direction getDirection(int commandNumber) {
        for (Direction value : values()) {
            if(value.commandNumber == commandNumber) return value;
        }
        return null;
    }

    public Direction rotate(Rotation rotation) {
        return null;
    }

    public boolean isRotable(Rotation rotation) {
        return false;
    }
}
