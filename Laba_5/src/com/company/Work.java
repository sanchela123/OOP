package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Work extends JFrame {
    JTextField jta1 = new JTextField(10);
    JTextField jta2 = new JTextField(10);
    JButton button1 = new JButton("	+	");
    JButton button2 = new JButton("	- ");
    JButton button3 = new JButton("	x	");
    JButton button4 = new JButton("	/	");
    JButton button5 = new JButton("	x2 ");
    JButton button6 = new JButton("	SQR	");
    Font font = new Font("Times new roman", Font.BOLD, 100);

    Work() {
        super("Калькулятор");
        setLayout(new	FlowLayout());
        setSize(200,180);
        add(new	JLabel("Число 1"));
        add	(jta1);
        add(new JLabel("Число 2"));
        add	(jta2);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

        button1.addActionListener(new ActionListener() { public	void	actionPerformed(ActionEvent e)	{
            try{
                double	x1 = Double.parseDouble(jta1.getText().trim());
                double	x2 = Double.parseDouble(jta2.getText().trim());
                JOptionPane.showMessageDialog(null,	"Результат	=		" +(x1+x2),	"Сообщение",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch	(Exception	e1){
                JOptionPane.showMessageDialog(null,	"Ошибка в числе!\nПопробуйте еще раз!", "Внимание!",	JOptionPane.ERROR_MESSAGE);
            }
        }
        });

        button2.addActionListener(new ActionListener() { public	void	actionPerformed(ActionEvent e)	{
            try{
                double	x1 = Double.parseDouble(jta1.getText().trim());
                double	x2 = Double.parseDouble(jta2.getText().trim());
                JOptionPane.showMessageDialog(null,	"Результат	=		" +(x1-x2),	"Сообщение",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch	(Exception	e1){
                JOptionPane.showMessageDialog(null,	"Ошибка в числе!\nПопробуйте еще раз!", "Внимание!",	JOptionPane.ERROR_MESSAGE);
            }
        }
        });

        button3.addActionListener(new ActionListener() { public	void	actionPerformed(ActionEvent e)	{
            try{
                double	x1 = Double.parseDouble(jta1.getText().trim());
                double	x2 = Double.parseDouble(jta2.getText().trim());
                JOptionPane.showMessageDialog(null,	"Результат	=		" +(x1*x2),	"Сообщение",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch	(Exception	e1){
                JOptionPane.showMessageDialog(null,	"Ошибка в числе!\nПопробуйте еще раз!", "Внимание!",	JOptionPane.ERROR_MESSAGE);
            }
        }
        });

        button4.addActionListener(new ActionListener() { public	void	actionPerformed(ActionEvent e)	{
            try{
                double	x1 = Double.parseDouble(jta1.getText().trim());
                double	x2 = Double.parseDouble(jta2.getText().trim());
                JOptionPane.showMessageDialog(null,	"Результат	=		" +(x1/x2),	"Сообщение",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch	(Exception	e1){
                JOptionPane.showMessageDialog(null,	"Ошибка в числе!\nПопробуйте еще раз!", "Внимание!",	JOptionPane.ERROR_MESSAGE);
            }
        }
        });

        button5.addActionListener(new ActionListener() { public	void	actionPerformed(ActionEvent e)	{
            try{
                double	x1 = Double.parseDouble(jta1.getText().trim());
                JOptionPane.showMessageDialog(null,	"Результат	=		" +(x1*x1),	"Сообщение",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch	(Exception	e1){
                JOptionPane.showMessageDialog(null,	"Ошибка в числе!\nПопробуйте еще раз!", "Внимание!",	JOptionPane.ERROR_MESSAGE);
            }
        }
        });

        button6.addActionListener(new ActionListener() { public	void	actionPerformed(ActionEvent e)	{
            try{
                double	x1 = Double.parseDouble(jta1.getText().trim());
                JOptionPane.showMessageDialog(null,	"Результат	=		" +(Math.sqrt(x1)),	"Сообщение",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch	(Exception	e1){
                JOptionPane.showMessageDialog(null,	"Ошибка в числе!\nПопробуйте еще раз!", "Внимание!",	JOptionPane.ERROR_MESSAGE);
            }
        }
        });
        setVisible(true);
    }
}