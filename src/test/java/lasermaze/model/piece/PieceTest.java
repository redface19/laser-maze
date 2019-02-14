package lasermaze.model.piece;

import lasermaze.model.Direction;
import lasermaze.model.Point;
import lasermaze.model.user.User;
import org.junit.Test;
import org.slf4j.Logger;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class PieceTest {
    private static final Logger log = getLogger(PieceTest.class);

    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Piece piece = new King(new User("Doby"), new Point(4, 0), Direction.EAST, PropertyBundle.KING_PROPRTY.getProperty());
        Piece piece2 = piece.clone();
        piece.direction = Direction.NORTH;
        piece2.direction = Direction.SOUTH;
        log.debug("piece1 : {}", piece);
        log.debug("piece2 : {}", piece2);
    }
}