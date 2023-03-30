import java.util.Objects;
import java.util.Scanner;

public class Animals {
    public String owner;
    public String name;
    public int price;
    public int level;
    public int upgrade;
    public boolean upgradeable;
    public String soundFile;
    public int L1;
    public int L2;
    public int L3;
    public int L4;
    public int L5;
    public int L6;

    public Animals[] animal;


    public Animals[] getAnimals(){
        return animal;
    }
    public Animals(String name, int price, int level, int upgrade, int L1,int L2, int L3, int L4, int L5, int L6, String owner, boolean upgradeable, String soundFile) {

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
        this.upgradeable = upgradeable;
        this.soundFile = soundFile;
    }


    public Animals() {
        animal = new Animals[24];

        animal[0] = new Animals("Worm", 60, 1, 50,2,10,30,90,160,250,  null, false, "SOUNDS_z_alligator.wav");
        animal[1] = new Animals("Fly", 60, 1, 50,2,10,30,90,160,250, null, false, "SOUNDS_z_ant.wav");
        animal[2] = new Animals("Stick insect", 60, 1,50,4,20,60,180,320,450,null, false, "SOUNDS_z_beaver.wav");
        animal[3] = new Animals("Fox", 100, 1,50, 6,30,90,270,400,550,null, false, "SOUNDS_z_dog.wav");
        animal[4] = new Animals("Badger", 100, 1,50,6,30,90,270,400,550, null, false, "SOUNDS_z_dolphin.wav");
        animal[5] = new Animals("Cat", 120, 1,50, 8,40,100,300,450,600,null, false, "SOUNDS_z_donkey.wav");
        animal[6] = new Animals("Cow", 140, 1,100, 10,50,150,450,625,750,null, false, "SOUNDS_z_cow.wav");
        animal[7] = new Animals("Sheep", 140, 1,100, 10,50,150,450,625,750,null, false, "SOUNDS_z_elephant.wav");
        animal[8] = new Animals("Horse", 160, 1,100, 12,60,180,500,700,900, null, false, "SOUNDS_z_frog.wav");
        animal[9] = new Animals("Chimpanzee", 180, 1,100, 14,70,200,550,750,950, null, false, "SOUNDS_z_giraffe.wav");
        animal[10] = new Animals("Orangutan", 180,100, 1, 14,70,200,550,750,950,null, false, "SOUNDS_z_orangutan.wav");
        animal[11] = new Animals("Gorilla", 200, 1,100, 16,80,220,600,800,1000,null, false, "SOUNDS_z_gorilla.wav");
        animal[12] = new Animals("Tiger Shark", 220, 1, 150, 18,90,250,700,875,1050,null, false, "SOUNDS_z_shark.wav");
        animal[13] = new Animals("Great White Shark", 220, 1,150,18,90,250,700,875,1050, null, false, "SOUNDS_z_leech.wav");
        animal[14] = new Animals("Killer Whale", 240, 1,150, 20,100,300,750,925,1100, null, false, "SOUNDS_z_cheetah.wav");
        animal[15] = new Animals("Jaguar", 260, 1,150, 22,110,330,800,975,1150,null, false, "SOUNDS_z_llama.wav");
        animal[16] = new Animals("Tiger", 260, 1,150, 22,110,330,800,975,1150,null, false, "SOUNDS_z_parrot.wav");
        animal[17] = new Animals("Lion", 280, 1,150, 24,120,360,850,1025, 1200,null, false, "SOUNDS_z_lion.wav");
        animal[18] = new Animals("Triceratops", 300, 1,200, 26,130,390,900,1100,1275, null, false, "SOUNDS_z_penguin.wav");
        animal[19] = new Animals("Stegosaurus", 300, 1,200,26,130,390,900,1100,1275, null, false, "SOUNDS_z_polarbear.wav");
        animal[20] = new Animals("Tyrannosaurus", 320, 1, 200,28,150,450,1000,1200,1400, null, false, "SOUNDS_z_rat.wav");
        animal[21] = new Animals("chimera", 350, 1,200, 35,175,500,1100,1300,1500,null, false, "SOUNDS_z_sealion.wav");
        animal[22] = new Animals("Phoenix", 350, 1,200, 35,175,500,1100,1300,1500,null, false, "SOUNDS_z_snake.wav");
        animal[23] = new Animals("Dragon", 400, 1,200,50,200,600,1400,1700,2000, null, false, "SOUNDS_z_tardigrade.wav");
    }

    //for buying an animal using player location and charging money

    public void displayUpgradeAnimals (Player player){
        for (int x = 0; x < animal.length; x++)
        {
            if (animal[x].upgradeable && Objects.equals(animal[x].owner, player.getName()))
            {
                System.out.println("Animal: " + animal[x].name + " - Cost to upgrade: " + animal[x].upgrade + " - Enter'" + x + "' to Upgrade.");
            }
        }
    }

    public void upgradeAnimal(Player player)
    {
        int maxLevel = 6;
        System.out.println("\nWhich animal would you like to upgrade?\n");

        displayUpgradeAnimals(player);

        boolean arrayIndexVal = false;

        int animalArrayNo;
        do {
            do {
                animalArrayNo = validateIntegerInput();
                if (animalArrayNo < 0 || animalArrayNo > 23)
                {
                    System.out.println("\nPlease enter a valid input: ");
                    displayUpgradeAnimals(player);
                }
            }while (animalArrayNo < 0 || animalArrayNo > 23);

            if (Objects.equals(animal[animalArrayNo].owner, player.getName()))
            {
                arrayIndexVal = true;
            }

            if (!Objects.equals(animal[animalArrayNo].owner, player.getName()))
            {
                System.out.println("\nPlease enter a valid input: ");
                displayUpgradeAnimals(player);
            }

        } while (!arrayIndexVal);


        if (animal[animalArrayNo].level != maxLevel){
            player.takeMoney(animal[animalArrayNo].upgrade);
            animal[animalArrayNo].level += 1;
            System.out.println("Congratulations! You upgraded your " + animal[animalArrayNo].name);
            System.out.println("\nBalance: " + player.getMoney());

        }

        else if (animal[animalArrayNo].level == (maxLevel - 1)){
            player.takeMoney(animal[animalArrayNo].upgrade);
            animal[animalArrayNo].level += 1;
            System.out.println("Congratulations! You upgraded your " + animal[animalArrayNo].name);
            player.setNumberOfProperties(-1);
            System.out.println("\nBalance: " + player.getMoney());

        }

        else{
            System.out.println("Sorry, your " + animal[animalArrayNo].name + " is already at its maximum level!");
        }

        for (Animals animals : animal) {
            animals.upgradeable = false;
        }
    }


    public int validateUpgrade(Player player) {

        int numberOfUpgradeAnimal = 0;

        if (player.getNumberOfUpgradableProperties() > 0) {
            for (Animals animals : animal) {

                if (Objects.equals(animals.owner, player.getName()) && animals.upgrade < player.getMoney()) {
                    animals.upgradeable = true;
                    numberOfUpgradeAnimal += 1;
                }
            }
        }
        return numberOfUpgradeAnimal;
    }

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