import java.util.Scanner;
import java.awt.event.*;


public class Game {
    private int number_of_players;
    public Player[] players;
    int player_turn = 0;
    int animalArray;
    Animals animals = new Animals();
    Player currentPlayer;

    public Player[] getPlayers() {
        return players;
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
            System.out.println("Hello player " + (i + 1) + " What is your name?: ");
            Scanner nameScanner = new Scanner(System.in);
            String chosenName = nameScanner.nextLine();
            Scanner pieceScanner = new Scanner(System.in);
            System.out.println("Please select a piece:");

            int x;

            for (x = 0; x <= pieces.length - 1; x++) {
                if (pieces_val[x] == 1) {
                    System.out.println((x + 1) + " = " + pieces[x] + "\n");
                }
            }

            int chosenPieceIndex;

            do {
                chosenPieceIndex = pieceScanner.nextInt();
            } while (chosenPieceIndex < 1 || chosenPieceIndex > 4 || pieces_val[chosenPieceIndex - 1] == 0);

            players[i] = new Player(pieces[chosenPieceIndex - 1], chosenName);
            pieces_val[chosenPieceIndex - 1] = 0;
        }
    }

    public void player_turn() {


        int previous_location;
        Dice dice = new Dice();
        Cards cards = new Cards();

        do {
            currentPlayer = players[player_turn];

            if (currentPlayer.getMiss_turn() == 0 && currentPlayer.getPlayerStillIn() == 1) {

                System.out.println("Hello " + currentPlayer.getName() + "! It is your turn :)");

                int spaces = dice.roll();


                if (dice.getDice1() != dice.getDice2()) {
                    System.out.println("You rolled a " + dice.getDice1() + " and a " + dice.getDice2() + "!\n");
                } else {
                    System.out.println("You rolled a double " + dice.getDice1() + "!\n");

                    int drawCardChoice;

                    do {

                        System.out.println("Would you like to draw from the deck? Enter:\n'1' for YES\n'2' for NO\n");
                        Scanner drawCardScanner = new Scanner(System.in);

                        drawCardChoice = drawCardScanner.nextInt();

                    } while (drawCardChoice != 1 && drawCardChoice != 2);


                    if (drawCardChoice == 1) {
                        int scenarioIndex = (int) ((Math.random() * 20));

                        int cardMoney = cards.getCard(scenarioIndex);

                        if (scenarioIndex < 10) {
                            currentPlayer.addMoney(cardMoney);
                        } else {
                            currentPlayer.takeMoney(cardMoney);
                        }
                    }
                }


                //get previous location to check whether player pass go
                previous_location = currentPlayer.getLocation();

                //add result of dice onto player location
                currentPlayer.moveSpaces(spaces);
                int location = currentPlayer.getLocation();


                //what happens when land on miss a turn
                if (location == 13) {
                    currentPlayer.setMiss_turn(1);
                }

                //what happens when land on go
                if (location == 0) {
                    currentPlayer.addMoney(400);
                }

                //what happens when pass go
                else if ((location - previous_location) < 0) {
                    currentPlayer.addMoney(200);
                }


                if (currentPlayer.getLocation() < 13)
                {
                    animalArray = currentPlayer.getLocation() - 1;
                }
                else if (currentPlayer.getLocation() < 25)
                {
                    animalArray = currentPlayer.getLocation() - 2;
                }


                if (currentPlayer.getMiss_turn() != 1 && currentPlayer.getLocation() != 0 && currentPlayer.getLocation() != 13) {
                    animals.landOnAnimal(animalArray, currentPlayer, number_of_players);
                    playerOptions();
                }

                number_of_players = currentPlayer.isBankrupt(number_of_players);
            }


            //player only missed one turn
            else if (currentPlayer.getMiss_turn() == 1 && currentPlayer.getPlayerStillIn() == 1) {
                System.out.println(currentPlayer.getName() + ", It is your go however you miss a go!\n");
                currentPlayer.setMiss_turn(0);
            }


            if (++player_turn >= number_of_players) {
                player_turn = 0;
            }
        } while (number_of_players != 1);


    }

    public void playerOptions() {

        int numberOfProperties = animals.numberOfProperties(currentPlayer);
        boolean validateMoney = animals.validateMoney(animalArray, currentPlayer);

        if(numberOfProperties > 0 && validateMoney == true) {
            System.out.println("Options:\n '1' to UPGRADE ANIMAL\n'2' to END TURN");

            int choice;
            do {
                Scanner optionsChoice = new Scanner(System.in);
                choice = optionsChoice.nextInt();
            } while (choice != 1 && choice != 2);

            if (choice == 1) {
                animals.upgradeAnimal(currentPlayer);
            }
        }

        else
        {
            Scanner enter = new Scanner(System.in);
            System.out.println("Press 'ENTER' to end turn: ");
            enter.nextLine();
        }

    }
}