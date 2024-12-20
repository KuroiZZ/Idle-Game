package GUI;

import Handlers.*;
import LOCSystem.Developers;
import LOCSystem.LOC;
import LOCSystem.Supporter;
import SCoinSystem.SCoin;
import SaveSystem.SaveSystem;
import SaveSystem.Save;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class manages and initializes the GUI elements for the game.
 */
public class GUI_Elements
{
    /**
     * Handler for general GUI events.
     */
    public static GUI_Handler GUI_handler = new GUI_Handler();

    /**
     * Handler for Buy Amount related events.
     */
    public static BuyAmount_Handler Buyamount_handler = new BuyAmount_Handler();

    /**
     * Handler for LOC related events.
     */
    public static LOC_Handler LOC_handler = new LOC_Handler();

    /**
     * Handler for SCoin related events.
     */
    public static SCoin_Handler SCoin_handler = new SCoin_Handler();

    /**
     * Handler for Supporter Checkbox events.
     */
    public static SupporterCheckbox_Handler SupporterCheckbox_handler = new SupporterCheckbox_Handler();

    /**
     * Label for displaying LOC count.
     */
    public static JLabel LOCLabel = new JLabel();

    /**
     * Label for displaying SCoin count.
     */
    public static JLabel SCoinLabel;

    /**
     * Main application window.
     */
    public static JFrame window = new JFrame();

    /**
     * Initializes the properties of the main application window.
     */
    public static void InitializeWindowProperties()
    {
        window.setSize(1920, 1080);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
    }

    /**
     * Sets up the main menu of the application.
     */
    public static void InitializeMainScreen()
    {
        MainMenuPanel MainPanel = new MainMenuPanel();
        MainPanel.setLayout(new GridBagLayout());
        JPanel  butonlarPanel = new JPanel(new GridBagLayout());
        butonlarPanel.setPreferredSize(new Dimension(960, 750));
        butonlarPanel.setOpaque(false);

        GridBagConstraints New_Game_Constraint = new GridBagConstraints();

        New_Game_Constraint.fill = GridBagConstraints.NONE;
        New_Game_Constraint.anchor = GridBagConstraints.CENTER;
        New_Game_Constraint.weightx = 0.5;
        New_Game_Constraint.weighty = 0.5;
        New_Game_Constraint.gridwidth = 1;
        New_Game_Constraint.gridheight = 1;
        New_Game_Constraint.gridx = 0;
        New_Game_Constraint.gridy = 0;

        ImageIcon NewGameIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/NewGame.png"));
        ImageIcon RolloverNewGameIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/RolloverNewGame.png"));
        JButton New_Game = new JButton(NewGameIcon);
        New_Game.setRolloverIcon(RolloverNewGameIcon);
        New_Game.addActionListener(GUI_handler);
        New_Game.setActionCommand("CreateGame_New");
        New_Game.setPreferredSize(new Dimension(500, 100));
        butonlarPanel.add(New_Game, New_Game_Constraint);

        GridBagConstraints Load_Game_Constraint = new GridBagConstraints();

        Load_Game_Constraint.fill = GridBagConstraints.NONE;
        Load_Game_Constraint.anchor = GridBagConstraints.CENTER;
        Load_Game_Constraint.weightx = 0.5;
        Load_Game_Constraint.weighty = 0.5;
        Load_Game_Constraint.gridwidth = 1;
        Load_Game_Constraint.gridheight = 1;
        Load_Game_Constraint.gridx = 0;
        Load_Game_Constraint.gridy = 1;

        ImageIcon LoadGameIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/LoadGame.png"));
        ImageIcon RolloverLoadGameIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/RolloverLoadGame.png"));
        JButton Load_Game = new JButton(LoadGameIcon);
        Load_Game.setRolloverIcon(RolloverLoadGameIcon);
        Load_Game.addActionListener(GUI_handler);
        Load_Game.setActionCommand("Load_Game");
        Load_Game.setPreferredSize(new Dimension(500, 100));
        butonlarPanel.add(Load_Game, Load_Game_Constraint);

        GridBagConstraints butonlarPanelConstraints = new GridBagConstraints();
        butonlarPanelConstraints.fill = GridBagConstraints.NONE;
        butonlarPanelConstraints.anchor = GridBagConstraints.SOUTHEAST;
        butonlarPanelConstraints.weightx = 0.5;
        butonlarPanelConstraints.weighty = 0.5;
        butonlarPanelConstraints.gridwidth = 1;
        butonlarPanelConstraints.gridheight = 1;
        butonlarPanelConstraints.gridx = 0;
        butonlarPanelConstraints.gridy = 0;

        MainPanel.add(butonlarPanel, butonlarPanelConstraints);
        window.add(MainPanel);
        GUI_Elements.window.setVisible(true);
    }

