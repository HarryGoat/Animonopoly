public class Cards {
    String [] scenarios = {
            "You made a hilarious meme that went viral! Collect $100 in ad revenue.",
            "You caught your little brother stealing your candy stash. Blackmail him for $20.",
            "You were dared to eat a ghost pepper and succeeded! Collect $50 from your friends who bet against you.",
            "You won a dance-off against your nemesis. Collect $75 and rub it in their face.",
            "You pranked your sibling and got away with it. Collect $25 every week for the next 5 weeks as compensation.",
            "You convinced your parents to raise your allowance. Collect $30 and buy yourself something nice.",
            "You found a wallet on the ground and returned it to the owner. Collect a reward of $40 for your honesty.",
            "You made a witty comeback during an argument with your friend. Collect $10 for your sick burns.",
            "You won a bet on a sports game that your friends thought was a sure thing. Collect $15 and remind them to never underestimate you again.",
            "You convinced your teacher to give you a higher grade on your test. Collect $100 for your persuasive skills.",

            "You thought you could jump the curb on your skateboard and wiped out. Pay $50 for your lack of skills.",
            "You lost a bet against your little sibling. Pay them $20 and admit defeat.",
            "You tried to cook a fancy meal for your crush but burned it. Pay $25 for the ruined food.",
            "You got a bad haircut from a cheap salon. Pay $30 and invest in a better hairstylist.",
            "You accidentally sprayed your crush with water while trying to flirt. Pay $75 for your awkwardness.",
            "You forgot to lock your bike and it got stolen. Pay $40 for your forgetfulness.",
            "You lost a game of Truth or Dare and had to do something embarrassing. Pay $60 for your lack of dignity.",
            "You got caught by your friends singing in the shower. Pay $100 for the embarrassment.",
            "You accidentally hit a baseball through a neighbor's window. Pay $50 for the repairs.",
            "You spilled red soda on your brand new white shoes. Pay $15 for the stain remover."
    };

    int [] cardMoney = {
            100,
            20,
            50,
            75,
            25,
            30,
            40,
            10,
            15,
            100,

            50,
            20,
            25,
            30,
            75,
            40,
            60,
            100,
            50,
            15,
    };

    public int getCard(int scenarioIndex){
        System.out.println(scenarios[scenarioIndex] + "\n");

        return cardMoney[scenarioIndex];
    }

}
