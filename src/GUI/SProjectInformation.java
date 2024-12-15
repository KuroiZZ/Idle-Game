package GUI;

import javax.swing.*;
import java.awt.*;

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
     * This constructor, cosntruct SProjectInformation panel for new projects.
     * @param Name
     * @param ScoinToEarn
     * @param DeveloperRank
     * @param progressValue
     */
    public SProjectInformation(String Name, int ScoinToEarn, String DeveloperRank, int progressValue)
    {
        super(new GridBagLayout());
        setPanel(Name,ScoinToEarn, progressValue);

        this.setOpaque(false);
        this.setPreferredSize(new Dimension(250, 50));
        this.setBorder(null);

        loadBackgroundImage(DeveloperRank);
    }

    /**
     * Select and set background image by DeveloperRank
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
;
                break;
            default:
                BackgroundImagePath = "";
        }
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource(BackgroundImagePath));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(250,50,Image.SCALE_SMOOTH);

        this.backgroundImage = backgroundImage;
    }

    /**
     * Paint background with selected image.
     * @param g the <code>Graphics</code> object to protect
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
     * Add contents to SProjectInformation with constraints.
     * @param Name
     * @param ScoinToEarn
     * @param progressValue
     */
    private void setPanel(String Name, int ScoinToEarn, int progressValue)
    {
        setContents(Name,ScoinToEarn, progressValue);

        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1, 0 , 0);
        GridBagConstraints constraintsSCoinToEarn = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,1,0);
        GridBagConstraints constraintsProgressBar = setConstraints(GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, 1,2,0,1);

        this.add(this.name, constraintsName);
        this.add(this.SCoinPanel, constraintsSCoinToEarn);
        this.add(this.appProgress, constraintsProgressBar);
    }

    /**
     * Set SProjectInformation's contents.
     * @param Name
     * @param ScoinToEarn
     * @param progressValue
     */
    private void setContents(String Name, int ScoinToEarn, int progressValue)
    {
        this.name = new JLabel(Name);
        this.name.setFont(get_Font("BAŞLIK"));
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
     * Font selector for labels
     * @param fontName
     * @return
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
     * Set constraints for GridBagLayout
     * @param anchor
     * @param fill
     * @param gridheight
     * @param gridwidth
     * @param gridx
     * @param gridy
     * @return
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
}