package GUI;

import javax.swing.*;
import java.awt.*;

import LOCSystem.LOC;

public class SoftvoperMain
{
    public LOC loc_System = new LOC();
    public static JLabel LOCLabel;

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
        CoderPanel.setPreferredSize(new Dimension(400, 1080));
        CoderPanel.setBackground(Color.green);


        Font font1 = new Font("Comic Sans MS", Font.PLAIN, 22);
        LOCLabel = new JLabel("Number of LOC: "+loc_System.loc_cnt);
        LOCLabel.setBackground(Color.white);
        LOCLabel.setFont(font1);
        CoderPanel.add(LOCLabel);

        ImageIcon coder_image = new ImageIcon(getClass().getClassLoader().getResource("images/coder_image.png"));

        JButton coder = new JButton();
        coder.setBackground(Color.black);
        coder.setFocusPainted(false);
        coder.setBorder(null);
        coder.setIcon(coder_image);
        coder.addActionListener(loc_System.loc_hndler);
        coder.setActionCommand("computer");
        CoderPanel.add(coder);

        return CoderPanel;
    }

    public JPanel CreateStorePanel()
    {
        JPanel StorePanel = new JPanel();
        StorePanel.setPreferredSize(new Dimension(200, 1080));
        StorePanel.setBackground(Color.blue);

        JButton Beginner_C = new JButton("Beginner_C");
        Beginner_C.setActionCommand("C_Beginner");
        Beginner_C.addActionListener(loc_System.loc_hndler);

        JButton Beginner_CSharp = new JButton("Beginner_CSharp");
        Beginner_CSharp.setActionCommand("Beginner_CSharp");
        Beginner_CSharp.addActionListener(loc_System.loc_hndler);

        JButton Beginner_Dart = new JButton("Beginner_Dart");
        Beginner_Dart.setActionCommand("Beginner_Dart");
        Beginner_Dart.addActionListener(loc_System.loc_hndler);

        JButton Beginner_Java = new JButton("Beginner_Java");
        Beginner_Java.setActionCommand("Beginner_Java");
        Beginner_Java.addActionListener(loc_System.loc_hndler);


        StorePanel.add(Beginner_C);
        StorePanel.add(Beginner_CSharp);
        StorePanel.add(Beginner_Dart);
        StorePanel.add(Beginner_Java);




        return StorePanel;
    }
}
