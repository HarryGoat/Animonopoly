public class Board {
    public void draw(Player[] player, int numberOfPlayers) {

        int[] positions = {391,407,422,439,455,471,487,503,1023,1543,2063,2453,3103,3623,3607,3591,3575
                ,3559,3543,3527,3511,2991,2471,1951,1431,911};
        String board = """
                _________________________________________________________________________________________________________________________________
                |     Start     |     Worm     |     Dragon     |      Fly      |  Stick insect |      Fox      |     Badger    |      Cat      |
                |               |              |                |               |               |               |               |               |
                |               |              |                |               |               |               |               |               |
                |_______________|______________|________________|_______________|_______________|_______________|_______________|_______________|
                |    Chimera    |                                                                                               |      Cow      |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                |    Phoenix    |                                                                                               |     Sheep     |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                | Tyrannosaurus |                                                                                               |     Horse     |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                |  Stegosaurus  |                                                                                               |   Chimpanzee  |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|                                                                                               |_______________|
                |  Triceratops  |                                                                                               |   Orangutan   |
                |               |                                                                                               |               |
                |               |                                                                                               |               |
                |_______________|_______________________________________________________________________________________________|_______________|
                |     Lion      |     Tiger     |     Jaguar    | Killer Whale  |  Great White  |  Tiger Shark  |    Gorilla    |   Miss a go   |
                |               |               |               |               |               |               |               |               |
                |               |               |               |               |               |               |               |               |
                |_______________|_______________|_______________|_______________|_______________|_______________|_______________|_______________|
                """;

        char[] temp = board.toCharArray();
        for (int i = 0; i < numberOfPlayers; i++) {
            temp[positions[player[i].getLocation()]+i] = player[i].getPiece();
        }
        String out = new String(temp);
        System.out.println(out);
    }
}
