public class Main {
    public static void main(String[] args) {

        Threading soundThread = new Threading();
        soundThread.start();
        Game game = new Game();
        game.make_player();
        game.player_turn();

    }
}

// :]