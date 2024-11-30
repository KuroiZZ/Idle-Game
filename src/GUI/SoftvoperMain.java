package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LOCSystem.LOC;
import SCoinSystem.SCoin;

public class SoftvoperMain
{
    //public LOC loc_System = new LOC();
    public static JLabel LOCLabel;
    public static JLabel SCoinLabel;
    private static JFrame window;
    private static JPanel CoderPanel;
    private static JPanel StorePanel;
    private static JPanel AppPanel;
    private static GUIHandler GUI_hndler = new GUIHandler();


    public void CreateUI()
    {
        window = CreateMainScreen();

        CoderPanel = CreateCoderPanel();
        window.add(CoderPanel, BorderLayout.WEST);

        StorePanel = CreateStorePanel();
        window.add(StorePanel, BorderLayout.EAST);

        AppPanel = CreateAppPanel();

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

        SCoinLabel = new JLabel("Number of Coin: "+SCoin.SCoin_count);
        SCoinLabel.setBackground(Color.white);
        SCoinLabel.setFont(font1);
        CoderPanel.add(SCoinLabel);

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

        JButton goToAppPanel = new JButton("App Store");
        goToAppPanel.setActionCommand("goToApp");
        goToAppPanel.addActionListener(GUI_hndler);

        JButton amount_1 = new JButton("1");
        amount_1.setActionCommand("1");
        amount_1.addActionListener(LOC.buyamount_hndler);

        JButton amount_10 = new JButton("10");
        amount_10.setActionCommand("10");
        amount_10.addActionListener(LOC.buyamount_hndler);

        JButton amount_100 = new JButton("100");
        amount_100.setActionCommand("100");
        amount_100.addActionListener(LOC.buyamount_hndler);

        JButton Beginner_C = new JButton("Beginner_C");
        Beginner_C.setActionCommand("Beginner_C");
        Beginner_C.addActionListener(LOC.loc_hndler);
        Beginner_C.addActionListener(SCoin.SCoin_hndler);

        JButton Beginner_CSharp = new JButton("Beginner_CSharp");
        Beginner_CSharp.setActionCommand("Beginner_CSharp");
        Beginner_CSharp.addActionListener(LOC.loc_hndler);
        Beginner_CSharp.addActionListener(SCoin.SCoin_hndler);

        JButton Beginner_Dart = new JButton("Beginner_Dart");
        Beginner_Dart.setActionCommand("Beginner_Dart");
        Beginner_Dart.addActionListener(LOC.loc_hndler);
        Beginner_Dart.addActionListener(SCoin.SCoin_hndler);

        JButton Beginner_Java = new JButton("Beginner_Java");
        Beginner_Java.setActionCommand("Beginner_Java");
        Beginner_Java.addActionListener(LOC.loc_hndler);
        Beginner_Java.addActionListener(SCoin.SCoin_hndler);

        JButton Intermediate_C = new JButton("Intermediate_C");
        Intermediate_C.setActionCommand("Intermediate_C");
        Intermediate_C.addActionListener(LOC.loc_hndler);
        Intermediate_C.addActionListener(SCoin.SCoin_hndler);

        JButton Intermediate_CSharp = new JButton("Intermediate_CSharp");
        Intermediate_CSharp.setActionCommand("Intermediate_CSharp");
        Intermediate_CSharp.addActionListener(LOC.loc_hndler);
        Intermediate_CSharp.addActionListener(SCoin.SCoin_hndler);

        JButton Intermediate_Dart = new JButton("Intermediate_Dart");
        Intermediate_Dart.setActionCommand("Intermediate_Dart");
        Intermediate_Dart.addActionListener(LOC.loc_hndler);
        Intermediate_Dart.addActionListener(SCoin.SCoin_hndler);

        JButton Intermediate_Java = new JButton("Intermediate_Java");
        Intermediate_Java.setActionCommand("Intermediate_Java");
        Intermediate_Java.addActionListener(LOC.loc_hndler);
        Intermediate_Java.addActionListener(SCoin.SCoin_hndler);

        JButton Advanced_C = new JButton("Advanced_C");
        Advanced_C.setActionCommand("Advanced_C");
        Advanced_C.addActionListener(LOC.loc_hndler);
        Advanced_C.addActionListener(SCoin.SCoin_hndler);

        JButton Advanced_CSharp = new JButton("Advanced_CSharp");
        Advanced_CSharp.setActionCommand("Advanced_CSharp");
        Advanced_CSharp.addActionListener(LOC.loc_hndler);
        Advanced_CSharp.addActionListener(SCoin.SCoin_hndler);

        JButton Advanced_Dart = new JButton("Advanced_Dart");
        Advanced_Dart.setActionCommand("Advanced_Dart");
        Advanced_Dart.addActionListener(LOC.loc_hndler);
        Advanced_Dart.addActionListener(SCoin.SCoin_hndler);

        JButton Advanced_Java = new JButton("Advanced_Java");
        Advanced_Java.setActionCommand("Advanced_Java");
        Advanced_Java.addActionListener(LOC.loc_hndler);
        Advanced_Java.addActionListener(SCoin.SCoin_hndler);

        JButton Temporary_Money = new JButton("Temporary_Money");
        Temporary_Money.setActionCommand("Temporary_Money");
        Temporary_Money.addActionListener(SCoin.SCoin_hndler);

        DeveloperButton deneme = new DeveloperButton("50","Deneme","100","images/SCoin.png");


        StorePanel.add(deneme);
        StorePanel.add(goToAppPanel);
        StorePanel.add(amount_1);
        StorePanel.add(amount_10);
        StorePanel.add(amount_100);
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

        StorePanel.add(Temporary_Money);


        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean Beginner_CB = (LOC.Beginner_C.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Beginner_CSharpB = (LOC.Beginner_CSharp.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Beginner_DartB = (LOC.Beginner_Dart.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Beginner_JavaB = (LOC.Beginner_Java.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_CB = (LOC.Intermediate_C.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_CSharpB = (LOC.Intermediate_CSharp.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_DartB = (LOC.Intermediate_Dart.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_JavaB = (LOC.Intermediate_Java.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_CB = (LOC.Advanced_C.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_CSharpB = (LOC.Advanced_CSharp.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_DartB = (LOC.Advanced_Dart.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_JavaB = (LOC.Advanced_Java.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;

                Beginner_C.setEnabled(Beginner_CB);
                Beginner_CSharp.setEnabled(Beginner_CSharpB);
                Beginner_Dart.setEnabled(Beginner_DartB);
                Beginner_Java.setEnabled(Beginner_JavaB);
                Intermediate_C.setEnabled(Intermediate_CB);
                Intermediate_CSharp.setEnabled(Intermediate_CSharpB);
                Intermediate_Dart.setEnabled(Intermediate_DartB);
                Intermediate_Java.setEnabled(Intermediate_JavaB);
                Advanced_C.setEnabled(Advanced_CB);
                Advanced_CSharp.setEnabled(Advanced_CSharpB);
                Advanced_Dart.setEnabled(Advanced_DartB);
                Advanced_Java.setEnabled(Advanced_JavaB);

            }
        });
        timer.start();

        return StorePanel;
    }

    public JPanel CreateAppPanel()
    {
        JPanel AppPanel = new JPanel();
        AppPanel.setPreferredSize(new Dimension(200, 1080));
        AppPanel.setBackground(Color.blue);

        JButton goToStorePanel = new JButton("Store");
        goToStorePanel.setActionCommand("goToStore");
        goToStorePanel.addActionListener(GUI_hndler);

        AppPanel.add(goToStorePanel);

        return AppPanel;
    }

    public static class GUIHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();
            switch (action)
            {
                case "goToApp":
                    window.remove(StorePanel);
                    window.add(AppPanel, BorderLayout.EAST);
                    window.revalidate();
                    window.repaint();
                    break;
                case "goToStore":
                    window.remove(AppPanel);
                    window.add(StorePanel, BorderLayout.EAST);
                    window.revalidate();
                    window.repaint();
                    break;
            }
        }
    }
}
