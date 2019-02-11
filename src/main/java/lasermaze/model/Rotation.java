package lasermaze.model;

public enum Rotation {
    CLOCKWISE(9), COUNTERCLOCKWISE(10);

    private int commandNumber;

    Rotation(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static Rotation getRotation(int commandNumber) {
        return null;
    }
}
