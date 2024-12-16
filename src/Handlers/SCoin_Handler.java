package Handlers;

import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.LOC;
import SCoinSystem.SCoin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Controls actions to change SCoin and Employee's parameters
 */
public class SCoin_Handler implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        String action = event.getActionCommand();
        switch (action)
        {
            case "Beginner_C":
                SCoin.BuyEmployee(LOC.Beginner_C_Developer);
                break;
            case "Beginner_CSharp":
                SCoin.BuyEmployee(LOC.Beginner_CSharp_Developer);
                break;
            case "Beginner_Dart":
                SCoin.BuyEmployee(LOC.Beginner_Dart_Developer);
                break;
            case "Beginner_Java":
                SCoin.BuyEmployee(LOC.Beginner_Java_Developer);
                break;
            case "Intermediate_C":
                SCoin.BuyEmployee(LOC.Intermediate_C_Developer);
                break;
            case "Intermediate_CSharp":
                SCoin.BuyEmployee(LOC.Intermediate_CSharp_Developer);
                break;
            case "Intermediate_Dart":
                SCoin.BuyEmployee(LOC.Intermediate_Dart_Developer);
                break;
            case "Intermediate_Java":
                SCoin.BuyEmployee(LOC.Intermediate_Java_Developer);
                break;
            case "Advanced_C":
                SCoin.BuyEmployee(LOC.Advanced_C_Developer);
                break;
            case "Advanced_CSharp":
                SCoin.BuyEmployee(LOC.Advanced_CSharp_Developer);
                break;
            case "Advanced_Dart":
                SCoin.BuyEmployee(LOC.Advanced_Dart_Developer);
                break;
            case "Advanced_Java":
                SCoin.BuyEmployee(LOC.Advanced_Java_Developer);
                break;
            case "Tester":
                SCoin.BuyEmployee(LOC.Tester);
                break;
            case "Architect":
                SCoin.BuyEmployee(LOC.Architect);
                break;
            case "ProjectManager":
                SCoin.BuyEmployee(LOC.ProjectManager);
                break;
            case "Temporary_Money":
                SCoin.SCoin_count += 10;
                GUI_Elements.SCoinLabel.setText(String.valueOf(SCoin.SCoin_count));
                SoftvoperMain.ControlButtons();
                break;
            case "User_Project":
                SCoin.DevelopUserProject(SCoin.User_Project);
                break;
            case "Beginner_C_Project":
                SCoin.DevelopApp(LOC.Beginner_C_Developer, GUI_Elements.Beginner_C_Button, SCoin.Beginner_C_Project);
                break;
            case "Beginner_CSharp_Project":
                SCoin.DevelopApp(LOC.Beginner_CSharp_Developer, GUI_Elements.Beginner_CSharp_Button, SCoin.Beginner_CSharp_Project);
                break;
            case "Beginner_Dart_Project":
                SCoin.DevelopApp(LOC.Beginner_Dart_Developer, GUI_Elements.Beginner_Dart_Button, SCoin.Beginner_Dart_Project);
                break;
            case "Beginner_Java_Project":
                SCoin.DevelopApp(LOC.Beginner_Java_Developer, GUI_Elements.Beginner_Java_Button, SCoin.Beginner_Java_Project);
                break;
            case "Intermediate_C_Project":
                SCoin.DevelopApp(LOC.Intermediate_C_Developer, GUI_Elements.Intermediate_C_Button, SCoin.Intermediate_C_Project);
                break;
            case "Intermediate_CSharp_Project":
                SCoin.DevelopApp(LOC.Intermediate_CSharp_Developer, GUI_Elements.Intermediate_CSharp_Button, SCoin.Intermediate_CSharp_Project);
                break;
            case "Intermediate_Dart_Project":
                SCoin.DevelopApp(LOC.Intermediate_Dart_Developer, GUI_Elements.Intermediate_Dart_Button, SCoin.Intermediate_Dart_Project);
                break;
            case "Intermediate_Java_Project":
                SCoin.DevelopApp(LOC.Intermediate_Java_Developer, GUI_Elements.Intermediate_Java_Button, SCoin.Intermediate_Java_Project);
                break;
            case "Advanced_C_Project":
                SCoin.DevelopApp(LOC.Advanced_C_Developer, GUI_Elements.Advanced_C_Button, SCoin.Advanced_C_Project);
                break;
            case "Advanced_CSharp_Project":
                SCoin.DevelopApp(LOC.Advanced_CSharp_Developer, GUI_Elements.Advanced_CSharp_Button, SCoin.Advanced_CSharp_Project);
                break;
            case "Advanced_Dart_Project":
                SCoin.DevelopApp(LOC.Advanced_Dart_Developer, GUI_Elements.Advanced_Dart_Button, SCoin.Advanced_Dart_Project);
                break;
            case "Advanced_Java_Project":
                SCoin.DevelopApp(LOC.Advanced_Java_Developer, GUI_Elements.Advanced_Java_Button, SCoin.Advanced_Java_Project);
                break;
        }
    }
}
