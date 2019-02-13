package lasermaze.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    public void command_생성() {
        int[] input = {};
        Command command = new Command(input);
    }
}