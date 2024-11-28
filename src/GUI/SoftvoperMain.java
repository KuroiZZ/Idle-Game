package GUI;

import javax.swing.*;
import java.awt.*;

import LOCSystem.LOC;

public class SoftvoperMain
{
    //public LOC loc_System = new LOC();
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
        LOCLabel = new JLabel("Number of LOC: "+LOC.loc_cnt);
        LOCLabel.setBackground(Color.white);
        LOCLabel.setFont(font1);
        CoderPanel.add(LOCLabel);

        ImageIcon coder_image = new ImageIcon(getClass().getClassLoader().getResource("images/coder_image.png"));

        JButton coder = new JButton();
        coder.setBackground(Color.black);
        coder.setFocusPainted(false);
        coder.setBorder(null);
        coder.setIcon(coder_image);
        coder.addActionListener(LOC.loc_hndler);
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
        Beginner_C.setActionCommand("Beginner_C");
        Beginner_C.addActionListener(LOC.loc_hndler);

        JButton Beginner_CSharp = new JButton("Beginner_CSharp");
        Beginner_CSharp.setActionCommand("Beginner_CSharp");
        Beginner_CSharp.addActionListener(LOC.loc_hndler);

        JButton Beginner_Dart = new JButton("Beginner_Dart");
        Beginner_Dart.setActionCommand("Beginner_Dart");
        Beginner_Dart.addActionListener(LOC.loc_hndler);

        JButton Beginner_Java = new JButton("Beginner_Java");
        Beginner_Java.setActionCommand("Beginner_Java");
        Beginner_Java.addActionListener(LOC.loc_hndler);


        JButton Intermediate_C = new JButton("Intermediate_C");
        Intermediate_C.setActionCommand("Intermediate_C");
        Intermediate_C.addActionListener(LOC.loc_hndler);

        JButton Intermediate_CSharp = new JButton("Intermediate_CSharp");
        Intermediate_CSharp.setActionCommand("Intermediate_CSharp");
        Intermediate_CSharp.addActionListener(LOC.loc_hndler);

        JButton Intermediate_Dart = new JButton("Intermediate_Dart");
        Intermediate_Dart.setActionCommand("Intermediate_Dart");
        Intermediate_Dart.addActionListener(LOC.loc_hndler);

        JButton Intermediate_Java = new JButton("Intermediate_Java");
        Intermediate_Java.setActionCommand("Intermediate_Java");
        Intermediate_Java.addActionListener(LOC.loc_hndler);



        JButton Advanced_C = new JButton("Advanced_C");
        Advanced_C.setActionCommand("Advanced_C");
        Advanced_C.addActionListener(LOC.loc_hndler);

        JButton Advanced_CSharp = new JButton("Advanced_CSharp");
        Advanced_CSharp.setActionCommand("Advanced_CSharp");
        Advanced_CSharp.addActionListener(LOC.loc_hndler);

        JButton Advanced_Dart = new JButton("Advanced_Dart");
        Advanced_Dart.setActionCommand("Advanced_Dart");
        Advanced_Dart.addActionListener(LOC.loc_hndler);

        JButton Advanced_Java = new JButton("Advanced_Java");
        Advanced_Java.setActionCommand("Advanced_Java");
        Advanced_Java.addActionListener(LOC.loc_hndler);


        StorePanel.add(Beginner_C);
        StorePanel.add(Beginner_CSharp);
        StorePanel.add(Beginner_Dart);
        StorePanel.add(Beginner_Java);
        StorePanel.add(Intermediate_C);
        StorePanel.add(Intermediate_CSharp);
        StorePanel.add(Intermediate_Dart);
        StorePanel.add(Intermediate_Java);
        StorePanel.add(Advanced_C);
        StorePanel.add(Advanced_CSharp);
        StorePanel.add(Advanced_Dart);
        StorePanel.add(Advanced_Java);

        return StorePanel;
    }
}
