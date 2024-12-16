package GUI;

import SCoinSystem.SCoin;
import SaveSystem.Save;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SavePanel is a custom button class that represents a panel containing information about a saved game.
 * This panel displays information like the save's title, lines of code (LOC), SCoin count, and provides
 * functionality to delete or load the saved game.
 */
public class SavePanel extends JButton
{
    /**
     * Content panel to hold SavePanel button's content
     */
    private JPanel ContentPanel;
    /**
     *
     */
    private Save save;

    /**
     * Label for save's title
     */
    private JLabel Title;

    /**
     * Panel to hold LOC_Image and LOC_Count
     */
    private JPanel LOC_Panel;
    /**
     * Label for LOC_Image
     */
    private JLabel LOC_Image;
    /**
     * Label for LOC_Count
     */
    private JLabel LOC_Count;

    /**
     * Panel to hold SCoin_Image and SCoin_Count
     */
    private JPanel SCoin_Panel;
    /**
     * Label for SCoin_Image
     */
    private JLabel SCoin_Image;
    /**
     * Label for Scoin_Count
     */
    private JLabel SCoin_Count;
    /**
     * Button to delete save
     */
    private JButton Delete_Button;

    /**
     * Constructor to create a SavePanel for a saved game.
     * Initializes the panel based on the given save object.
     * @param save The Save object containing data for this saved game
     */
    public SavePanel(Save save)
    {
        this.save = save;
        setContentPanel(this.save.name, String.valueOf(this.save.loc_count_js), String.valueOf(this.save.scoin_count_js));

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(350, 810));
        this.add(ContentPanel);
        this.setBorder(null);
    }

    /**
     * Adds content to the ContentPanel with specific layout constraints.
     * This method configures the layout and arranges the UI components within the ContentPanel.
     * @param title The title of the save (project or game name)
     * @param loc_count The number of lines of code (LOC) for the save
     * @param scoin_count The number of SCoin accumulated in the save
     */
    public void setContentPanel(String title, String loc_count, String scoin_count)
    {
        setContents(title, loc_count, scoin_count);

        GridBagConstraints constraintsTitle = setConstraints(GridBagConstraints.CENTER,1,1, 0,0);
        GridBagConstraints constraintsLOC = setConstraints(GridBagConstraints.CENTER,1,1, 0, 1);
        GridBagConstraints constraintsSCoin = setConstraints(GridBagConstraints.CENTER,1,1, 0, 2);
        GridBagConstraints constraintsDeleteButton = setConstraints(GridBagConstraints.CENTER,1,1, 0, 3);

        ContentPanel.add(this.Title, constraintsTitle);
        ContentPanel.add(this.LOC_Panel, constraintsLOC);
        ContentPanel.add(this.SCoin_Panel, constraintsSCoin);
        ContentPanel.add(this.Delete_Button, constraintsDeleteButton);

        this.setActionCommand("CreateGame_Old");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                GUI_Elements.GUI_handler.setCurrentSave(save);

                GUI_Elements.GUI_handler.actionPerformed(e);
            }
        });
    }

    /**
     * Sets the contents of the SavePanel, including the title, LOC count, and SCoin count.
     * It also initializes and configures the panels and labels for these components.
     * @param title The title of the saved game
     * @param loc_count The number of lines of code (LOC)
     * @param scoin_count The number of SCoin associated with the save
     */
    public void setContents(String title, String loc_count, String scoin_count)
    {
        this.ContentPanel = new JPanel(new GridBagLayout());
        this.ContentPanel.setBackground(Color.GRAY);

        this.Title = new JLabel(title);
        this.Title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        this.LOC_Panel = new JPanel();
        this.LOC_Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.LOC_Panel.setBackground(Color.getHSBColor(0,0,0.25f));
        this.LOC_Panel.setOpaque(false);

        ImageIcon LOCImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/LOC.png"));
        Image LOCScaledImage = LOCImageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        this.LOC_Image = new JLabel(new ImageIcon(LOCScaledImage),SwingConstants.CENTER);

        this.LOC_Count = new JLabel(String.valueOf(loc_count));
        this.LOC_Count.setForeground(Color.white);
        this.LOC_Count.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        this.LOC_Panel.add(this.LOC_Image);
        this.LOC_Panel.add(this.LOC_Count);

        this.SCoin_Panel = new JPanel();
        this.SCoin_Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.SCoin_Panel.setBackground(Color.getHSBColor(0,0,0.25f));
        this.SCoin_Panel.setOpaque(false);

        ImageIcon SCoinImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image SCoinScaledImage = SCoinImageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        this.SCoin_Image = new JLabel(new ImageIcon(SCoinScaledImage),SwingConstants.CENTER);


        this.SCoin_Count = new JLabel(scoin_count);
        this.SCoin_Count.setForeground(Color.white);
        this.SCoin_Count.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        this.SCoin_Panel.add(this.SCoin_Image);
        this.SCoin_Panel.add(this.SCoin_Count);

        this.Delete_Button = new JButton("Delete Save");
        this.Delete_Button.setActionCommand("Delete");
        this.Delete_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GUI_Elements.GUI_handler.setCurrentSave(save);

                GUI_Elements.GUI_handler.actionPerformed(e);
            }
        });
    }

    /**
     * Sets the constraints for components in a GridBagLayout.
     *
     * @param anchor The anchor value for component positioning.
     * @param gridheight The grid height for the component.
     * @param gridwidth The grid width for the component.
     * @param gridx The x-coordinate in the grid.
     * @param gridy The y-coordinate in the grid.
     * @return A GridBagConstraints object with the specified properties.
     */
    private GridBagConstraints setConstraints(int anchor,  int gridheight, int gridwidth, int gridx, int gridy)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
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
