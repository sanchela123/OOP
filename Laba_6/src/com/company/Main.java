package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private Game mGame = new Game(0, 21, 3);
    private JButton mButton = new JButton("Guess");
    private JTextField mTextField = new JTextField(10);

    public Main() {
        setSize(new Dimension(200, 150));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mTextField);

        mButton.addActionListener(e -> {
            guess();
        });
        mButton.setSize(100, 100);
        add(mButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void guess() {
        String text = mTextField.getText();
        if (!text.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int a = Integer.parseInt(text);
        if (a < mGame.getMinValL() || a >= mGame.getMaxVal()) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int result = mGame.guess(a);
        if (mGame.getState() == Game.GameState.LOST) {
            showMsg("Oh no, you lost!");
            System.exit(0);
        }

        if (result < 0) {
            showMsg("The hidden number is smaller.");

        } else if (result > 0) {
            showMsg("The hidden number is greater.");

        } else {
            showMsg("Wow! You won!");
            System.exit(0);
            return;
        }
    }

    private void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void main(String[] args) {
        new Main();
    }
}