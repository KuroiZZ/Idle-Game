package Handlers;

import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.LOC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyAmount_Handler implements ActionListener
{
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();

        switch (action) {
            case "1":
                LOC.buy_amount = 1;
                SoftvoperMain.ControlButtons();

                break;
            case "10":
                LOC.buy_amount = 10;
                SoftvoperMain.ControlButtons();
                break;
            case "100":
                LOC.buy_amount = 100;
                SoftvoperMain.ControlButtons();
                break;
        }

        GUI_Elements.Beginner_C_Button.setPriceText(LOC.Beginner_C_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Beginner_CSharp_Button.setPriceText(LOC.Beginner_CSharp_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Beginner_Dart_Button.setPriceText(LOC.Beginner_Dart_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Beginner_Java_Button.setPriceText(LOC.Beginner_Java_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_C_Button.setPriceText(LOC.Intermediate_C_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_CSharp_Button.setPriceText(LOC.Intermediate_CSharp_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_Dart_Button.setPriceText(LOC.Intermediate_Dart_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_Java_Button.setPriceText(LOC.Intermediate_Java_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_C_Button.setPriceText(LOC.Advanced_C_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_CSharp_Button.setPriceText(LOC.Advanced_CSharp_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_Dart_Button.setPriceText(LOC.Advanced_Dart_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_Java_Button.setPriceText(LOC.Advanced_Java_Developer.getTotalPrice(LOC.buy_amount));


    }
}
