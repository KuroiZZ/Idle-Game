package GUI;

import Handlers.BuyAmount_Handler;
import Handlers.LOC_Handler;
import Handlers.GUI_Handler;
import Handlers.SCoin_Handler;
import LOCSystem.LOC;
import SCoinSystem.SCoin;

import javax.swing.*;
import java.awt.*;

public class GUI_Elements
{
    public static GUI_Handler GUI_handler = new GUI_Handler();
    public static BuyAmount_Handler Buyamount_handler = new BuyAmount_Handler();
    public static LOC_Handler LOC_handler = new LOC_Handler();
    public static SCoin_Handler SCoin_handler = new SCoin_Handler();
    public static JLabel LOCLabel;
    public static JLabel SCoinLabel;

    static public DeveloperButton Beginner_C_Button;
    static public DeveloperButton Beginner_CSharp_Button;
    static public DeveloperButton Beginner_Dart_Button;
    static public DeveloperButton Beginner_Java_Button;
    public static void InitializeBeginner_Buttons()
    {
        Beginner_C_Button = new DeveloperButton(LOC.Beginner_C_Developer, "Beginner C Developer");
        Beginner_C_Button.setActionCommand("Beginner_C");
        Beginner_C_Button.addActionListener(LOC_handler);
        Beginner_C_Button.addActionListener(SCoin_handler);

        Beginner_CSharp_Button = new DeveloperButton(LOC.Beginner_CSharp_Developer, "Beginner CSharp Developer");
        Beginner_CSharp_Button.setActionCommand("Beginner_CSharp");
        Beginner_CSharp_Button.addActionListener(LOC_handler);
        Beginner_CSharp_Button.addActionListener(SCoin_handler);

        Beginner_Dart_Button = new DeveloperButton(LOC.Beginner_Dart_Developer, "Beginner Dart Developer");
        Beginner_Dart_Button.setActionCommand("Beginner_Dart");
        Beginner_Dart_Button.addActionListener(LOC_handler);
        Beginner_Dart_Button.addActionListener(SCoin_handler);

        Beginner_Java_Button = new DeveloperButton(LOC.Beginner_Java_Developer, "Beginner Java Developer");
        Beginner_Java_Button.setActionCommand("Beginner_Java");
        Beginner_Java_Button.addActionListener(LOC_handler);
        Beginner_Java_Button.addActionListener(SCoin_handler);
    }

    static public DeveloperButton Intermediate_C_Button;
    static public DeveloperButton Intermediate_CSharp_Button;
    static public DeveloperButton Intermediate_Dart_Button;
    static public DeveloperButton Intermediate_Java_Button;
    public static void InitializeIntermediate_Buttons()
    {
        Intermediate_C_Button = new DeveloperButton(LOC.Intermediate_C_Developer, "Intermediate C Developer");
        Intermediate_C_Button.setActionCommand("Intermediate_C");
        Intermediate_C_Button.addActionListener(LOC_handler);
        Intermediate_C_Button.addActionListener(SCoin_handler);

        Intermediate_CSharp_Button = new DeveloperButton(LOC.Intermediate_CSharp_Developer, "Intermediate CSharp Developer");
        Intermediate_CSharp_Button.setActionCommand("Intermediate_CSharp");
        Intermediate_CSharp_Button.addActionListener(LOC_handler);
        Intermediate_CSharp_Button.addActionListener(SCoin_handler);

        Intermediate_Dart_Button = new DeveloperButton(LOC.Intermediate_Dart_Developer, "Intermediate Dart Developer");
        Intermediate_Dart_Button.setActionCommand("Intermediate_Dart");
        Intermediate_Dart_Button.addActionListener(LOC_handler);
        Intermediate_Dart_Button.addActionListener(SCoin_handler);

        Intermediate_Java_Button = new DeveloperButton(LOC.Intermediate_Java_Developer, "Intermediate Java Developer");
        Intermediate_Java_Button.setActionCommand("Intermediate_Java");
        Intermediate_Java_Button.addActionListener(LOC_handler);
        Intermediate_Java_Button.addActionListener(SCoin_handler);
    }

