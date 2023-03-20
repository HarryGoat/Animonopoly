import java.util.Objects;
import java.util.Scanner;

public class Animals {
    public String owner;
    public String name;
    public int price;
    public int level;
    public int upgrade;
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


    public void upgradeAnimal(Player player)
    {
        int maxLevel = 6;
        System.out.println("\nWhich animal would you like to upgrade?\n");

        for (int x = 0; x < animal.length; x++)
        {
            if (Objects.equals(animal[x].owner, player.getName()))
            {
                System.out.println("Animal: " + animal[x].name + " - Cost to upgrade: " + animal[x].upgrade + " - Enter'" + x + "' to Upgrade.");
            }

        }

        Scanner animalChoice = new Scanner(System.in);
        int animalArrayNo;

        do {
            animalArrayNo = animalChoice.nextInt();
        } while(!Objects.equals(animal[animalArrayNo].owner, player.getName()));

        if (animal[animalArrayNo].level != maxLevel){
            player.takeMoney(animal[animalArrayNo].upgrade);
            animal[animalArrayNo].level += 1;
            System.out.println("Congratulations! You upgraded your " + animal[animalArrayNo].name);
        }

        else if (animal[animalArrayNo].level == (maxLevel - 1)){
            player.takeMoney(animal[animalArrayNo].upgrade);
            animal[animalArrayNo].level += 1;
            System.out.println("Congratulations! You upgraded your " + animal[animalArrayNo].name);
            player.setNumberOfProperties(-1);
        }

        else{
            System.out.println("Sorry, your " + animal[animalArrayNo].name + " is already at its maximum level!");
        }
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
