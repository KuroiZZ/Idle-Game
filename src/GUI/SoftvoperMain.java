package GUI;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

import MoneySystem.Money;

public class SoftvoperMain
{
    Money money_System = new Money();
    public static JLabel moneyLabel;

    public void CreateUI()
    {
        JFrame window = CreateMainScreen();

        JPanel CoderPanel = CreateCoderPanel();
        window.add(CoderPanel, BorderLayout.WEST);

        JPanel StorePanel = CreateStorePanel();
        window.add(StorePanel, BorderLayout.EAST);

        window.setVisible(true);
    }

    public JFrame CreateMainScreen()
    {
        JFrame window = new JFrame();
        window.setSize(960, 540);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(new BorderLayout());

        return window;
    }

    public JPanel CreateCoderPanel()
    {
        JPanel CoderPanel = new JPanel();
        CoderPanel.setPreferredSize(new Dimension(200, 1080));
        CoderPanel.setBackground(Color.green);


        Font font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
        moneyLabel = new JLabel("Money: "+money_System.money_cnt);
        moneyLabel.setBackground(Color.white);
        moneyLabel.setFont(font1);
        CoderPanel.add(moneyLabel);

        ImageIcon coder_image = new ImageIcon(getClass().getClassLoader().getResource("images/coder_image.png"));

        JButton coder = new JButton();
        coder.setBackground(Color.black);
        coder.setFocusPainted(false);
        coder.setBorder(null);
        coder.setIcon(coder_image);
        coder.addActionListener(money_System.money_hndler);
        coder.setActionCommand("computer");
        CoderPanel.add(coder);

        return CoderPanel;
    }

    public JPanel CreateStorePanel()
    {
        JPanel StorePanel = new JPanel();

        StorePanel.setPreferredSize(new Dimension(200, 1080));

        StorePanel.setBackground(Color.blue);

        return StorePanel;
    }
}
