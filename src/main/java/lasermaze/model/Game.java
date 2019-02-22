package lasermaze.model;

import lasermaze.model.piece.common.Point;
import lasermaze.model.piece.King;
import lasermaze.model.piece.Piece;
import lasermaze.model.user.User;

import static lasermaze.model.ChessSquare.CHESSBOARD_SIZE;

public class Game {

    private Board board;
    private User user1;
    private User user2;

    public Game(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        board = new Board(new ChessSquare(user1, user2).pieceInit());
    }

    public void start() {
        int turn = 0;
        User winner = User.DUMMY_USER;
        while (winner.isDummyUser()) {
            int[] input = {4, 0, 3};

            Command command = new Command(new Point(input[0], input[1]), input[2]);
            command.execute(board, getCurrentPlayer(turn));
            turn++;

            winner = getWinner();
        }
    }

    public User getCurrentPlayer(int turn) {
        if (turn % 2 == 0) return user1;
        return user2;
    }

    public User getWinner() {
        boolean kingOfUser1Exist = true;
        boolean kingOfUser2Exist = true;
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            for (int col = 0; col < CHESSBOARD_SIZE; col++) {
                Piece piece = board.getPiece(new Point(row, col));
                kingOfUser1Exist = winnerCheck(piece, user1);
                kingOfUser2Exist = winnerCheck(piece, user2);
            }
        }
        return decideWinner(kingOfUser1Exist, kingOfUser2Exist);
    }

    public boolean winnerCheck(Piece piece, User user) {
        return piece instanceof King && piece.isSameUser(user);
    }

    public User decideWinner(boolean kingOfUser1Exist, boolean kingOfUser2Exist) {
        if (!kingOfUser1Exist) return user2;
        if (!kingOfUser2Exist) return user1;
        return User.DUMMY_USER;
    }
}

