package Handlers;

import GUI.GUI_Elements;
import SCoinSystem.SCoin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupporterCheckbox_Handler implements ActionListener
{
    public static boolean is_Tester_Selected = false;
    public static boolean is_Architect_Selected = false;
    public static boolean is_ProjectManager_Selected = false;

    public void actionPerformed(ActionEvent event)
    {
        ImageIcon iconTester = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ButtonTester.png"));
        ImageIcon iconArchitect = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ButtonArchitect.png"));
        ImageIcon iconProjectManager = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/ButtonProjectManager.png"));

        ImageIcon RollovericonTester = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButtonTester.png"));
        ImageIcon RollovericonArchitect = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButtonArchitect.png"));
        ImageIcon RollovericonProjectManager = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButtonProjectManager.png"));

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
