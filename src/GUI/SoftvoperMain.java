package GUI;

import javax.swing.*;
import java.awt.*;
import MoneySystem.Money;

public class SoftvoperMain
{
    Money money_System = new Money();
    public static JLabel moneyLabel;

    public void CreateUI()
    {
        JFrame window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        window.setVisible(true);

        JPanel coderPanel = new JPanel();
        coderPanel.setBounds(400, 220, 200, 200);
        coderPanel.setBackground(Color.blue);
        window.add(coderPanel);

        ImageIcon coderr = new ImageIcon(getClass().getClassLoader().getResource("images/coderr.png"));

        JButton coder = new JButton();
        coder.setBackground(Color.black);
        coder.setFocusPainted(false);
        coder.setBorder(null);
        coder.setIcon(coderr);
        coder.addActionListener(money_System.money_hndler);
        coder.setActionCommand("computer");
        coderPanel.add(coder);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,100,200,100);
        counterPanel.setBackground(Color.pink);
        counterPanel.setLayout(new GridLayout(2, 1));
        window.add(counterPanel);

        Font font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
        moneyLabel = new JLabel("Money: "+money_System.money_cnt);
        moneyLabel.setBackground(Color.white);
        moneyLabel.setFont(font1);
        counterPanel.add(moneyLabel);
    }
}
