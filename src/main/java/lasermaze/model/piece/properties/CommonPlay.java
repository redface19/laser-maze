package lasermaze.model.piece.properties;

import lasermaze.model.NotSupportedException;
import lasermaze.model.piece.common.Direction;
import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.common.Rotation;

public class CommonPlay implements Playable {

    @Override
    public void move(Point point, Direction direction) {
        throw new NotSupportedException("This piece Can not move");
    }

    @Override
    public Direction rotate(Direction direction, Rotation rotation) {
        throw new NotSupportedException("This piece Can not rotate");
    }
}
