package lasermaze.model;

import lasermaze.model.piece.LaserPiece;
import lasermaze.model.piece.NonLaserPiece;
import lasermaze.model.piece.Playable;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    public void command_생성() {
        int[] input = {4, 0, 3};
        Command command = new Command(input);
        command.execute();
    }

    @Test
    public void test() {
        Playable playable = new LaserPiece();
        Map<String, Playable> map = new HashMap<>();
        map.put("1", playable);
        changeStatus(map);
        assertThat(map.get("1") instanceof NonLaserPiece).isTrue();
    }

    public void changeStatus(Map<String, Playable> map) {
        Playable target = new NonLaserPiece();
        map.put("1", target);
    }
}