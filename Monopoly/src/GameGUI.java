import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI implements ActionListener {
    private int number_of_players;
    private Player[] players;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField input;
    private JButton button;

    public GameGUI() {
        frame = new JFrame("Animonopoly");
        panel = new JPanel();
        label = new JLabel("How many players? 2-4: ");
        input = new JTextField(10);
        button = new JButton("Start Game");
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(input);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Animonopoly");
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String numPlayers = input.getText();
        try {
            number_of_players = Integer.parseInt(numPlayers);
            if (number_of_players < 2 || number_of_players > 4) {
                JOptionPane.showMessageDialog(frame, "Please enter a number between 2 and 4.");
            } else {
                players = new Player[number_of_players];
                String[] pieces = {"!", "?", "$", "%"};
                int[] pieces_val = {1, 1, 1, 1};

                for (int i = 0; i < number_of_players; i++) {
                    String chosenName = JOptionPane.showInputDialog(frame, "Hello player " + (i + 1) + " What is your name?: ");
                    JComboBox<String> pieceSelector = new JComboBox<String>(pieces);
                    int result = JOptionPane.showConfirmDialog(frame, pieceSelector, "Please select a piece:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    int chosenPieceIndex = pieceSelector.getSelectedIndex();
                    while (chosenPieceIndex < 0 || chosenPieceIndex > 3 || pieces_val[chosenPieceIndex] == 0) {
                        JOptionPane.showMessageDialog(frame, "Please select a valid piece.");
                        result = JOptionPane.showConfirmDialog(frame, pieceSelector, "Please select a piece:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        chosenPieceIndex = pieceSelector.getSelectedIndex();
                    }
                    players[i] = new Player(pieces[chosenPieceIndex], chosenName);
                    pieces_val[chosenPieceIndex] = 0;
                }
                frame.dispose();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        GameGUI game = new GameGUI();
    }
}
