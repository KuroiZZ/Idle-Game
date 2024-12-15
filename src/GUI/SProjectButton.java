package GUI;

import Handlers.SupporterCheckbox_Handler;
import LOCSystem.Developers;
import LOCSystem.LOC;
import SCoinSystem.SProject;

import javax.swing.*;
import java.awt.*;


public class SProjectButton extends JButton
{
    /**
     * Panel for button contents.
     */
    private JPanel buttonContentsPanel;
    /**
     * Panel to hold neededLOC label and LOCImage label
     */
    private JPanel neededLOCPanel;
    /**
     * Label for needed LOC to develop project
     */
    private JLabel neededLOC;
    /**
     * Label for LOC image
     */
    private JLabel LOCImage;
    /**
     * Panel to hold neededDeveloper, developerTypeRank, DeveloperImage
     */
    private JPanel neededDeveloperPanel;
    /**
     * Label for needed Developer to develop project
     */
    private JLabel neededDeveloper;
    /**
     * Label for needed Developer's type and rank to develop project
     */
    private JLabel developerTypeRank;
    /**
     * Label for Developer image
     */
    private JLabel DeveloperImage;
    /**
     *  Project to get Button's parameter
     */
    private SProject Project;

    /**
     * This constructor, construct SProjectButton for new projects.
     * @param project
     */
    public SProjectButton(SProject project)
    {
        super();
        this.Project = project;
        setbuttonContentsPanel();

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250, 50));
        this.add(buttonContentsPanel);
        this.setBorder(null);
        setBackgroundImage(this.Project.getRankType());
    }

    /**
     * Set buttonContentsPanel's contents.
     */
    private void setbuttonContents()
    {
        this.buttonContentsPanel = new JPanel(new GridBagLayout());
        this.buttonContentsPanel.setOpaque(false);

        this.neededLOCPanel = new JPanel();
        this.neededDeveloperPanel = new JPanel();
        this.neededLOCPanel.setLayout(new BoxLayout(this.neededLOCPanel, BoxLayout.LINE_AXIS));
        this.neededDeveloperPanel.setLayout(new BoxLayout(this.neededDeveloperPanel, BoxLayout.LINE_AXIS));

        this.neededLOC = new JLabel(String.valueOf(this.Project.getNecessaryLOC())); //Initialize price
        this.developerTypeRank = new JLabel(this.Project.getLanguageType()+" "+this.Project.getRankType() + " Project");
        this.neededDeveloper = new JLabel(String.valueOf(this.Project.getNecessaryDeveloperCount())); //Initialize number of developer

        ImageIcon LocImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image limage = LocImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        LOCImage = new JLabel(new ImageIcon(limage));

        ImageIcon DeveloperImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image dimage = DeveloperImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        DeveloperImage = new JLabel(new ImageIcon(dimage));

        this.neededLOC.setFont(get_Font("SMALL"));
        this.neededDeveloper.setFont(get_Font("SMALL"));
        developerTypeRank.setFont(get_Font("BAŞLIK"));

        this.neededDeveloperPanel.add(DeveloperImage);
        this.neededDeveloperPanel.add(this.neededDeveloper);
        this.neededDeveloperPanel.setOpaque(false);
        this.neededLOCPanel.add(LOCImage);
        this.neededLOCPanel.add(this.neededLOC);
        this.neededLOCPanel.setOpaque(false);
    }

    /**
     * Add contents to buttonContentsPanel with constraints.
     */
    private void setbuttonContentsPanel()
    {
        setbuttonContents();

        GridBagConstraints constraintsneededLOCPanel = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1, 0 , 1);
        GridBagConstraints constraintsDeveloperTypeRank = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,2,0,0);
        GridBagConstraints constraintsneededDeveloperPanel = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,1,1);

        buttonContentsPanel.add(this.neededLOCPanel, constraintsneededLOCPanel);
        buttonContentsPanel.add(this.developerTypeRank, constraintsDeveloperTypeRank);
        buttonContentsPanel.add(this.neededDeveloperPanel, constraintsneededDeveloperPanel);

    }

    /**
     * Select and set background image by rank
     * @param rank
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
     * Set buttons enable state with given parameters
     * @param project
     * @param loc_count
     * @param developer
     */
    public void setEnabledByLOCandDevelopers(SProject project, int loc_count, Developers developer)
    {
        boolean isTesterEnough = true;
        boolean isArchitectEnough = true;
        boolean isProjectManagerEnough = true;

        if(SupporterCheckbox_Handler.is_Tester_Selected)
        {
            isTesterEnough = LOC.Tester.getNofNonProjectEmp() > 0;
        }
        if(SupporterCheckbox_Handler.is_Architect_Selected)
        {
            isArchitectEnough = LOC.Architect.getNofNonProjectEmp() > 0;
        }
        if(SupporterCheckbox_Handler.is_ProjectManager_Selected)
        {
            isProjectManagerEnough = LOC.ProjectManager.getNofNonProjectEmp() > 0;
        }

        if(SupporterCheckbox_Handler.is_ProjectManager_Selected || SupporterCheckbox_Handler.is_Architect_Selected ||
                SupporterCheckbox_Handler.is_Tester_Selected)
        {
            this.setEnabled((project.getNecessaryLOC() <= loc_count) &&
                    (project.getNecessaryDeveloperCount() <= developer.getNofNonProjectEmp()) &&
                    isTesterEnough && isArchitectEnough && isProjectManagerEnough);
        }
        else
        {
            this.setEnabled(project.getNecessaryLOC() <= loc_count &&
                    project.getNecessaryDeveloperCount() <= developer.getNofNonProjectEmp());
        }
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
