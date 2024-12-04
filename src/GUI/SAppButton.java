package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextHitInfo;

public class SAppButton extends JButton
{
    private JPanel buttonContentsPanel;
    private JLabel name;
    private JLabel neededLOC;
    private JLabel neededDeveloper;
    private JLabel developerType;
    private JLabel developerRank;
    private JLabel durationLabel;
    private JPanel durationPanel;
    private JPanel checkPanel;
    private JPanel developerPanel;
    private JCheckBox testerCheck;
    private JCheckBox architectureCheck;
    private JCheckBox managerCheck;

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

        this.checkPanel = new JPanel(new GridLayout(1,3));
        this.durationPanel = new JPanel();
        this.developerPanel = new JPanel(new GridLayout(1, 3));


        this.name = new JLabel(Name);
        this.neededLOC = new JLabel("LOC Amount: " + String.valueOf(NeededLOC)); //Initialize price
        this.developerType = new JLabel("Type: " + DeveloperType);
        this.developerRank = new JLabel("Rank: " + DeveloperRank);
        this.neededDeveloper = new JLabel("Amount: " + String.valueOf(NeededDeveloper)); //Initialize number of developer
        this.testerCheck = new JCheckBox();
        this.architectureCheck = new JCheckBox();
        this.managerCheck = new JCheckBox();
        this.durationLabel = new JLabel(String.valueOf(DurationTime));

        this.developerPanel.add(this.developerType);
        this.developerPanel.add(this.developerRank);
        this.developerPanel.add(this.neededDeveloper);
        this.checkPanel.add(testerCheck);
        this.checkPanel.add(architectureCheck);
        this.checkPanel.add(managerCheck);
        this.durationPanel.add(durationLabel, CENTER);

        this.name.setFont(get_Font("SMALL"));
        this.neededLOC.setFont(get_Font("SMALL"));
        this.neededDeveloper.setFont(get_Font("SMALL"));

        this.name.setBackground(Color.CYAN);
        this.neededLOC.setBackground(Color.RED);
        this.developerPanel.setBackground(Color.GREEN);
        this.checkPanel.setBackground(Color.YELLOW);
        this.durationPanel.setBackground(Color.YELLOW);

        this.name.setOpaque(true);
        this.neededLOC.setOpaque(true);
        this.developerPanel.setOpaque(true);
        this.checkPanel.setOpaque(true);
        this.durationPanel.setOpaque(true);

    }

    private void setbuttonContentsPanel(String Name, int NeededLOC,String DeveloperType, String DeveloperRank, int NeededDeveloper , int DurationTime)
    {
        setbuttonContents(Name,NeededLOC,DeveloperType, DeveloperRank, NeededDeveloper, DurationTime);

        GridBagConstraints constraintsname = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,0, 0);
        GridBagConstraints constraintsneededLOC = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1, 0 , 1);
        GridBagConstraints constraintsDeveloperPanel = setConstraints(GridBagConstraints.LINE_START, GridBagConstraints.BOTH,1, 1, 0,2);
        GridBagConstraints constraintcheckPanel = setConstraints(GridBagConstraints.LINE_START, GridBagConstraints.BOTH, 1, 1, 0, 3);
        GridBagConstraints constraintsdurationPanel = setConstraints(GridBagConstraints.LINE_START,GridBagConstraints.BOTH , 1, 1, 0, 4);


        buttonContentsPanel.add(this.name, constraintsname);
        buttonContentsPanel.add(this.neededLOC, constraintsneededLOC);
        buttonContentsPanel.add(this.developerPanel, constraintsDeveloperPanel);
        buttonContentsPanel.add(this.checkPanel, constraintcheckPanel);
        buttonContentsPanel.add(this.durationPanel, constraintsdurationPanel);
    }

    public SAppButton(String Name, int NeededLOC,String DeveloperType, String DeveloperRank, int NeededDeveloper , int DurationTime)
    {
        super();
        setbuttonContentsPanel(Name,NeededLOC,DeveloperType, DeveloperRank, NeededDeveloper, DurationTime);

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(400, 100));
        this.add(buttonContentsPanel);
        this.setBorder(null);
    }
}
