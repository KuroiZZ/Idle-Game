package Handlers;

import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.LOC;
import SCoinSystem.SCoin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SCoin_Handler implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        String action = event.getActionCommand();
        switch (action)
        {
            case "Beginner_C":
                SCoin.BuyDeveloper(LOC.Beginner_C_Developer);
                break;
            case "Beginner_CSharp":
                SCoin.BuyDeveloper(LOC.Beginner_CSharp_Developer);
                break;
            case "Beginner_Dart":
                SCoin.BuyDeveloper(LOC.Beginner_Dart_Developer);
                break;
            case "Beginner_Java":
                SCoin.BuyDeveloper(LOC.Beginner_Java_Developer);
                break;
            case "Intermediate_C":
                SCoin.BuyDeveloper(LOC.Intermediate_C_Developer);
                break;
            case "Intermediate_CSharp":
                SCoin.BuyDeveloper(LOC.Intermediate_CSharp_Developer);
                break;
            case "Intermediate_Dart":
                SCoin.BuyDeveloper(LOC.Intermediate_Dart_Developer);
                break;
            case "Intermediate_Java":
                SCoin.BuyDeveloper(LOC.Intermediate_Java_Developer);
                break;
            case "Advanced_C":
                SCoin.BuyDeveloper(LOC.Advanced_C_Developer);
                break;
            case "Advanced_CSharp":
                SCoin.BuyDeveloper(LOC.Advanced_CSharp_Developer);
                break;
            case "Advanced_Dart":
                SCoin.BuyDeveloper(LOC.Advanced_Dart_Developer);
                break;
            case "Advanced_Java":
                SCoin.BuyDeveloper(LOC.Advanced_Java_Developer);
                break;
            case "Temporary_Money":
                SCoin.SCoin_count += 10;
                GUI_Elements.SCoinLabel.setText("Number of Coin: "+ SCoin.SCoin_count);
                SoftvoperMain.ControlButtons();
                break;
            case "Beginner_C_Project":
                SCoin.DevelopApp(LOC.Beginner_C_Developer, GUI_Elements.Beginner_C_Button, SCoin.Beginner_C_Project);
                break;
        }
    }
}
