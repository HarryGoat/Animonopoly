import java.util.Objects;
import java.util.Scanner;

public class Game {
    Animals[] animals;
    private Player[] players;
    Animals animalInstance;
    Player currentPlayer;
    private int numberOfPlayers;
    int player_turn = 0;
    int animalArray;
    int rent;
    Sound sound = new Sound();


    public Game() {
        // Create an instance of the Animals class and retrieve the animals array
        animalInstance = new Animals();
        animals = animalInstance.getAnimals();
    }


    public void make_player() {
        final int minPlayers = 2;
        final int maxPlayers = 4;

        System.out.println("Welcome to animonopoly!");
        do {
            System.out.println("\nHow many players? 2-4: ");

            numberOfPlayers = validateIntegerInput();

            if (numberOfPlayers < minPlayers || numberOfPlayers > maxPlayers){
                System.out.println("\nPlease enter a valid input from 2-4: ");
            }
        } while (numberOfPlayers < minPlayers || numberOfPlayers > maxPlayers);

        players = new Player[numberOfPlayers];
        char[] pieces = {'!', '?', '$', '%'};
        boolean [] pieces_val = {true, true, true, true};

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("\nHello player " + (i + 1) + " What is your name?: ");


            Scanner nameScanner = new Scanner(System.in);
            String chosenName;

            do {
                chosenName = nameScanner.nextLine().trim();

                if (chosenName.equals("")){
                    System.out.println("\nPlease enter a valid name containing characters.");
                }
            } while(chosenName.equals(""));


            System.out.println("\nPlease select a piece:");



            for (int x = 0; x < pieces.length; x++) {
                if (pieces_val[x]) {
                    System.out.println((x + 1) + " = " + pieces[x]);
                }
            }

            int chosenPieceIndex;

            do {
                chosenPieceIndex = validateIntegerInput();
                if(chosenPieceIndex >= 1 && chosenPieceIndex <= 4 && !pieces_val[chosenPieceIndex - 1]){
                    System.out.println("\nSorry but that piece is already taken. Please select another piece: ");
                }

                else if (chosenPieceIndex < 1 || chosenPieceIndex > 4){
                    System.out.println("\nPlease enter a valid input from 1-4: ");

                }
            } while (chosenPieceIndex < 1 || chosenPieceIndex > 4 || !pieces_val[chosenPieceIndex - 1]);

            players[i] = new Player(pieces[chosenPieceIndex - 1], chosenName);
            pieces_val[chosenPieceIndex - 1] = false;

        }

    }

    public void player_turn() {

        Dice dice = new Dice();
        Cards cards = new Cards();
        Board board = new Board();
        int previous_location;
        final int maxPositiveScenarioIndex = 10;
        final int missGoIndex = 13;
        final int GoIndex = 0;
        final int landOnGoMoney = 400;
        final int passGoMoney = 200;
        final int maxBoardSpaces = 25;

        do {
            currentPlayer = players[player_turn];

            board.draw(players, numberOfPlayers);

            if (!currentPlayer.getMiss_turn() && currentPlayer.getPlayerStillIn()) {

                System.out.println("\nHello " + currentPlayer.getName() + "! It is your turn :)\nBalance: " + currentPlayer.getMoney());

                int spaces = dice.roll();

                if (dice.getDice1() != dice.getDice2()) {
                    System.out.println("You rolled a " + dice.getDice1() + " and a " + dice.getDice2() + "!\n");
                } else {
                    System.out.println("You rolled a double " + dice.getDice1() + "!\n");

                    int drawCardChoice;

                    do {

                        System.out.println("Would you like to draw from the deck? Enter:\n'1' for YES\n'2' for NO\n");

                        drawCardChoice = validateIntegerInput();

                        if (drawCardChoice != 1 && drawCardChoice != 2){
                            System.out.println("\nPlease enter a valid input, either 1 or 2: ");

                        }

                    } while (drawCardChoice != 1 && drawCardChoice != 2);

                    if (drawCardChoice == 1) {
                        int scenarioIndex = (int) ((Math.random() * 20));

                        int cardMoney = cards.getCard(scenarioIndex);

                        if (scenarioIndex < maxPositiveScenarioIndex)
                        {
                            currentPlayer.addMoney(cardMoney);
                        }
                        else {
                            currentPlayer.takeMoney(cardMoney);
                        }
                        System.out.println("\nBalance: " + currentPlayer.getMoney());

                    }
                }

                //get previous location to check whether player pass go
                previous_location = currentPlayer.getLocation();

                //add result of dice onto player location
                currentPlayer.moveSpaces(spaces);
                int location = currentPlayer.getLocation();

                //what happens when land on miss a turn
                if (location == missGoIndex) {
                    currentPlayer.setMiss_turn(true);
                    System.out.println("You landed on miss a go! You...miss a go lol.\n");
                }

                //what happens when land on go
                if (location == GoIndex) {
                    currentPlayer.addMoney(landOnGoMoney);
                    System.out.println("You landed on go! Collect 400.\n");

                }

                //what happens when pass go
                else if ((location - previous_location) < GoIndex) {
                    currentPlayer.addMoney(passGoMoney);
                    System.out.println("You passed go! Collect 200.\n");
                }

                if (currentPlayer.getLocation() < missGoIndex)
                {
                    animalArray = currentPlayer.getLocation() - 1;
                }
                else if (currentPlayer.getLocation() < maxBoardSpaces)
                {
                    animalArray = currentPlayer.getLocation() - 2;
                }

                if (!currentPlayer.getMiss_turn() && currentPlayer.getLocation() != GoIndex && currentPlayer.getLocation() != missGoIndex) {
                    landOnAnimal(animalArray, currentPlayer, numberOfPlayers);
                    playerOptions();
                }

                numberOfPlayers = currentPlayer.isBankrupt(numberOfPlayers);
            }

            //player only missed one turn
            else if (currentPlayer.getMiss_turn() && currentPlayer.getPlayerStillIn()) {
                System.out.println(currentPlayer.getName() + ", It is your go however you miss a go!\n");
                currentPlayer.setMiss_turn(false);
            }

            if (++player_turn >= numberOfPlayers) {
                player_turn = 0;
            }
        } while (numberOfPlayers != 1);


        for (Player player : players) {
            if (player.getPlayerStillIn()) {
                System.out.println("\n\n\nCongratulation " + player.getName() + "! You are the last player standing. You have won animonopoly :)");
                System.exit(0);
            }
        }
    }

    public void playerOptions() {

        int numberOfUpgradeableAnimals = animalInstance.validateUpgrade(currentPlayer);

        if (numberOfUpgradeableAnimals > 0) {
            System.out.println("\nOptions:\n'1' to UPGRADE ANIMAL\n'2' to END TURN");


            int choice;
            do {
                choice = validateIntegerInput();

                if (choice != 1 && choice != 2)
                {
                    System.out.println("\nPlease enter either 1 or 2: ");
                }
            } while (choice != 1 && choice != 2);

            if (choice == 1) {
                animalInstance.upgradeAnimal(currentPlayer);
                playerOptions();
            }
        }


        else
        {
            Scanner enter = new Scanner(System.in);

            System.out.println("\nYou cannot upgrade any animals :( Press 'ENTER' to end turn: ");
            enter.nextLine();
        }
    }

    public void landOnAnimal (int location, Player player, int numberOfPlayers){

        Animals currentAnimal = animals[location];

        switch (currentAnimal.level) {
            case 1 -> rent = currentAnimal.L1;
            case 2 -> rent = currentAnimal.L2;
            case 3 -> rent = currentAnimal.L3;
            case 4 -> rent = currentAnimal.L4;
            case 5 -> rent = currentAnimal.L5;
            case 6 -> rent = currentAnimal.L6;
        }

        sound.PlayAnimalSound(currentAnimal.soundFile);

        if (currentAnimal.owner == null && player.getMoney() >= animals[location].price) {

            int cost = currentAnimal.price;

            System.out.println("Would you like to purchase a " + currentAnimal.name + " for " + cost + "$?\n'1' for YES \n'2' for NO");
            int choice;

            do {
                choice = validateIntegerInput();

                if (choice != 1 && choice != 2)
                {
                    System.out.println("\nPlease enter either 1 or 2: ");

                }
            }while (choice != 1 && choice != 2);


            if (choice == 1) {
                currentAnimal.owner = player.getName();
                player.takeMoney(currentAnimal.price);
                System.out.println(player.getName() + " purchased " + currentAnimal.name + " for " + cost + " dollars.");
                player.setNumberOfProperties(1);
                System.out.println("\nBalance: " + currentPlayer.getMoney());
            }
        }

        else if (currentAnimal.owner == null && player.getMoney() < currentAnimal.price)
        {
            System.out.println("You landed on " + currentAnimal.name + " which is owned by nobody however you are broke :(");
        }

        else if (Objects.equals(currentAnimal.owner, player.getName()))
        {
            System.out.println("You landed on your animal: " + currentAnimal.name + "!");
        }

        else if (currentAnimal.owner != null && !currentAnimal.owner.equals(player.getName()))
        {
            System.out.println("You landed on " + currentAnimal.owner + "'s animal! You paid " + rent + "$!");
            player.takeMoney(rent);
            System.out.println("\nBalance: " + currentPlayer.getMoney());


            for (int x = 0; x < numberOfPlayers;x++){
                if (Objects.equals(players[x].getName(), currentAnimal.owner))
                {
                    players[x].addMoney(rent);
                }
            }
        }

    }
    //add parameter taking max and min number to check whether number is between a certain range
    public int validateIntegerInput() {
        int integer;

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        try {
            integer = Integer.parseInt(userInput);
            return integer;
        }
        catch (NumberFormatException e) {
            System.out.println("\n" + userInput + " is not an integer. Please enter an integer: ");
            integer = validateIntegerInput();
            return integer;
        }
    }

}

// :]