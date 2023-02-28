import java.util.Scanner;


public class Board {

    public static int dice1;
    public static int dice2;

    public static int dice() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Press Enter to roll dice.");
        myObj.nextLine();

        int maximum = 6;
        int minimum =1;

        dice1 = (int) (Math.random() * (maximum) + minimum);
        dice2 = (int) (Math.random() * (maximum) + minimum);
        int total = dice1 + dice2;

        System.out.println("You rolled a " + dice1 + " and a " + dice2 + "!");
        return total;
    }
    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }
}




