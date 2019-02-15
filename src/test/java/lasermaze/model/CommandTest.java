package lasermaze.model;

import lasermaze.model.piece.Dummy;
import lasermaze.model.piece.King;
import org.junit.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class CommandTest {
    private static final Logger log = getLogger(CommandTest.class);

    @Test
    public void command_생성() {
        int[] input = {4, 0, 3};
        Command command = new Command(input);
        command.execute();
    }

    @Test
    public void 정상적으로_이동() {
        int[] input = {4, 0, 3};
        Command command = new Command(input);
        command.execute();
        assertThat(Board.getChessSquare(4, 1) instanceof King).isTrue();
        assertThat(Board.getChessSquare(4, 0) instanceof Dummy).isTrue();
    }
}