package GUI;

import javax.swing.*;
import java.awt.*;

public class DeveloperButton extends JButton
{
    private JPanel PricePanel;
    private JPanel ButtonContentsPanel;
    private ImageIcon LogoImage;
    private JLabel Logo;
    private JLabel NofDeveloper;
    private JLabel Name;
    private JLabel Price;
    private ImageIcon SCoinImageIcon;
    private Image SCoinImage;
    private JLabel SCoin;

    public DeveloperButton(int price,String name,int nofdeveloper,String LogoImagePath,String Rank)
    {
        super();
        setButtonContentsPanel(price,name,nofdeveloper,LogoImagePath);

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250, 50));
        this.add(ButtonContentsPanel);
        this.setBorder(null);
        setBackgroundImage(Rank);
    }

    //Add contents to ButtonContentsPanel for chosen layout
    private void setButtonContentsPanel(int price,String name,int nofdeveloper,String LogoImagePath)
    {
        setButtonContents(price,name,nofdeveloper,LogoImagePath);//contents are initialized here

        GridBagConstraints constraintsLogo = setConstraints(GridBagConstraints.CENTER,2,0,0);
        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.LINE_START,1,1,0);
        GridBagConstraints constraintsPricePanel = setConstraints(GridBagConstraints.LINE_START,1,1,1);
        GridBagConstraints constraintsNofDeveloper = setConstraints(GridBagConstraints.CENTER,2,2,0);

        ButtonContentsPanel.add(this.Logo, constraintsLogo);
        ButtonContentsPanel.add(this.Name, constraintsName);
        ButtonContentsPanel.add(this.PricePanel, constraintsPricePanel);
        ButtonContentsPanel.add(this.NofDeveloper, constraintsNofDeveloper);
    }

    //Initialize every content that will be added in ButtonContentPanel
    private void setButtonContents(int price,String name,int nofdeveloper,String LogoImagePath)
    {
        this.PricePanel = new JPanel(); //Initialize panels
        this.PricePanel.setLayout(new BoxLayout(this.PricePanel, BoxLayout.LINE_AXIS));
        this.ButtonContentsPanel = new JPanel(new GridBagLayout());
        this.PricePanel.setOpaque(false);
        this.ButtonContentsPanel.setOpaque(false);

        this.LogoImage = new ImageIcon(getClass().getClassLoader().getResource(LogoImagePath));
        Image logoimage = LogoImage.getImage().getScaledInstance(30,36,Image.SCALE_SMOOTH);
        this.Logo = new JLabel(new ImageIcon(logoimage),SwingConstants.CENTER);

        this.SCoinImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        this.SCoinImage = SCoinImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        this.SCoin = new JLabel(new ImageIcon(SCoinImage),SwingConstants.CENTER); //Initialize coin image

        this.Price = new JLabel(String.valueOf(price)); //Initialize price
        this.Name = new JLabel(name); //Initialize name
        this.NofDeveloper = new JLabel(String.valueOf(nofdeveloper)); //Initialize number of developer

        this.Price.setFont(get_Font("SMALL"));
        this.Name.setFont(get_Font("BAŞLIK"));
        this.NofDeveloper.setFont(get_Font("BOLD"));

        this.PricePanel.add(this.SCoin);
        this.PricePanel.add(this.Price);
    }

    private Font get_Font(String fontName)
    {
        Font font;
        switch (fontName)
        {
            case "BOLD":
                font = new Font(Font.SERIF, Font.BOLD,  30);
                break;
            case "SMALL":
                font = new Font(Font.SERIF, Font.BOLD,  14);
                break;
            case "BAŞLIK":
                font = new Font(Font.SERIF, Font.PLAIN, 14);
                break;
            default:
                font = new Font(Font.SERIF, Font.PLAIN, 15);
                break;
        }
        return font;
    }

    private void setBackgroundImage(String rank)
    {
        String BackgroundImagePath;
        String DisabledImagePath;
        String RolloverImagePath;
        switch (rank)
        {
            case "Beginner":
                BackgroundImagePath = "images/DeveloperButton/BeginneButton.png";
                DisabledImagePath = "images/DeveloperButton/DisabledBeginnerButton.png";
                RolloverImagePath = "images/DeveloperButton/RolloverBeginnerButton.png";
                break;
            case "Intermediate":
                BackgroundImagePath = "images/DeveloperButton/IntermediateButton.png";
                DisabledImagePath = "images/DeveloperButton/DisabledIntermediateButton.png";
                RolloverImagePath = "images/DeveloperButton/RolloverIntermediateButton.png";
                break;
            case "Advanced":
                BackgroundImagePath = "images/DeveloperButton/AdvancedButton.png";
                DisabledImagePath = "images/DeveloperButton/DisabledAdvancedButton.png";
                RolloverImagePath = "images/DeveloperButton/RolloverAdvancedButton.png";
                break;
            default:
                BackgroundImagePath = "";
                DisabledImagePath = "";
                RolloverImagePath = "";
        }
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource(BackgroundImagePath));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(250,50,Image.SCALE_SMOOTH);

        ImageIcon DisabledbackgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource(DisabledImagePath));
        Image DisabledbackgroundImage = DisabledbackgroundImageIcon.getImage().getScaledInstance(250,50,Image.SCALE_SMOOTH);

        ImageIcon RolloverbackgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource(RolloverImagePath));
        Image RolloverbackgroundImage = RolloverbackgroundImageIcon.getImage().getScaledInstance(250,50,Image.SCALE_SMOOTH);

        this.setIcon(new ImageIcon(backgroundImage));
        this.setDisabledIcon(new ImageIcon(DisabledbackgroundImage));
        this.setRolloverIcon(new ImageIcon(RolloverbackgroundImage));
    }

    //sets GridBagLayout's constraints
    private GridBagConstraints setConstraints(int anchor, int gridheight, int gridx, int gridy)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = anchor;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 1;
        constraints.gridheight = gridheight;
        constraints.gridx = gridx;
        constraints.gridy = gridy;

        return constraints;
    }
}
