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
        GameResult result = GameResult.NOT_DECIDED;
        while (result == GameResult.NOT_DECIDED) {
            int[] input = {4, 0, 3};

            Command command = new Command(new Point(input[0], input[1]), input[2]);
            command.execute(board, getCurrentPlayer(turn));
            turn++;

            result = getResult(this.board);
        }
    }

    public GameResult getResult(Board board) {
        boolean user1King = hasKing(user1, board);
        boolean user2King = hasKing(user2, board);

        if(user1King && user2King) return GameResult.NOT_DECIDED;
        if(user1King) return GameResult.USER1;
        if(user2King) return GameResult.USER2;
        return GameResult.DRAW;
    }

    public static boolean hasKing(User user, Board board) {
        for (int i = 0; i < CHESSBOARD_SIZE; i++) {
            for (int j = 0; j < CHESSBOARD_SIZE; j++) {
                Piece piece = board.getPiece(new Point(i, j));
                if(piece instanceof King && piece.isSameUser(user)) {
                    return true;
                }
            }
        }

        return false;
    }

    public User getCurrentPlayer(int turn) {
        if (turn % 2 == 0) return user1;
        return user2;
    }


}

