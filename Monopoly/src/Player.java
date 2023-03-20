public class Player {
    private final char piece;
    private final String name;
    private int money = 1500;
    private int location = 0;
    private boolean miss_turn = false;
    private boolean playerStillIn = true;
    private int numberOfUpgradableProperties;

    public char getPiece(){
        return piece;
    }
    public void setNumberOfProperties(int plusOrMinus){
        numberOfUpgradableProperties += plusOrMinus;
    }

    public int getNumberOfUpgradableProperties (){
        return numberOfUpgradableProperties;
    }

    public boolean getPlayerStillIn(){
        return playerStillIn;
    }

    public Player(char piece, String name) {
        this.piece = piece;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }

    public int getLocation() {
        return location;
    }
    public boolean getMiss_turn() {
        return miss_turn;
    }
    public void setMiss_turn(boolean miss_turn) {
        this.miss_turn = miss_turn;
    }
    public void moveSpaces(int spaces) {
        int maxBoardSpaces = 25;
        this.location = this.location + spaces;
        if (this.location > maxBoardSpaces){
            this.location -= 26;
        }
    }

    public int isBankrupt (int number_of_players){
        if (this.money <= 0)
        {
            number_of_players -= 1;
            System.out.println(this.name + " you have run out of money :( You are out!\n");
            this.playerStillIn = false;
        }

        return number_of_players;
    }

    public void addMoney(int moneyToAdd){
        this.money += moneyToAdd;
    }

    public void takeMoney(int payment){
        this.money -= payment;
    }

}