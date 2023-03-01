import java.util.Scanner;


public class Dice {

    public static int dice1;
    public static int dice2;



    public int roll() {
        Cards cards = new Cards();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Press Enter to roll dice.");
        myObj.nextLine();

        dice1 = (int) ((Math.random() * 5) + 1);
        dice2 = (int) ((Math.random() * 5) + 1);

        int total = dice1 + dice2;
        return total;

    }


    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }
}


