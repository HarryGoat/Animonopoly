public class animals {
    private  String name;
    private  int price;
    private  int level;
    private String owner;
    //basic methods
    public  String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getLevel() {
        return level;
    }
    public int upgrade() {
        return level+1;
    }

    animals[] animal = new animals[26];
    public animals(String name, double price, int level, String owner) {
        name = name;
        price = price;
        level = level;
        owner = owner;
    }

    //array for animals including their names, prices and levels
    public void makeAnimals()
    {
        animal[1] = new animals("Worm", 50.0, 1, null);
        animal[2] = new animals("Fly", 50.0, 1,null);
        animal[3] = new animals("Stick insect", 50.0, 1,null);
        animal[4] = new animals("Fox", 70.0, 1,null);
        animal[5] = new animals("Badger", 70.0, 1,null);
        animal[6] = new animals("Cat", 70.0, 1,null);
        animal[7] = new animals("Cow", 100.0, 1,null);
        animal[8] = new animals("Sheep", 100.0, 1,null);
        animal[9] = new animals("Horse", 100.0, 1,null);
        animal[10] = new animals("Chimpanzee", 130.0, 1,null);
        animal[11] = new animals("Orangutan", 130.0, 1,null);
        animal[12] = new animals("Gorilla", 130.0, 1,null);
        animal[14] = new animals("Tiger Shark", 150.0, 1,null);
        animal[15] = new animals("Great White Shark", 150.0, 1,null);
        animal[16] = new animals("Killer Whale", 150.0, 1,null);
        animal[17] = new animals("Jaguar", 200.0, 1,null);
        animal[18] = new animals("Tiger", 200.0, 1,null);
        animal[19] = new animals("Lion", 200.0, 1,null);
        animal[20] = new animals("Triceratops", 250.0, 1,null);
        animal[21] = new animals("Stegosaurus", 250.0, 1,null);
        animal[22] = new animals("Tyrannosaurus", 250.0, 1,null);
        animal[23] = new animals("Phoenix", 300.0, 1,null);
        animal[24] = new animals("Chimera", 300.0, 1,null);
        animal[25] = new animals("Dragon", 300.0, 1,null);
    }

    //for buying an animal using player location and charging money

    public void purchaseAnimal (int location, int money)
    {

        if (animal[location].owner == null)
        {

            int cost = animal[location].price;

            if (money >= cost)
            {
                System.out.println("Would you like to purchase " + animal[location].name + " for " + animal[location].price + "$?\n '1' for YES '2' for NO");


                player.addAnimal(location, animal);
                player.pay(cost);
                owners.put(location, player);
                System.out.println(player.getName() + " purchased " + getName() + " for " + cost + " dollars.");
            }

            else
            {
                System.out.println(player.getName() + " does not have enough money to purchase " + getName() + ".");
            }
        }
    }

    //for upgrading the animals using key and location
    public void upgradeAnimal ( int location, Player player){
        animals animal[] = board.get(location);
        if (animal[] != null && owners.containsKey(location) && owners.get(location) == player) {
            double cost = getPrice();
            if (player.getMoney() >= cost) {
                animal.upgrade();
                player.pay(cost);
                System.out.println(player.getName() + " upgraded " + getName() + " to level " + getLevel() + " for " + cost + " dollars.");
            } else {
                System.out.println(player.getName() + " does not have enough money to upgrade " + getName() + ".");
            }
        }
    }

    //for checking and charging players who land on another players animal
    public void landedOnSpace ( int location, Player player){
        animals animal[] = board.get(location);
        if (animal[] != null && owners.containsKey(location) && owners.get(location) != player) {
            double cost = animals.getPrice() * animals.getLevel();
            player.pay(cost);
            owners.get(location).addMoney(cost);
            System.out.println(player.getName() + " landed on " + getName() + "'s space and paid " + cost + " dollars to " + owners.get(location).getName() + ".");
        }
    }
}
