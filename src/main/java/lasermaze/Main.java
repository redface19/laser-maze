package lasermaze;

import lasermaze.model.piece.Game;
import lasermaze.model.user.User;

public class Main {
    public static void main(String[] args) {

        // test User
        User user1 = new User("user1");
        User user2 = new User("user2");
        Game game = new Game(user1, user2);
        game.start();
    }
}