    static public DeveloperButton Advanced_C_Button;
    static public DeveloperButton Advanced_CSharp_Button;
    static public DeveloperButton Advanced_Dart_Button;
    static public DeveloperButton Advanced_Java_Button;
    public static void InitializeAdvanced_Buttons()
    {
        Advanced_C_Button = new DeveloperButton(LOC.Advanced_C_Developer,"Advanced C Developer");
        Advanced_C_Button.setActionCommand("Advanced_C");
        Advanced_C_Button.addActionListener(LOC_handler);
        Advanced_C_Button.addActionListener(SCoin_handler);

        Advanced_CSharp_Button = new DeveloperButton(LOC.Advanced_CSharp_Developer, "Advanced CSharp Developer");
        Advanced_CSharp_Button.setActionCommand("Advanced_CSharp");
        Advanced_CSharp_Button.addActionListener(LOC_handler);
        Advanced_CSharp_Button.addActionListener(SCoin_handler);

        Advanced_Dart_Button = new DeveloperButton(LOC.Advanced_Dart_Developer, "Advanced Dart Developer");
        Advanced_Dart_Button.setActionCommand("Advanced_Dart");
        Advanced_Dart_Button.addActionListener(LOC_handler);
        Advanced_Dart_Button.addActionListener(SCoin_handler);

        Advanced_Java_Button = new DeveloperButton(LOC.Advanced_Java_Developer, "Advanced Java Developer");
        Advanced_Java_Button.setActionCommand("Advanced_Java");
        Advanced_Java_Button.addActionListener(LOC_handler);
        Advanced_Java_Button.addActionListener(SCoin_handler);
    }

    public static JFrame window;
    public static void InitializeMainScreen()
    {
        window = new JFrame();
        window.setSize(1920, 1080);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(new FlowLayout());
    }

    public static JPanel CoderPanel;
    public static void InitializeCoderPanel()
    {
        CoderPanel = new JPanel();
        CoderPanel.setPreferredSize(new Dimension(920, 1080));
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

        ImageIcon coder_image = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/coder_image.png"));

        JButton coder = new JButton();
        coder.setBackground(Color.black);
        coder.setFocusPainted(false);
        coder.setBorder(null);
        coder.setIcon(coder_image);
        coder.addActionListener(LOC_handler);
        coder.setActionCommand("computer");
        CoderPanel.add(coder);

    }

