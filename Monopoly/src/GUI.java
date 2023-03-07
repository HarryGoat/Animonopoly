import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JLabel label;
    private JFrame frame = new JFrame();

    private JPanel panel;

    private JButton enter;

    private JButton[] NoOfPlayersButton;
    private JButton[] playersPieceButton;

    private Player[] players;
    public int number_of_players;
    private int i;
    private String PlayerName;


    public GUI () {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);
    }



    private JButton players_button1;

    public void number_of_players ()
    {
        label = new JLabel("Welcome To Animonopoly!");
        //have label in center of screen until the game starts
        NoOfPlayersButton = new JButton[3];

        NoOfPlayersButton[0] = new JButton("1");
        NoOfPlayersButton[0].setBounds(10,80,80,25);
        NoOfPlayersButton[0].addActionListener(this);
        panel.add(NoOfPlayersButton[0]);

        NoOfPlayersButton[1] = new JButton("2");
        NoOfPlayersButton[1].setBounds(10,80,80,25);
        NoOfPlayersButton[1].addActionListener(this);
        panel.add(NoOfPlayersButton[1]);

        NoOfPlayersButton[2] = new JButton("3");
        NoOfPlayersButton[2].setBounds(10,80,80,25);
        NoOfPlayersButton[2].addActionListener(this);
        panel.add(NoOfPlayersButton[2]);

        NoOfPlayersButton[3] = new JButton("4");
        NoOfPlayersButton[3].setBounds(10,80,80,25);
        NoOfPlayersButton[3].addActionListener(this);
        panel.add(NoOfPlayersButton[3]);

    }

    public void createPlayers() {
        players = new Player[number_of_players];
    }

    public void player_piece ()
    {
        playersPieceButton = new JButton[3];

        playersPieceButton[0] = new JButton("!");
        playersPieceButton[0].setBounds(10,80,80,25);
        playersPieceButton[0].addActionListener(this);
        panel.add(playersPieceButton[0]);

        playersPieceButton[1] = new JButton("$");
        playersPieceButton[1].setBounds(10,80,80,25);
        playersPieceButton[1].addActionListener(this);
        panel.add(playersPieceButton[1]);

        playersPieceButton[2] = new JButton("%");
        playersPieceButton[2].setBounds(10,80,80,25);
        playersPieceButton[2].addActionListener(this);
        panel.add(playersPieceButton[2]);

        playersPieceButton[3] = new JButton("?");
        playersPieceButton[3].setBounds(10,80,80,25);
        playersPieceButton[3].addActionListener(this);
        panel.add(playersPieceButton[3]);

    }

    public void player_name()
    {
        JTextField playerText = new JTextField(20);
        playerText.setBounds(10,20,80,25);
        panel.add(playerText);

        enter = new JButton("Enter");
        enter.setBounds(10,20,80,25);
        panel.add(enter);

        for (int i = 0; i < number_of_players;)
        {
            JLabel nameLabel = new JLabel("Hello player " + (i + 1) + " What is your name?: ");
            nameLabel.setBounds(10,20,80,25);
            panel.add(nameLabel);


            PlayerName = playerText.getText();
            players[i].setName(PlayerName);
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == NoOfPlayersButton[0])
        {
            number_of_players = 1;
            removeNoOfPlayersButton();
        }
        else if(e.getSource() == NoOfPlayersButton[1])
        {
            number_of_players = 2;
            removeNoOfPlayersButton();

        }
        else if(e.getSource() == NoOfPlayersButton[2])
        {
            number_of_players = 3;
            removeNoOfPlayersButton();
        }
        else if(e.getSource() == NoOfPlayersButton[3])
        {
            number_of_players = 4;
            removeNoOfPlayersButton();
        }


        if(e.getSource() == playersPieceButton[0])
        {
            panel.remove(playersPieceButton[0]);
        }
        else if(e.getSource() == playersPieceButton[1])
        {
            panel.remove(playersPieceButton[1]);
        }
        else if(e.getSource() == playersPieceButton[2])
        {
            panel.remove(playersPieceButton[2]);
        }
        else if(e.getSource() == playersPieceButton[3])
        {
            panel.remove(playersPieceButton[3]);
        }

        if(e.getSource() == enter && PlayerName != "")
        {
            i = i + 1;
        }
    }

    public void removeNoOfPlayersButton ()
    {
        panel.remove(NoOfPlayersButton[0]);
        panel.remove(NoOfPlayersButton[1]);
        panel.remove(NoOfPlayersButton[2]);
        panel.remove(NoOfPlayersButton[3]);
    }

}
