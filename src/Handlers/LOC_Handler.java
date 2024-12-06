package Handlers;

import GUI.GUI_Elements;
import LOCSystem.LOC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOC_Handler implements ActionListener
{
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

        }
    }
}