    /**
     * Sets up the game screen layout.
     */
    public static void InitializeGameScreen()
    {
        window.setLayout(new BorderLayout());
    }

    /**
     * Initializes the save screen, allowing users to view, select and delete the saved games.
     */
    public static void InitializeSaveScreen()
    {
        //window.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 100));
        ImageIcon BacktoMainMenuIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/BacktoMain.png"));
        ImageIcon RolloverBacktoMainMenuIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/RolloverBacktoMain.png"));

        JPanel backToMainMenuPanel = new JPanel(new BorderLayout());
        backToMainMenuPanel.setOpaque(false);
        JButton backToMainMenu = new JButton(BacktoMainMenuIcon);
        backToMainMenu.setRolloverIcon(RolloverBacktoMainMenuIcon);
        backToMainMenu.addActionListener(GUI_handler);
        backToMainMenu.setActionCommand("Main_Menu");
        backToMainMenu.setPreferredSize(new Dimension(100,50));
        backToMainMenuPanel.add(backToMainMenu, BorderLayout.EAST);
        window.setLayout(new BorderLayout());
        window.add(backToMainMenuPanel, BorderLayout.NORTH);

        JPanel saveListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        saveListPanel.setOpaque(true);
        saveListPanel.setBackground(Color.BLACK);
        saveListPanel.setBorder(BorderFactory.createEmptyBorder());
        ArrayList<SavePanel> SavePanels = new ArrayList<SavePanel>() ;

        String All_Save_Strings = SaveSystem.GetAllSaves();
        List<String> SaveString_List = SaveSystem.ParseJsonStringAllSaves(All_Save_Strings);
        for (String Save_String : SaveString_List)
        {
            ObjectMapper mapper = new ObjectMapper();
            Save new_save;
            try
            {
                new_save = mapper.readValue(Save_String, Save.class);
            }
            catch (JsonProcessingException e)
            {
                throw new RuntimeException(e);
            }
            SavePanels.add(new SavePanel(new_save));
        }

        for (SavePanel savePanel : SavePanels)
        {
            saveListPanel.add(savePanel);
        }
        JScrollPane scrollablePanel = new JScrollPane(saveListPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollablePanel.setOpaque(false);
        scrollablePanel.setBorder(BorderFactory.createEmptyBorder());
        scrollablePanel.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        scrollablePanel.getHorizontalScrollBar().setUnitIncrement(16);

        window.add(scrollablePanel, BorderLayout.CENTER);
    }

    /**
     * Input frame used for creating new save names.
     */
    public static JFrame InputFrame;
    /**
     * Initializes the input frame for creating new save names.
     * Action listener
     */
    public static void InitializeInputFrame()
    {
        InputFrame = new JFrame();
        InputFrame.setSize(new Dimension(300, 100));
        InputFrame.setLayout(new FlowLayout());

        JTextField input_field = new JTextField(15);
        JButton validate_button = new JButton("Create");

        validate_button.addActionListener(new ActionListener()
        {
            /**
             * This method is called when the validate_button is clicked.
             * It validates the input, saves the data, creates a new game, and transitions to the game menu.
             *
             * @param e The ActionEvent triggered by clicking the validate_button.
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (input_field.getText().length() > 1)
                {
                    GUI_Handler.save_name = input_field.getText();
                    GUI_Elements.window.setEnabled(true);

                    InputFrame.dispose();

                    GUI_Elements.window.getContentPane().removeAll();

                    ArrayList<Developers> Developers = LOC.CreateEmptyDevelopers();
                    ArrayList<Supporter> Supporters = LOC.CreateEmptySupporters();
                    SaveSystem.instant_save = new Save(GUI_Handler.save_name, Developers, Supporters, null);
                    LOC.loc_cnt = 0;
                    SCoin.SCoin_count = 0;
                    SoftvoperMain.CreateGameMenu();
                    SaveSystem.instant_save = new Save(GUI_Handler.save_name, Developers, Supporters, null);
                    try
                    {
                        SaveSystem.SendSave(SaveSystem.instant_save.CreateJSON());
                    }
                    catch (JsonProcessingException ex)
                    {
                        throw new RuntimeException(ex);
                    }

                    GUI_Elements.window.revalidate();
                    GUI_Elements.window.repaint();
                    LOC.UpdateLOC();
                }
                else
                {
                    System.out.println("A");
                }
            }
        });
        InputFrame.add(input_field);
        InputFrame.add(validate_button);
        InputFrame.setLocationRelativeTo(GUI_Elements.window);
        InputFrame.setVisible(true);
    }

    private static JLabel SCoinImage;
    private static JLabel LOCImage;
    /**
     * Creates SCoin and LOC images for display in the UI.
     */
    private void CreateScoinAndLOCImage()
    {
        ImageIcon LOCImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/LOC.png"));
        Image LOCScaledImage = LOCImageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        LOCImage = new JLabel(new ImageIcon(LOCScaledImage),SwingConstants.CENTER);

        ImageIcon SCoinImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image SCoinScaledImage = SCoinImageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        SCoinImage = new JLabel(new ImageIcon(SCoinScaledImage),SwingConstants.CENTER);
    }

    /**
     * Panel displaying coder related UI elements.
     * This is the center panel of the game.
     */
    public static JPanel CoderPanel;
    /**
     * Initializes the coder panel, including LOC and SCoin displays and buttons for saving and returning to the main menu.
     */
    public static void InitializeCoderPanel()
    {
        CoderPanel = new JPanel(new GridBagLayout());
        CoderPanel.setPreferredSize(new Dimension(920, 1080));
        CoderPanel.setBackground(Color.getHSBColor(0,0,0.10f));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;

        Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        GUI_Elements pictures = new GUI_Elements();
        pictures.CreateScoinAndLOCImage(); //ucube oldu burası

        JPanel LOCPanel = new JPanel();
        LOCPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        LOCPanel.setPreferredSize(new Dimension(910,60));
        LOCPanel.setBackground(Color.getHSBColor(0,0,0.25f));
        LOCPanel.setOpaque(true);
        String loc_count = String.format("%.02f", LOC.loc_cnt);
        LOCLabel = new JLabel(loc_count);
        LOCLabel.setForeground(Color.white);
        LOCLabel.setFont(font1);
        LOCPanel.add(LOCImage);
        LOCPanel.add(LOCLabel);
        CoderPanel.add(LOCPanel,constraints);
        constraints.anchor = GridBagConstraints.PAGE_START;

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridy = 1;

        JPanel SCoinPanel = new JPanel();
        SCoinPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        SCoinPanel.setPreferredSize(new Dimension(910,60));
        SCoinPanel.setBackground(Color.getHSBColor(0,0,0.25f));
        SCoinPanel.setOpaque(true);
        String sCoin_count = String.format("%.02f", SCoin.SCoin_count);
        SCoinLabel = new JLabel(sCoin_count);
        SCoinLabel.setForeground(Color.white);
        SCoinLabel.setFont(font1);
        SCoinPanel.add(SCoinImage);
        SCoinPanel.add(SCoinLabel);
        CoderPanel.add(SCoinPanel,constraints);

        constraints.gridy = 2;

        ImageIcon coder_image = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/PCPaintedBackground.png"));

        JButton coder = new JButton();
        coder.setFocusPainted(false);
        coder.setBackground(Color.getHSBColor(0,0,0.10f));
        coder.setBorder(BorderFactory.createEmptyBorder());
        coder.setIcon(coder_image);
        coder.addActionListener(LOC_handler);
        coder.setActionCommand("computer");
        CoderPanel.add(coder,constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridy = 3;

        JPanel ButonPanels = new JPanel(new GridLayout(1,2));

        ImageIcon save_image = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Save.png"));
        ImageIcon saveRollover_image = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/RolloverSave.png"));
        JButton Save = new JButton(save_image);
        Save.setFocusPainted(false);
        Save.setPreferredSize(new Dimension(100,50));
        Save.setRolloverIcon(saveRollover_image);
        Save.addActionListener(GUI_handler);
        Save.setActionCommand("Save");
        ButonPanels.add(Save);

        ImageIcon BacktoMainMenuIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/BacktoMain.png"));
        ImageIcon RolloverBacktoMainMenuIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/Menu/RolloverBacktoMain.png"));
        JButton MainMenu = new JButton(BacktoMainMenuIcon);
        MainMenu.setRolloverIcon(RolloverBacktoMainMenuIcon);
        MainMenu.setFocusPainted(false);
        MainMenu.setPreferredSize(new Dimension(100,50));
        MainMenu.addActionListener(GUI_handler);
        MainMenu.setActionCommand("Main_Menu");
        ButonPanels.add(MainMenu);

        CoderPanel.add(ButonPanels, constraints);
    }

    static public DeveloperButton Beginner_C_Button;
    static public DeveloperButton Beginner_CSharp_Button;
    static public DeveloperButton Beginner_Dart_Button;
    static public DeveloperButton Beginner_Java_Button;

    /**
     * Initializes all buttons for beginner-level developers by assigning commands and action listeners to each button.
     */
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
    /**
     * Initializes all buttons for intermediate-level developers by assigning commands
     * and action listeners to each button.
     */
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
    /**
     * Initializes all buttons for advanced-level developers by assigning commands
     * and action listeners to each button.
     */
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

    public static DeveloperButton Tester_Button;
    public static DeveloperButton Architect_Button;
    public static DeveloperButton ProjectManager_Button;
    /**
     * Initializes all buttons for supporter roles by assigning commands
     * and action listeners to each button.
     */
    public static void InitializeSupporter_Buttons()
    {
        Tester_Button = new DeveloperButton(LOC.Tester, "Tester");
        Tester_Button.setActionCommand("Tester");
        Tester_Button.addActionListener(LOC_handler);
        Tester_Button.addActionListener(SCoin_handler);

        Architect_Button = new DeveloperButton(LOC.Architect, "Architect");
        Architect_Button.setActionCommand("Architect");
        Architect_Button.addActionListener(LOC_handler);
        Architect_Button.addActionListener(SCoin_handler);

        ProjectManager_Button = new DeveloperButton(LOC.ProjectManager, "ProjectManager");
        ProjectManager_Button.setActionCommand("ProjectManager");
        ProjectManager_Button.addActionListener(LOC_handler);
        ProjectManager_Button.addActionListener(SCoin_handler);

    }

    public static JButton amount_1;
    public static JButton amount_10;
    public static JButton amount_100;
    public static JScrollPane StorePanel;
    /**
     * Initializes the store panel including developer buttons and other UI components.
     */
    public static void InitializeStorePanel()
    {
        JPanel StorePanel_Inside = new JPanel();
        StorePanel_Inside.setPreferredSize(new Dimension(250, 1080));
        StorePanel_Inside.setBackground(Color.getHSBColor(0,0,0.40f));
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
        amount_1 = new JButton(Rollovericon1);
        amount_1.setBorder(BorderFactory.createEmptyBorder());
        amount_1.setRolloverIcon(Rollovericon1);
        amount_1.setActionCommand("1");
        amount_1.addActionListener(Buyamount_handler);

        ImageIcon icon10 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button10.png"));
        ImageIcon Rollovericon10 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton10.png"));
        amount_10 = new JButton(icon10);
        amount_10.setBorder(BorderFactory.createEmptyBorder());
        amount_10.setRolloverIcon(Rollovericon10);
        amount_10.setActionCommand("10");
        amount_10.addActionListener(Buyamount_handler);

        ImageIcon icon100 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button100.png"));
        ImageIcon Rollovericon100 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton100.png"));
        amount_100 = new JButton(icon100);
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
        GUI_Elements.InitializeSupporter_Buttons();

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
        StorePanel_Inside.add(GUI_Elements.Tester_Button);
        StorePanel_Inside.add(GUI_Elements.Architect_Button);
        StorePanel_Inside.add(GUI_Elements.ProjectManager_Button);

        StorePanel = new JScrollPane(StorePanel_Inside);
        StorePanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        StorePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        StorePanel.getVerticalScrollBar().setUnitIncrement(6);
    }

    public static SProjectButton User_ProjectButton;
    /**
     * Initializes button for user project.
     */
    public static void InitializeUserProject()
    {
        User_ProjectButton = new SProjectButton(SCoin.User_Project);
        User_ProjectButton.setActionCommand("User_Project");
        User_ProjectButton.addActionListener(SCoin_handler);
    }

    public static SProjectButton Beginner_C_ProjectButton;
    public static SProjectButton Beginner_CSharp_ProjectButton;
    public static SProjectButton Beginner_Dart_ProjectButton;
    public static SProjectButton Beginner_Java_ProjectButton;
    /**
     * Initializes buttons for beginner-level projects.
     */
    public static void InitializeBeginnerProjects()
    {
        Beginner_C_ProjectButton = new SProjectButton(SCoin.Beginner_C_Project);
        Beginner_CSharp_ProjectButton = new SProjectButton(SCoin.Beginner_CSharp_Project);
        Beginner_Dart_ProjectButton = new SProjectButton(SCoin.Beginner_Dart_Project);
        Beginner_Java_ProjectButton = new SProjectButton(SCoin.Beginner_Java_Project);

        Beginner_C_ProjectButton.setActionCommand("Beginner_C_Project");
        Beginner_CSharp_ProjectButton.setActionCommand("Beginner_CSharp_Project");
        Beginner_Dart_ProjectButton.setActionCommand("Beginner_Dart_Project");
        Beginner_Java_ProjectButton.setActionCommand("Beginner_Java_Project");

        Beginner_C_ProjectButton.addActionListener(SCoin_handler);
        Beginner_CSharp_ProjectButton.addActionListener(SCoin_handler);
        Beginner_Dart_ProjectButton.addActionListener(SCoin_handler);
        Beginner_Java_ProjectButton.addActionListener(SCoin_handler);
    }

    public static SProjectButton Intermediate_C_ProjectButton;
    public static SProjectButton Intermediate_CSharp_ProjectButton;
    public static SProjectButton Intermediate_Dart_ProjectButton;
    public static SProjectButton Intermediate_Java_ProjectButton;
    /**
     * Initializes buttons for intermediate-level projects.
     */
    public static void InitializeIntermediateProjects()
    {
        Intermediate_C_ProjectButton = new SProjectButton(SCoin.Intermediate_C_Project);
        Intermediate_CSharp_ProjectButton = new SProjectButton(SCoin.Intermediate_CSharp_Project);
        Intermediate_Dart_ProjectButton = new SProjectButton(SCoin.Intermediate_Dart_Project);
        Intermediate_Java_ProjectButton = new SProjectButton(SCoin.Intermediate_Java_Project);

        Intermediate_C_ProjectButton.setActionCommand("Intermediate_C_Project");
        Intermediate_CSharp_ProjectButton.setActionCommand("Intermediate_CSharp_Project");
        Intermediate_Dart_ProjectButton.setActionCommand("Intermediate_Dart_Project");
        Intermediate_Java_ProjectButton.setActionCommand("Intermediate_Java_Project");

        Intermediate_C_ProjectButton.addActionListener(SCoin_handler);
        Intermediate_CSharp_ProjectButton.addActionListener(SCoin_handler);
        Intermediate_Dart_ProjectButton.addActionListener(SCoin_handler);
        Intermediate_Java_ProjectButton.addActionListener(SCoin_handler);
    }

    public static SProjectButton Advanced_C_ProjectButton;
    public static SProjectButton Advanced_CSharp_ProjectButton;
    public static SProjectButton Advanced_Dart_ProjectButton;
    public static SProjectButton Advanced_Java_ProjectButton;
    /**
     * Initializes buttons for advanced-level projects.
     */
    public static void InitializeAdvancedProjects()
    {
        Advanced_C_ProjectButton = new SProjectButton(SCoin.Advanced_C_Project);
        Advanced_CSharp_ProjectButton = new SProjectButton(SCoin.Advanced_CSharp_Project);
        Advanced_Dart_ProjectButton = new SProjectButton(SCoin.Advanced_Dart_Project);
        Advanced_Java_ProjectButton = new SProjectButton(SCoin.Advanced_Java_Project);

        Advanced_C_ProjectButton.setActionCommand("Advanced_C_Project");
        Advanced_CSharp_ProjectButton.setActionCommand("Advanced_CSharp_Project");
        Advanced_Dart_ProjectButton.setActionCommand("Advanced_Dart_Project");
        Advanced_Java_ProjectButton.setActionCommand("Advanced_Java_Project");

        Advanced_C_ProjectButton.addActionListener(SCoin_handler);
        Advanced_CSharp_ProjectButton.addActionListener(SCoin_handler);
        Advanced_Dart_ProjectButton.addActionListener(SCoin_handler);
        Advanced_Java_ProjectButton.addActionListener(SCoin_handler);
    }

    public static JButton Tester_CheckButton;
    public static JButton Architect_CheckButton;
    public static JButton ProjectManager_CheckButton;
    public static JPanel ProjectPanel;
    /**
     * Initializes the project panel including project information buttons.
     */
    public static void InitializeProjectPanel()
    {
        ProjectPanel = new JPanel();
        ProjectPanel.setPreferredSize(new Dimension(250, 1080));
        ProjectPanel.setBackground(Color.getHSBColor(0,0,0.40f));

        ImageIcon StoreButtonIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/StoreButton.png"));
        ImageIcon RolloverStoreButtonIcon = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverStoreButton.png"));

        JButton goToStorePanel = new JButton(StoreButtonIcon);
        goToStorePanel.setBorder(BorderFactory.createEmptyBorder());
        goToStorePanel.setRolloverIcon(RolloverStoreButtonIcon);
        goToStorePanel.setActionCommand("goToStore");
        goToStorePanel.addActionListener(GUI_handler);

        JPanel SupporterButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,5));
        SupporterButtonsPanel.setPreferredSize(new Dimension(250,50));
        SupporterButtonsPanel.setOpaque(false);

        ImageIcon iconTester = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ButtonTester.png"));
        ImageIcon RollovericonTester = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButtonTester.png"));
        Tester_CheckButton = new JButton(iconTester);
        Tester_CheckButton.setBorder(BorderFactory.createEmptyBorder());
        Tester_CheckButton.setRolloverIcon(RollovericonTester);
        Tester_CheckButton.setActionCommand("Tester");
        Tester_CheckButton.addActionListener(SupporterCheckbox_handler);

        ImageIcon iconArchitect = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ButtonArchitect.png"));
        ImageIcon RollovericonArchitect = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButtonArchitect.png"));
        Architect_CheckButton = new JButton(iconArchitect);
        Architect_CheckButton.setBorder(BorderFactory.createEmptyBorder());
        Architect_CheckButton.setRolloverIcon(RollovericonArchitect);
        Architect_CheckButton.setActionCommand("Architect");
        Architect_CheckButton.addActionListener(SupporterCheckbox_handler);

        ImageIcon iconProjectManager = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ButtonProjectManager.png"));
        ImageIcon RollovericonProjectManager = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButtonProjectManager.png"));
        ProjectManager_CheckButton = new JButton(iconProjectManager);
        ProjectManager_CheckButton.setBorder(BorderFactory.createEmptyBorder());
        ProjectManager_CheckButton.setRolloverIcon(RollovericonProjectManager);
        ProjectManager_CheckButton.setActionCommand("ProjectManager");
        ProjectManager_CheckButton.addActionListener(SupporterCheckbox_handler);

        SupporterButtonsPanel.add(Tester_CheckButton);
        SupporterButtonsPanel.add(Architect_CheckButton);
        SupporterButtonsPanel.add(ProjectManager_CheckButton);

        InitializeUserProject();
        InitializeBeginnerProjects();
        InitializeIntermediateProjects();
        InitializeAdvancedProjects();

        ProjectPanel.add(goToStorePanel);
        ProjectPanel.add(SupporterButtonsPanel);
        ProjectPanel.add(User_ProjectButton);
        ProjectPanel.add(Beginner_C_ProjectButton);
        ProjectPanel.add(Beginner_CSharp_ProjectButton);
        ProjectPanel.add(Beginner_Dart_ProjectButton);
        ProjectPanel.add(Beginner_Java_ProjectButton);

        ProjectPanel.add(Intermediate_C_ProjectButton);
        ProjectPanel.add(Intermediate_CSharp_ProjectButton);
        ProjectPanel.add(Intermediate_Dart_ProjectButton);
        ProjectPanel.add(Intermediate_Java_ProjectButton);

        ProjectPanel.add(Advanced_C_ProjectButton);
        ProjectPanel.add(Advanced_CSharp_ProjectButton);
        ProjectPanel.add(Advanced_Dart_ProjectButton);
        ProjectPanel.add(Advanced_Java_ProjectButton);

    }

    public static JPanel ProjectInfoPanel;
    /**
     * Initializes the project info panel to display details about selected projects.
     */
    public static void InitializeProjectInfoPanel()
    {
        ProjectInfoPanel = new JPanel();
        ProjectInfoPanel.setPreferredSize(new Dimension(250, 1080));
        ProjectInfoPanel.setBackground(Color.getHSBColor(0,0,0.60f));
    }
}

