public class Player {

    private String piece;
    private String name;
    private int money = 1500;
    private int location = 0;
    private int status;
    private int miss_turn = 0;

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public void addMoney(int moneyToAdd){
        this.money += moneyToAdd;
    }
}


