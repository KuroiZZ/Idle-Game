package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextHitInfo;
import java.util.Timer;

public class SAppButton extends JButton
{
    private JPanel buttonContentsPanel;
    private JLabel name;
    private JLabel neededLOC;
    private JLabel neededDeveloper;
    private JLabel developerTypeRank;
    private JProgressBar appProgress;
    private JPanel neededLOCPanel;
    private JPanel neededDeveloperPanel;
    private JLabel LOCImage;
    private JLabel DeveloperImage;

    public SAppButton(String Name, int NeededLOC,String DeveloperType, String DeveloperRank, int NeededDeveloper , int DurationTime)
    {
        super();
        setbuttonContentsPanel(Name,NeededLOC,DeveloperType, DeveloperRank, NeededDeveloper, DurationTime);

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250, 50));
        this.add(buttonContentsPanel);
        this.setBorder(null);
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

    private void setbuttonContents(String Name, int NeededLOC,String DeveloperType, String DeveloperRank, int NeededDeveloper , int DurationTime)
    {
        this.buttonContentsPanel = new JPanel(new GridBagLayout());
        this.buttonContentsPanel.setOpaque(false);

        this.neededLOCPanel = new JPanel();
        this.neededDeveloperPanel = new JPanel();
        this.neededLOCPanel.setLayout(new BoxLayout(this.neededLOCPanel, BoxLayout.LINE_AXIS));
        this.neededDeveloperPanel.setLayout(new BoxLayout(this.neededDeveloperPanel, BoxLayout.LINE_AXIS));

        this.name = new JLabel(Name);
        this.neededLOC = new JLabel(String.valueOf(NeededLOC)); //Initialize price
        this.developerTypeRank = new JLabel(DeveloperType+" "+DeveloperRank);
        this.neededDeveloper = new JLabel(String.valueOf(NeededDeveloper)); //Initialize number of developer

        ImageIcon LocImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image limage = LocImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        LOCImage = new JLabel(new ImageIcon(limage));

        ImageIcon DeveloperImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image dimage = DeveloperImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        DeveloperImage = new JLabel(new ImageIcon(dimage));

        this.appProgress = new JProgressBar(0, 100);
        appProgress.setValue(0);
        appProgress.setOrientation(JProgressBar.HORIZONTAL);

        this.name.setFont(get_Font("BAŞLIK"));
        this.neededLOC.setFont(get_Font("SMALL"));
        this.neededDeveloper.setFont(get_Font("SMALL"));
        developerTypeRank.setFont(get_Font("ITALIC"));

        this.neededDeveloperPanel.add(DeveloperImage);
        this.neededDeveloperPanel.add(this.neededDeveloper);
        this.neededLOCPanel.add(LOCImage);
        this.neededLOCPanel.add(this.neededLOC);
    }

    private void setbuttonContentsPanel(String Name, int NeededLOC,String DeveloperType, String DeveloperRank, int NeededDeveloper , int DurationTime)
    {
        setbuttonContents(Name,NeededLOC,DeveloperType, DeveloperRank, NeededDeveloper, DurationTime);

        GridBagConstraints constraintsname = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,0, 0);
        GridBagConstraints constraintsneededLOCPanel = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1, 0 , 1);
        GridBagConstraints constraintsDeveloperTypeRank = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,1,0);
        GridBagConstraints constraintsneededDeveloperPanel = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,1,1);
        GridBagConstraints constraintsProgressBar = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1,2,0,2);

        buttonContentsPanel.add(this.name, constraintsname);
        buttonContentsPanel.add(this.neededLOCPanel, constraintsneededLOCPanel);
        buttonContentsPanel.add(this.developerTypeRank, constraintsDeveloperTypeRank);
        buttonContentsPanel.add(this.neededDeveloperPanel, constraintsneededDeveloperPanel);
        //buttonContentsPanel.add(this.appProgress, constraintsProgressBar);
    }

    public void setAppProgressValue(int value)
    {
        this.appProgress.setValue(value);
    }
}
