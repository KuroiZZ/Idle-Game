package Handlers;

import GUI.GUI_Elements;
import LOCSystem.LOC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles actions related to LOC (Lines of Code) and employee parameters.
 * It listens for action events (such as button clicks) and performs corresponding actions,
 * such as buying developers or supporters, or incrementing the LOC counter.
 */
public class LOC_Handler implements ActionListener
{
    /**
     * This method is triggered when an action event occurs.
     * It determines the action based on the action command and executes the corresponding functionality.
     * The actions include incrementing the LOC count or buying developers or supporters.
     *
     * @param event the action event that triggered this method.
     */
    public void actionPerformed(ActionEvent event)
    {
        String action = event.getActionCommand();

        switch (action)
        {
            case "computer":
                LOC.loc_cnt++;
                break;
            case "Beginner_C":
                LOC.BuyDeveloper(LOC.Beginner_C_Developer, GUI_Elements.Beginner_C_Button);
                break;
            case "Beginner_CSharp":
                LOC.BuyDeveloper(LOC.Beginner_CSharp_Developer, GUI_Elements.Beginner_CSharp_Button);
                break;
            case "Beginner_Dart":
                LOC.BuyDeveloper(LOC.Beginner_Dart_Developer, GUI_Elements.Beginner_Dart_Button);
                break;
            case "Beginner_Java":
                LOC.BuyDeveloper(LOC.Beginner_Java_Developer, GUI_Elements.Beginner_Java_Button);
                break;
            case "Intermediate_C":
                LOC.BuyDeveloper(LOC.Intermediate_C_Developer, GUI_Elements.Intermediate_C_Button);
                break;
            case "Intermediate_CSharp":
                LOC.BuyDeveloper(LOC.Intermediate_CSharp_Developer, GUI_Elements.Intermediate_CSharp_Button);
                break;
            case "Intermediate_Dart":
                LOC.BuyDeveloper(LOC.Intermediate_Dart_Developer, GUI_Elements.Intermediate_Dart_Button);
                break;
            case "Intermediate_Java":
                LOC.BuyDeveloper(LOC.Intermediate_Java_Developer, GUI_Elements.Intermediate_Java_Button);
                break;
            case "Advanced_C":
                LOC.BuyDeveloper(LOC.Advanced_C_Developer, GUI_Elements.Advanced_C_Button);
                break;
            case "Advanced_CSharp":
                LOC.BuyDeveloper(LOC.Advanced_CSharp_Developer, GUI_Elements.Advanced_CSharp_Button);
                break;
            case "Advanced_Dart":
                LOC.BuyDeveloper(LOC.Advanced_Dart_Developer, GUI_Elements.Advanced_Dart_Button);
                break;
            case "Advanced_Java":
                LOC.BuyDeveloper(LOC.Advanced_Java_Developer, GUI_Elements.Advanced_Java_Button);
                break;
            case "Tester":
                LOC.BuySupporter(LOC.Tester, GUI_Elements.Tester_Button);
                break;
            case "Architect":
                LOC.BuySupporter(LOC.Architect, GUI_Elements.Architect_Button);
                break;
            case "ProjectManager":
                LOC.BuySupporter(LOC.ProjectManager, GUI_Elements.ProjectManager_Button);
                break;

        }
    }
}
