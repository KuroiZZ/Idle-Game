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
                LOC.BuyDeveloper(LOC.Beginner_C, GUI_Elements.Beginner_C);
                break;
            case "Beginner_CSharp":
                LOC.BuyDeveloper(LOC.Beginner_CSharp, GUI_Elements.Beginner_CSharp);
                break;
            case "Beginner_Dart":
                LOC.BuyDeveloper(LOC.Beginner_Dart, GUI_Elements.Beginner_Dart);
                break;
            case "Beginner_Java":
                LOC.BuyDeveloper(LOC.Beginner_Java, GUI_Elements.Beginner_Java);
                break;
            case "Intermediate_C":
                LOC.BuyDeveloper(LOC.Intermediate_C, GUI_Elements.Intermediate_C);
                break;
            case "Intermediate_CSharp":
                LOC.BuyDeveloper(LOC.Intermediate_CSharp, GUI_Elements.Intermediate_CSharp);
                break;
            case "Intermediate_Dart":
                LOC.BuyDeveloper(LOC.Intermediate_Dart, GUI_Elements.Intermediate_Dart);
                break;
            case "Intermediate_Java":
                LOC.BuyDeveloper(LOC.Intermediate_Java, GUI_Elements.Intermediate_Java);
                break;
            case "Advanced_C":
                LOC.BuyDeveloper(LOC.Advanced_C, GUI_Elements.Advanced_C);
                break;
            case "Advanced_CSharp":
                LOC.BuyDeveloper(LOC.Advanced_CSharp, GUI_Elements.Advanced_CSharp);
                break;
            case "Advanced_Dart":
                LOC.BuyDeveloper(LOC.Advanced_Dart, GUI_Elements.Advanced_Dart);
                break;
            case "Advanced_Java":
                LOC.BuyDeveloper(LOC.Advanced_Java, GUI_Elements.Advanced_Java);
                break;

        }
    }
}
