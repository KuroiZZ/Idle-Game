package Handlers;

import GUI.GUI_Elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for handling the actions performed on the checkbox buttons for selecting different types of supporters:
 * Tester, Architect, and Project Manager. When a user clicks on any of these options, the respective icon is updated to reflect
 * the selected or unselected state. It implements the ActionListener interface and overrides the actionPerformed method
 * to handle the checkbox toggling logic.
 */
public class SupporterCheckbox_Handler implements ActionListener
{
    /**
     * Flag indicating whether the Tester option is selected.
     */
    public static boolean is_Tester_Selected = false;

    /**
     * Flag indicating whether the Architect option is selected.
     */
    public static boolean is_Architect_Selected = false;

    /**
     * Flag indicating whether the Project Manager option is selected.
     */
    public static boolean is_ProjectManager_Selected = false;


    /**
     * This method handles the action events triggered by the checkbox buttons.
     * When a button is clicked, it toggles the selected state and updates the button icon accordingly.
     *
     * @param event The action event triggered when a checkbox is clicked.
     */
    public void actionPerformed(ActionEvent event)
    {
        ImageIcon iconTester = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button1.png"));
        ImageIcon iconArchitect = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button10.png"));
        ImageIcon iconProjectManager = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button100.png"));

        ImageIcon RollovericonTester = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton1.png"));
        ImageIcon RollovericonArchitect = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton10.png"));
        ImageIcon RollovericonProjectManager = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton100.png"));

        String action = event.getActionCommand();
        switch (action)
        {
            case "Tester":
                is_Tester_Selected = !is_Tester_Selected;
                if(is_Tester_Selected)
                {
                    GUI_Elements.Tester_CheckButton.setIcon(RollovericonTester);
                }
                else
                {
                    GUI_Elements.Tester_CheckButton.setIcon(iconTester);
                }
                break;
            case "Architect":
                is_Architect_Selected = !is_Architect_Selected;
                if(is_Architect_Selected)
                {
                    GUI_Elements.Architect_CheckButton.setIcon(RollovericonArchitect);
                }
                else
                {
                    GUI_Elements.Architect_CheckButton.setIcon(iconArchitect);
                }
                break;
            case "ProjectManager":
                is_ProjectManager_Selected = !is_ProjectManager_Selected;
                if(is_ProjectManager_Selected)
                {
                    GUI_Elements.ProjectManager_CheckButton.setIcon(RollovericonProjectManager);
                }
                else
                {
                    GUI_Elements.ProjectManager_CheckButton.setIcon(iconProjectManager);
                }
                break;
        }
    }
}
