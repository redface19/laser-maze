package lasermaze;

import lasermaze.model.game.Game;
import lasermaze.model.game.user.GameUser;

public class Main {
    public static void main(String[] args) {

        // test GameUser
        GameUser gameUser1 = new GameUser("gameUser1");
        GameUser gameUser2 = new GameUser("gameUser2");
        Game game = new Game(gameUser1, gameUser2);
        game.start();
    }
}
