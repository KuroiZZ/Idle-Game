package GUI;

import javax.swing.*;
import java.awt.*;

    public class SAppInformation extends JPanel
{
    private JLabel name;
    private JProgressBar appProgress;
    private JPanel SCoinPanel;
    private JLabel SCoinToEarn;
    private JLabel SCoinImage;

    public SAppInformation(String Name, int ScoinToEarn, String DeveloperRank)
    {
        super();
        setPanel(Name,ScoinToEarn);

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250, 50));
        this.setBorder(null);
        setBackgroundImage(DeveloperRank);

    }

    private void setPanel(String Name, int ScoinToEarn)
    {
        setContents(Name,ScoinToEarn);

        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1, 1, 0 , 0);
        GridBagConstraints constraintsSCoinToEarn = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1,1,0,1);
        GridBagConstraints constraintsProgressBar = setConstraints(GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, 1,1,0,2);

        this.add(this.name, constraintsName);
        this.add(this.SCoinPanel, constraintsSCoinToEarn);
        this.add(this.appProgress, constraintsProgressBar);

    }

    private void setContents(String Name, int ScoinToEarn)
    {
        this.name = new JLabel(Name);
        this.SCoinToEarn = new JLabel(String.valueOf(ScoinToEarn));

        ImageIcon LocImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image limage = LocImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        this.SCoinImage = new JLabel(new ImageIcon(limage));

        this.appProgress = new JProgressBar(0, 100);
        appProgress.setValue(0);
        appProgress.setOrientation(JProgressBar.HORIZONTAL);

        this.SCoinPanel = new JPanel();
        this.SCoinPanel.add(this.SCoinImage);
        this.SCoinPanel.add(this.SCoinToEarn);

    }

    public void setAppProgressValue(int value)
    {
        this.appProgress.setValue(value);
    }


    private void setBackgroundImage(String rank)
    {
        String BackgroundImagePath;

        switch (rank)
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
                BackgroundImagePath = "";
        }
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource(BackgroundImagePath));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(250,50,Image.SCALE_SMOOTH);

        JLabel isim = new JLabel(new ImageIcon(backgroundImage));

        this.add(isim);
    }



    private Font get_Font(String fontName)
    {
        Font font;
        switch (fontName)
        {
            case "ITALIC":
                font = new Font(Font.SERIF, Font.ITALIC,  14);
                break;
            case "SMALL":
                font = new Font(Font.SERIF, Font.BOLD,  14);
                break;
            case "BAŞLIK":
                font = new Font(Font.SERIF, Font.BOLD, 16);
                break;
            default:
                font = new Font(Font.SERIF, Font.PLAIN, 15);
                break;
        }
        return font;
    }

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
