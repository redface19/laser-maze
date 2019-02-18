package lasermaze.model.piece;

import lasermaze.model.Board;
import lasermaze.model.Command;
import lasermaze.model.Point;
import lasermaze.model.user.User;

public class Game {

    private Board board;
    private User user1;
    private User user2;

    public Game(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        board = new Board(user1, user2);
    }

    public void start() {
        while(true) {
            // test Data
            int[] input = {4, 0, 3};

            Command command = new Command(new Point(input[0], input[1]), input[2]);
            // test Data - user1
            command.execute(board, user1);
        }
    }
}