    public static JScrollPane StorePanel;
    public static void InitializeStorePanel()
    {
        JPanel StorePanel_Inside = new JPanel();
        StorePanel_Inside.setPreferredSize(new Dimension(250, 1080));
        StorePanel_Inside.setBackground(Color.blue);
        StorePanel_Inside.setAutoscrolls(true);

        ImageIcon ProjectsButtonIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ProjectsButton.png"));
        ImageIcon RolloverProjectsButtonIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverProjectsButton.png"));
        JButton goToAppPanel = new JButton(ProjectsButtonIcon);
        goToAppPanel.setBorder(BorderFactory.createEmptyBorder());
        goToAppPanel.setRolloverIcon(RolloverProjectsButtonIcon);
        goToAppPanel.setActionCommand("goToApp");
        goToAppPanel.addActionListener(GUI_handler);

        JPanel AmountButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,5));
        AmountButtonsPanel.setPreferredSize(new Dimension(250,50));
        AmountButtonsPanel.setOpaque(false);

        ImageIcon icon1 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button1.png"));
        ImageIcon Rollovericon1 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton1.png"));
        JButton amount_1 = new JButton(icon1);
        amount_1.setBorder(BorderFactory.createEmptyBorder());
        amount_1.setRolloverIcon(Rollovericon1);
        amount_1.setActionCommand("1");
        amount_1.addActionListener(Buyamount_handler);

        ImageIcon icon10 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button10.png"));
        ImageIcon Rollovericon10 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton10.png"));
        JButton amount_10 = new JButton(icon10);
        amount_10.setBorder(BorderFactory.createEmptyBorder());
        amount_10.setRolloverIcon(Rollovericon10);
        amount_10.setActionCommand("10");
        amount_10.addActionListener(Buyamount_handler);

        ImageIcon icon100 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button100.png"));
        ImageIcon Rollovericon100 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton100.png"));
        JButton amount_100 = new JButton(icon100);
        amount_100.setBorder(BorderFactory.createEmptyBorder());
        amount_100.setRolloverIcon(Rollovericon100);
        amount_100.setActionCommand("100");
        amount_100.addActionListener(Buyamount_handler);

        AmountButtonsPanel.add(amount_1);
        AmountButtonsPanel.add(amount_10);
        AmountButtonsPanel.add(amount_100);

        GUI_Elements.InitializeBeginner_Buttons();
        GUI_Elements.InitializeIntermediate_Buttons();
        GUI_Elements.InitializeAdvanced_Buttons();

        JButton Temporary_Money = new JButton("Temporary_Money");
        Temporary_Money.setActionCommand("Temporary_Money");
        Temporary_Money.addActionListener(SCoin_handler);

        StorePanel_Inside.add(goToAppPanel);
        StorePanel_Inside.add(AmountButtonsPanel);
        StorePanel_Inside.add(GUI_Elements.Beginner_C_Button);
        StorePanel_Inside.add(GUI_Elements.Beginner_CSharp_Button);
        StorePanel_Inside.add(GUI_Elements.Beginner_Dart_Button);
        StorePanel_Inside.add(GUI_Elements.Beginner_Java_Button);
        StorePanel_Inside.add(GUI_Elements.Intermediate_C_Button);
        StorePanel_Inside.add(GUI_Elements.Intermediate_CSharp_Button);
        StorePanel_Inside.add(GUI_Elements.Intermediate_Dart_Button);
        StorePanel_Inside.add(GUI_Elements.Intermediate_Java_Button);
        StorePanel_Inside.add(GUI_Elements.Advanced_C_Button);
        StorePanel_Inside.add(GUI_Elements.Advanced_CSharp_Button);
        StorePanel_Inside.add(GUI_Elements.Advanced_Dart_Button);
        StorePanel_Inside.add(GUI_Elements.Advanced_Java_Button);
        StorePanel_Inside.add(Temporary_Money);

        StorePanel = new JScrollPane(StorePanel_Inside);
        StorePanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        StorePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        StorePanel.getVerticalScrollBar().setUnitIncrement(6);
    }

    public static SProjectButton Beginner_C_Project;
    public static void InitializeBeginnerProjects()
    {
        Beginner_C_Project = new SProjectButton("League of Losers", SCoin.Beginner_C_Project);
        Beginner_C_Project.setActionCommand("Beginner_C_Project");
        Beginner_C_Project.addActionListener(SCoin_handler);
    }

    public static JPanel AppPanel;
    public static void InitializeAppPanel()
    {
        AppPanel = new JPanel();
        AppPanel.setPreferredSize(new Dimension(250, 1080));
        AppPanel.setBackground(Color.blue);

        JButton goToStorePanel = new JButton("Store");
        goToStorePanel.setActionCommand("goToStore");
        goToStorePanel.addActionListener(GUI_handler);

        InitializeBeginnerProjects();

        AppPanel.add(goToStorePanel);
        AppPanel.add(Beginner_C_Project);

    }

    public static JPanel ProjectInfoPanel;
    public static void InitializeProjectInfoPanel()
    {
        ProjectInfoPanel = new JPanel();
        ProjectInfoPanel.setPreferredSize(new Dimension(250, 1080));
        ProjectInfoPanel.setBackground(Color.MAGENTA);
    }
}

