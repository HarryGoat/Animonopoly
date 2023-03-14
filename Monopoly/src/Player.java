public class Player {
    private String piece;
    private String name;
    private int money = 1500;
    private int location = 0;
    private int miss_turn = 0;
    private int playerStillIn = 1;

    public int getPlayerStillIn(){
        return playerStillIn;
    }

    public Player(String piece, String name) {
        this.piece = piece;
        this.name = name;
    }
    public String getPiece() {
        return piece;
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
    public int getMiss_turn() {
        return miss_turn;
    }
    public void setMiss_turn(int miss_turn) {
        this.miss_turn = miss_turn;
    }
    public void moveSpaces(int spaces) {
        this.location = this.location + spaces;
        if (this.location > 25){
            this.location -= 26;
        }
    }
    public int isBankrupt (int number_of_players){
        if (this.money <= 0)
        {
            number_of_players -= 1;
            System.out.println(this.name + " you have run out of money :( You are out!\n");
            this.playerStillIn = 0;
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