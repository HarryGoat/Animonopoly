public class Board {
    public void draw(Player[] player, int numberOfPlayers) {

        final String GREEN = "\033[0;32m";
        final String RESET = "\033[0m";

        int[] positions = {391,407,422,439,455,471,487,503,1023,1543,2063,2453,3103,3623,3607,3591,3575
                ,3559,3543,3527,3511,2991,2471,1951,1431,911};
        String board = """
                _________________________________________________________________________________________________________________________________
                |     Start     |     Worm     |      Fly       | Stick insect  |      Fox      |     Badger    |      Cat      |      Cow      |
                |               |              |                |               |               |               |               |               |
                |               |              |                |               |               |               |               |               |
                |_______________|______________|________________|_______________|_______________|_______________|_______________|_______________|
                |    Dragon     |                                                                                               |     Sheep     |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                |    Phoenix    |                                                                                               |     Horse     |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                |    Chimera    |                                                                                               |   Chimpanzee  |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                | Tyrannosaurus |                                                                                               |   Orangutan   |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                |  Stegosaurus  |                                                                                               |    Gorilla    |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|_______________________________________________________________________________________________|_______________|
                |  Triceratops  |     Lion      |     Tiger     |    Jaguar     | Killer Whale  |  Great White  |  Tiger Shark  |   Miss a go   |
                |               |               |               |               |               |               |               |               |
                |               |               |               |               |               |               |               |               |
                |_______________|_______________|_______________|_______________|_______________|_______________|_______________|_______________|
                """;

        char[] temp = board.toCharArray();
        for (int i = 0; i < numberOfPlayers; i++) {
            temp[positions[player[i].getLocation()]+i] = player[i].getPiece();
        }
        String out = new String(temp);
        System.out.println(GREEN + out + RESET);
    }
}

// :]