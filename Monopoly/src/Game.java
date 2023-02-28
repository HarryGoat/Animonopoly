import java.util.Scanner;

public class Game {

    private int number_of_players;
    private Player[] players;

    public Game() {

    }

    public void make_player() {

        System.out.println("Welcome to animonopoly!\n");

        do {
            Scanner players = new Scanner(System.in);
            System.out.println("How many players? 2-4: ");
            number_of_players = players.nextInt();

        } while (number_of_players < 2 || number_of_players > 4);

        players = new Player[number_of_players];

        String[] pieces = {"!", "?", "$", "%"};
        int[] pieces_val = {1, 1, 1, 1};

        for (int i = 0; i < number_of_players; i++) {

//            players[i].setStatus(1);

            System.out.println("Hello player " + (i + 1) + " What is your name?: ");
            Scanner nameScanner = new Scanner(System.in);
            String chosenName = nameScanner.nextLine();

            Scanner pieceScanner = new Scanner(System.in);
            System.out.println("Please select a piece:");



            int x;
            for (x = 0; x <= pieces.length - 1; x++)
            {
                if (pieces_val[x] == 1)
                {
                    System.out.println((x + 1) + " = " + pieces[x] + "\n");
                }
            }

            int chosenPieceIndex;
            do
            {
                chosenPieceIndex = pieceScanner.nextInt();
            } while (chosenPieceIndex < 1 || chosenPieceIndex > 4 || pieces_val[chosenPieceIndex - 1] == 0);

            players[i] = new Player(pieces[chosenPieceIndex - 1], chosenName);

            pieces_val[chosenPieceIndex - 1] = 0;
        }
    }

    public void player_turn() {
        int player_turn = 0;
        int previous_location;

        Player currentPlayer = players[player_turn];

        do {
            if (currentPlayer.getMiss_turn() == 0) {
                Board board = new Board();
                int spaces = Board.dice();


                //get previous location to check whether player pass go
                previous_location = currentPlayer.getLocation();

                //add result of dice onto player location
                currentPlayer.moveSpaces(spaces);
                int location = currentPlayer.getLocation();
                int money = currentPlayer.getMoney();


                //choice to draw card if player rolls a double
                if (board.getDice1() == board.getDice2()) {
                    System.out.println("You rolled a double" + board.getDice1() + "!\n");

                    int drawCardChoice;

                    do {

                        System.out.println("Would you like to draw from the deck? Enter:\n'1' for YES\n'2' for NO\n");
                        Scanner drawCardScanner = new Scanner(System.in);

                        drawCardChoice = drawCardScanner.nextInt();

                    } while (drawCardChoice != 1 || drawCardChoice != 2);



                    if (drawCardChoice == 1) {
                        //function for choosing cardz
                    }
                }

                //what happens when land on miss a turn
                if (location == 13)
                {
                    currentPlayer.setMiss_turn(1);
                }

                //what happens when land on go
                if (location == 0)
                {
                    currentPlayer.addMoney(1000);
                }

                //what happens when pass go
                else if ((location - previous_location) < 0)
                {
                    currentPlayer.addMoney(500);
                }


            }

            //player only missed one turn
            else
            {
                System.out.println(currentPlayer.getName() + ", It is your go however you miss a go!\n");
                currentPlayer.setMiss_turn(0);
            }


            if (++player_turn >= number_of_players) {
                player_turn = 0;
            }
        } while (number_of_players != 1);
    }


}






