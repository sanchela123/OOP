package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabExample extends JFrame {
    private int WinWidth = 400, WinHeight = 200;
    private int WinXPos = 100, WinYPos = 100;
    private int ACMil = 0;
    private int RMad = 0;
    private String LastS = "N/A", winner = "Draw";
    JButton ACM = new JButton("AC Milan");
    JButton RM = new JButton("Real Madrid");
    JLabel score = new JLabel("Result: " + ACMil + " X " + RMad);
    JLabel LastScore = new JLabel("Last Scorer: " + LastS);
    Label win = new Label("Winner: " + winner);
    Font font = new Font("Times New Roman", 0, 18);

    public LabExample() {
        super("Football");
        setLayout(null);
        this.setBounds(WinXPos, WinYPos, WinWidth, WinHeight);

        ACM.setBounds(15, 10, 120, 30);
        add(ACM);

        RM.setBounds( 15, 90, 120, 30);
        add(RM);

        score.setBounds(150, 10, 100, 30);
        score.setFont(font);
        add(score);

        LastScore.setBounds( 150, 50, 200, 30);
        LastScore.setFont(font);
        add(LastScore);

        win.setBounds(150, 95, 180, 30);
        win.setFont(font);
        add(win);

        RM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RMad = RMad + 1;
                score.setText("Result: " + ACMil + " X " + RMad);
                LastS = "Real Madrid";
                LastScore.setText("Last Scorer: " + LastS);
                if (ACMil < RMad) {
                    winner = "Real Madrid";
                    win.setText("Winner: " + winner);
                }
                else if (ACMil == RMad) {
                    winner = "Draw";
                    win.setText("Winner: " + winner);
                }
            }
        });

        ACM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACMil = ACMil + 1;
                score.setText("Result: " + ACMil + " X " + RMad);
                LastS = "AC Milan";
                LastScore.setText("Last Scorer: " + LastS);
                if (ACMil > RMad) {
                    winner = "AC Milan";
                    win.setText("Winner: " + winner);
                }
                else if (ACMil == RMad) {
                    winner = "Draw";
                    win.setText("Winner: " + winner);
                }
            }
        });

    }

}
