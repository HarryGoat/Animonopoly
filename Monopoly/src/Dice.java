import java.util.Scanner;

public class Dice {

    public static int dice1;
    public static int dice2;



    public int roll() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("\nPress Enter to roll dice.");
        myObj.nextLine();

        dice1 = (int) ((Math.random() * 5) + 1);
        dice2 = (int) ((Math.random() * 5) + 1);

        return dice1 + dice2;

    }


    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }
}