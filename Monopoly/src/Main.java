public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI();

        gui.number_of_players();
        gui.createPlayers();
        gui.player_name();
        gui.player_piece();




        Game game = new Game();
        game.make_player();
        game.player_turn();

    }
}
