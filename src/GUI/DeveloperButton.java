package GUI;

import LOCSystem.Developers;
import LOCSystem.Employee;
import LOCSystem.LOC;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a custom button component for developers in the GUI.
 * The button displays information such as the developer's name, logo, price, and other details.
 */
public class DeveloperButton extends JButton
{
    /**
     * A panel where both price and scoin logo is displayed.
     */
    private JPanel PricePanel;

    /**
     * A panel where all contents of the developer will be displayed.
     */
    private JPanel ButtonContentsPanel;

    /**
     * Image icon of the developer.
     */
    private ImageIcon LogoImage;

    /**
     * Label icon of the developer.
     */
    private JLabel Logo;

    /**
     * Number of developer that is hired and currently not working on a project.
     */
    private JLabel NofDeveloper;

    /**
     * Name of the developer.
     */
    private JLabel Name;

    /**
     * Price to hire a developer.
     */
    private JLabel Price;

    /**
     * SCoin's Image Icon.
     */
    private ImageIcon SCoinImageIcon;

    /**
     * SCoin's image.
     */
    private Image SCoinImage;

    /**
     * Label of SCoin.
     */
    private JLabel SCoin;

    /**
     * Developer object of this button.
     */
    private Developers Developer;

    /**
     * Employee object of this button.
     */
    private Employee Employee;

    /**
     * Constructs a DeveloperButton from a given developer.
     *
     * @param developer the developer object to associate with this button
     * @param name      the name to display on the button
     */
    public DeveloperButton(Developers developer,String name)
    {
        super();

        this.Employee = developer;
        this.Developer = developer;
        setButtonContentsPanel(name,setLogoImagePath(Developer.getType()));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250, 50));
        this.add(ButtonContentsPanel);
        this.setBorder(null);
        setBackgroundImage(Developer.getRank());
    }

    /**
     * Constructs a DeveloperButton from a given employee.
     *
     * @param employee the employee object to associate with this button
     * @param name     the name to display on the button
     */
    public DeveloperButton(Employee employee, String name)
    {
        super();

        this.Employee = employee;
        setButtonContentsPanel(name,setLogoImagePath(employee.getType()));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250,50));
        this.add(ButtonContentsPanel);
        this.setBorder(null);
        setBackgroundImage("Intermediate");
    }

    /**
     * Retrieves the number of developers displayed on the button.
     *
     * @return the number of developers
     */
    public int getNofDeveloperText()
    {
        return Integer.parseInt(NofDeveloper.getText());
    }

    /**
     * Updates the number of developers displayed on the button.
     */
    public void setNofDeveloperText()
    {
        NofDeveloper.setText(String.valueOf(Employee.getNofNonProjectEmp()));
    }

    /**
     * Updates the price displayed on the button with .2f format.
     */
    public void setPriceText()
    {
        String price = String.format("%.02f", Employee.getTotalPrice(LOC.buy_amount));
        Price.setText(price);
    }

    /**
     * Initializes and sets the layout and content of the button.
     *
     * @param name           the name to display
     * @param LogoImagePath  the path of the logo image
     */
    private void setButtonContentsPanel(String name,String LogoImagePath)
    {
        setButtonContents(name,LogoImagePath);//contents are initialized here

        GridBagConstraints constraintsLogo = setConstraints(GridBagConstraints.CENTER,2,0,0);
        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.LINE_START,1,1,0);
        GridBagConstraints constraintsPricePanel = setConstraints(GridBagConstraints.LINE_START,1,1,1);
        GridBagConstraints constraintsNofDeveloper = setConstraints(GridBagConstraints.CENTER,2,2,0);

        ButtonContentsPanel.add(this.Logo, constraintsLogo);
        ButtonContentsPanel.add(this.Name, constraintsName);
        ButtonContentsPanel.add(this.PricePanel, constraintsPricePanel);
        ButtonContentsPanel.add(this.NofDeveloper, constraintsNofDeveloper);
    }

    /**
     * Sets up the internal components of the button.
     *
     * @param name           the name to display
     * @param LogoImagePath  the path of the logo image
     */
    private void setButtonContents(String name,String LogoImagePath)
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


        String price = String.format("%.02f", Employee.getPrice());
        this.Price = new JLabel(price); //Initialize price
        this.Name = new JLabel(name); //Initialize name
        this.NofDeveloper = new JLabel(String.valueOf(Employee.getNofNonProjectEmp())); //Initialize number of developer

        this.Price.setFont(get_Font("SMALL"));
        this.Name.setFont(get_Font("BAŞLIK"));
        this.NofDeveloper.setFont(get_Font("BOLD"));

        this.PricePanel.add(this.SCoin);
        this.PricePanel.add(this.Price);
    }


    /**
     * Retrieves a Font object based on the given font name.
     *
     * @param fontName the name of the desired font style
     * @return the corresponding Font object
     */
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

    /**
     * Sets the background images for different button states based on the developer's rank.
     *
     * @param rank the rank of the developer (e.g., Beginner, Intermediate, Advanced)
     */
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

    /**
     * Configures layout constraints for components within the button.
     *
     * @param anchor     the anchor position
     * @param gridheight the number of rows the component occupies
     * @param gridx      the grid column index
     * @param gridy      the grid row index
     * @return the configured GridBagConstraints object
     */
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

    /**
     * Determines the logo image path based on the developer or employee type.
     *
     * @param LogoName the type of the developer or employee
     * @return the corresponding logo image path
     */
    private String setLogoImagePath(String LogoName)
    {
        String LogoImagePath;
        switch (LogoName)
        {
            case "C":
                LogoImagePath = "images/DeveloperLogo/CLogo.png";
                break;
            case "CSharp":
                LogoImagePath = "images/DeveloperLogo/CSharpLogo.png";
                break;
            case "Dart":
                LogoImagePath = "images/DeveloperLogo/DartLogo.png";
                break;
            case "Java":
                LogoImagePath = "images/DeveloperLogo/JavaLogo.png";
                break;
            case "Tester":
                LogoImagePath = "images/SupporterLogo/Tester.png";
                break;
            case "Architect":
                LogoImagePath = "images/SupporterLogo/Architect.png";
                break;
            case "ProjectManager":
                LogoImagePath = "images/SupporterLogo/PManager.png";
                break;
            default:
                LogoImagePath = "";
        }

        return LogoImagePath;
    }

    /**
     * Enables or disables the button based on the available SCoin balance.
     *
     * @param SCoin the current SCoin balance
     */
    public void setEnabledByScoin(float SCoin)
    {
        this.setEnabled(Employee.getTotalPrice(LOC.buy_amount) <= SCoin);
    }
}
