package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.Command;
import lasermaze.model.user.User;

public class Game {

    Board board;
    User user1;
    User user2;

    public Game(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        board = new Board(user1, user2);
    }

    public void start() {
        while(true) {
            // test Data
            int[] input = {4, 0, 3};

            Command command = new Command(input);
            command.execute();
        }
    }
}
