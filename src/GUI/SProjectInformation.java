package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A JPanel that displays information about a specific project.
 * It includes the project's name, progress bar, SCoin to earn, and a background image that reflects the developer's rank.
 */
public class SProjectInformation extends JPanel
{
    /**
     * Label for project's name
     */
    private JLabel name;
    /**
     * Label for projects progress state
     */
    public JProgressBar appProgress;
    /**
     * Panel to hold SCoinToEarn label and SCoinImage label
     */
    private JPanel SCoinPanel;
    /**
     * Label for projects Scoin create amount
     */
    private JLabel SCoinToEarn;
    /**
     * Label for SCoin's image
     */
    private JLabel SCoinImage;
    /**
     * Image for background of information panel
     */
    private Image backgroundImage;


    /**
     * Constructor that initializes the SProjectInformation panel for a new project.
     *
     * @param ScoinToEarn
     * @param DeveloperRank
     * @param progressValue
     */
    public SProjectInformation(int ScoinToEarn, String DeveloperRank, int progressValue)
    {
        super(new GridBagLayout());
        setPanel(ScoinToEarn, progressValue);

        this.setOpaque(false);
        this.setPreferredSize(new Dimension(250, 50));
        this.setBorder(null);

        loadBackgroundImage(DeveloperRank);
    }

    /**
     * Select and set the background image based on the developer's rank.
     *
     * @param DeveloperRank
     */
    private void loadBackgroundImage(String DeveloperRank)
    {
        String BackgroundImagePath;
        switch (DeveloperRank)
        {
            case "Beginner":
                BackgroundImagePath = "images/DeveloperButton/BeginneButton.png";
                break;
            case "Intermediate":
                BackgroundImagePath = "images/DeveloperButton/IntermediateButton.png";
                break;
            case "Advanced":
                BackgroundImagePath = "images/DeveloperButton/AdvancedButton.png";
                break;
            default:
                BackgroundImagePath = "images/DeveloperButton/Karton.png";
        }
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource(BackgroundImagePath));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(250,50,Image.SCALE_SMOOTH);

        this.backgroundImage = backgroundImage;
    }

    /**
     * Paints the background with the selected image.
     *
     * @param g The Graphics object used for painting the component.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Arka plan resmini çiz
        if (backgroundImage != null)
        {
            g.drawImage(backgroundImage, 0, 0, 250, 50, this); // Resmi panelin tamamına çizer
        }
    }

    /**
     * Adds contents to the SProjectInformation panel using GridBagLayout constraints.
     *
     * @param ScoinToEarn
     * @param progressValue
     */
    private void setPanel(int ScoinToEarn, int progressValue)
    {
        setContents(ScoinToEarn, progressValue);

        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1, 0 , 0);
        GridBagConstraints constraintsSCoinToEarn = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,1,0);
        GridBagConstraints constraintsProgressBar = setConstraints(GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, 1,2,0,1);

        this.add(this.name, constraintsName);
        this.add(this.SCoinPanel, constraintsSCoinToEarn);
        this.add(this.appProgress, constraintsProgressBar);
    }

    /**
     * Sets the contents for the SProjectInformation panel, including the project's name, SCoin to earn, and progress bar.
     *
     * @param ScoinToEarn The amount of SCoin to be earned.
     * @param progressValue The current progress value of the project.
     */
    private void setContents(int ScoinToEarn, int progressValue)
    {
        this.name = new JLabel(createName());
        this.name.setFont(get_Font("SMALL"));
        this.SCoinToEarn = new JLabel(String.valueOf(ScoinToEarn));
        this.SCoinToEarn.setFont(get_Font("BAŞLIK"));

        ImageIcon LocImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image limage = LocImageIcon.getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH);
        this.SCoinImage = new JLabel(new ImageIcon(limage));

        this.appProgress = new JProgressBar(0, 100);
        appProgress.setValue(0);
        appProgress.setOrientation(JProgressBar.HORIZONTAL);

        this.SCoinPanel = new JPanel();
        this.SCoinPanel.setLayout(new BoxLayout(this.SCoinPanel, BoxLayout.LINE_AXIS));
        this.SCoinPanel.setOpaque(false);
        this.SCoinPanel.add(this.SCoinImage);
        this.SCoinPanel.add(this.SCoinToEarn);

        this.appProgress.setValue(progressValue);
    }

    public void setAppProgressValue(int value)
    {
        this.appProgress.setValue(value);
    }

    /**
     * Returns a Font object based on the provided font name.
     *
     * @param fontName The name of the font ("SMALL", "BAŞLIK", or other).
     * @return A Font object corresponding to the specified font name.
     */
    private Font get_Font(String fontName)
    {
        Font font;
        switch (fontName)
        {
            case "SMALL":
                font = new Font(Font.SERIF, Font.BOLD,  14);
                break;
            case "BAŞLIK":
                font = new Font(Font.SERIF, Font.BOLD, 18);
                break;
            default:
                font = new Font(Font.SERIF, Font.PLAIN, 15);
                break;
        }
        return font;
    }

    /**
     * Sets the constraints for components in a GridBagLayout.
     *
     * @param anchor The anchor value for component positioning.
     * @param fill The fill value for component resizing.
     * @param gridheight The grid height for the component.
     * @param gridwidth The grid width for the component.
     * @param gridx The x-coordinate in the grid.
     * @param gridy The y-coordinate in the grid.
     * @return A GridBagConstraints object with the specified properties.
     */
    private GridBagConstraints setConstraints(int anchor,int fill,  int gridheight, int gridwidth, int gridx, int gridy)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = fill;
        constraints.anchor = anchor;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.gridx = gridx;
        constraints.gridy = gridy;

        return constraints;
    }

    /**
     * Generates a random project name by combining a title and a type.
     *
     * @return A randomly generated project name.
     */
    private String createName()
    {
        List<String> TitleNames = new ArrayList<String>(Arrays.asList(
                "Whitebank ","ThinkyDink ","Giggle ","Snackademic ","Splatify ","Niyetflix ",
                "Cha-Ching ", "PUB6 ", "Kıble ", "UStube ", "Close ", "Kiwiter ", "Osman ",
                "Metin3 ", "Sugma ", "Glegro ", "Abode "));
        List<String> TypeNames = new ArrayList<String>(Arrays.asList(
                "Browser","Notebook","Calculator","C Library","AI","Game", "OS", "Message", "Music",
                "Videoplayer","App","Photo Editor"));

        int randomTitleIndex = ThreadLocalRandom.current().nextInt(TitleNames.size());
        String randomTitleElement = TitleNames.get(randomTitleIndex);

        int randomTypeIndex = ThreadLocalRandom.current().nextInt(TypeNames.size());
        String randomTypeElement = TypeNames.get(randomTypeIndex);

        String FinalName = randomTitleElement + randomTypeElement;
        return FinalName;
    }
}