import java.util.Scanner;

public class Animals {
    private String owner;
    private String name;
    private int price;
    private int level;
    private int upgrade;
    private int L1;
    private int L2;
    private int L3;
    private int L4;
    private int L5;
    private int L6;
    private int rent;

    private Animals[] animal;
    Game game = new Game();
    Player[] players = game.getPlayers();

    public Animals(String name, int price, int level, int upgrade, int L1,int L2, int L3, int L4, int L5, int L6, String owner) {

        this.name = name;
        this.price = price;
        this.level = level;
        this.owner = owner;
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
        this.L4 = L4;
        this.L5 = L5;
        this.L6 = L6;
        this.upgrade = upgrade;
    }


    public Animals() {
        animal = new Animals[24];

        animal[0] = new Animals("Worm", 60, 1, 50,2,10,30,90,160,250,  null);
        animal[1] = new Animals("Dragon", 60, 1, 50,2,10,30,90,160,250, null);
        animal[2] = new Animals("Fly", 60, 1,50,4,20,60,180,320,450,null);
        animal[3] = new Animals("Stick insect", 100, 1,50, 6,30,90,270,400,550,null);
        animal[4] = new Animals("Fox", 100, 1,50,6,30,90,270,400,550, null);
        animal[5] = new Animals("Badger", 120, 1,50, 8,40,100,300,450,600,null);
        animal[6] = new Animals("Cat", 140, 1,100, 10,50,150,450,625,750,null);
        animal[7] = new Animals("Cow", 140, 1,100, 10,50,150,450,625,750,null);
        animal[8] = new Animals("Sheep", 160, 1,100, 12,60,180,500,700,900, null);
        animal[9] = new Animals("Horse", 180, 1,100, 14,70,200,550,750,950, null);
        animal[10] = new Animals("Chimpanzee", 180,100, 1, 14,70,200,550,750,950,null);
        animal[11] = new Animals("Orangutan", 200, 1,100, 16,80,220,600,800,1000,null);
        animal[12] = new Animals("Gorilla", 220, 1, 150, 18,90,250,700,875,1050,null);
        animal[13] = new Animals("Tiger Shark", 220, 1,150,18,90,250,700,875,1050, null);
        animal[14] = new Animals("Great White Shark", 240, 1,150, 20,100,300,750,925,1100, null);
        animal[15] = new Animals("Killer Whale", 260, 1,150, 22,110,330,800,975,1150,null);
        animal[16] = new Animals("Jaguar", 260, 1,150, 22,110,330,800,975,1150,null);
        animal[17] = new Animals("Tiger", 280, 1,150, 24,120,360,850,1025, 1200,null);
        animal[18] = new Animals("Lion", 300, 1,200, 26,130,390,900,1100,1275, null);
        animal[19] = new Animals("Triceratops", 300, 1,200,26,130,390,900,1100,1275, null);
        animal[20] = new Animals("Stegosaurus", 320, 1, 200,28,150,450,1000,1200,1400, null);
        animal[21] = new Animals("Tyrannosaurus", 350, 1,200, 35,175,500,1100,1300,1500,null);
        animal[22] = new Animals("Phoenix", 350, 1,200, 35,175,500,1100,1300,1500,null);
        animal[23] = new Animals("Chimera", 400, 1,200,50,200,600,1400,1700,2000, null);
    }



    //for buying an animal using player location and charging money
    public void landOnAnimal (int location, Player player, int numberOfPlayers){

        Animals currentAnimal = animal[location];

        if (currentAnimal.level == 1)
        {
            rent = currentAnimal.L1;
        }
        else if (currentAnimal.level == 2)
        {
            rent = currentAnimal.L2;
        }
        else if (currentAnimal.level == 3)
        {
            rent = currentAnimal.L3;
        }
        else if (currentAnimal.level == 4)
        {
            rent = currentAnimal.L4;
        }
        else if (currentAnimal.level == 5)
        {
            rent = currentAnimal.L5;
        }
        else if (currentAnimal.level == 6)
        {
            rent = currentAnimal.L6;
        }


        if (currentAnimal.owner == null && player.getMoney() >= animal[location].price) {

            int cost = currentAnimal.price;

            System.out.println("Would you like to purchase this animal for " + cost + "$?: '1' for YES '2' for NO");
            Scanner purchaseChoice = new Scanner(System.in);
            int choice;

            do {
                choice = purchaseChoice.nextInt();
            }while (choice != 1 && choice != 2);


                if (choice == 1) {
                    currentAnimal.owner = player.getName();
                    player.takeMoney(currentAnimal.price);
                    System.out.println(player.getName() + " purchased " + currentAnimal.name + " for " + cost + " dollars.");
                }

        }

        else if (currentAnimal.owner == null && player.getMoney() < currentAnimal.price)
        {
            System.out.println("You landed on " + currentAnimal.name + " which is owned by nobody however you are broke :(");
        }

        else if (currentAnimal.owner == player.getName())
        {
            System.out.println("You landed on your animal: " + currentAnimal.name + "!");
        }

        else if (currentAnimal.owner != null && currentAnimal.owner != player.getName())
        {
            System.out.println("You landed on " + currentAnimal.owner + " animal! You must pay " + currentAnimal.price + "$!");
            player.takeMoney(rent);

            for (int x = 0; x < numberOfPlayers;x++){
                if (players[x].getName() == currentAnimal.owner)
                {
                    players[x].addMoney(rent);
                }
            }
        }

    }

    public void upgradeAnimal(Player player)
    {

        System.out.println("Which animal would you like to upgrade?:");

        for (int x = 0; x < animal.length; x++)
        {
            if (animal[x].owner == player.getName() && animal[x].level != 6)
            {
                System.out.println(animal[x].name + " '" + x + "'\n");
            }

        }

        Scanner animalChoice = new Scanner(System.in);
        int animalArrayNo;

        do {
            animalArrayNo = animalChoice.nextInt();
        } while(animal[animalArrayNo].name != player.getName());

        player.takeMoney(animal[animalArrayNo].upgrade);
        animal[animalArrayNo].level += 1;

    }

    public int numberOfProperties(Player player)
    {
        int numberOfAnimals = 0;

        for (int x = 0; x < animal.length; x++)
        {
            if (animal[x].owner == player.getName())
            {
                numberOfAnimals += 1;
            }

        }
        return numberOfAnimals;
    }

    public boolean validateMoney(int animalArray, Player player)
    {
        boolean validateMoney = false;
        if (player.getMoney() >= animal[animalArray].upgrade)
        {
            validateMoney = true;
        }
        return validateMoney;
    }
}
