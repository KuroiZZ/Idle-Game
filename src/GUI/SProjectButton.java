package GUI;

import Handlers.SupporterCheckbox_Handler;
import LOCSystem.Developers;
import LOCSystem.LOC;
import SCoinSystem.SProject;

import javax.swing.*;
import java.awt.*;

/**
 * SProjectButton class represents a button for a project with its relevant information.
 * This includes project LOC (Lines of Code), Developer count, and project rank.
 */
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
     *  The project associated with this button.
     */
    private SProject Project;

    /**
     * Constructor to initialize the SProjectButton for new projects.
     *
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
     * Set the contents of the button's panel.
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

        ImageIcon LocImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/LOC.png"));
        Image limage = LocImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        LOCImage = new JLabel(new ImageIcon(limage));

        ImageIcon DeveloperImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Developer.png"));
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
     * Add contents to the button's panel using GridBagLayout constraints.
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
     * Select and set the background image based on the developer's rank.
     *
     * @param rank The rank of the developer (Beginner, Intermediate, Advanced, etc.).
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
                BackgroundImagePath = "images/DeveloperButton/Karton.png";
                DisabledImagePath = "images/DeveloperButton/Karton.png";
                RolloverImagePath = "images/DeveloperButton/RolloverKarton.png";
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
     * Set the button's enabled state based on the project's LOC requirements and developer availability.
     *
     * @param project The project associated with the button.
     * @param loc_count The available LOC.
     * @param developer The developer object with available developers.
     */
    public void setEnabledByLOCandDevelopers(SProject project, float loc_count, Developers developer)
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
     * Set the button's enabled state based on the project's LOC requirements.
     *
     * @param project The project associated with the button.
     * @param loc_count The available LOC.
     */
    public void setEnabledByLOC(SProject project, float loc_count)
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
                    isTesterEnough && isArchitectEnough && isProjectManagerEnough);
        }
        else
        {
            this.setEnabled(project.getNecessaryLOC() <= loc_count);
        }
    }

    /**
     * Font selector for labels.
     *
     * @param fontName The font style to be used.
     * @return The selected font.
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
}
