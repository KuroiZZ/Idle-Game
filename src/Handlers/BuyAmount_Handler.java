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

        GUI_Elements.Beginner_C.setPriceText(LOC.Beginner_C_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Beginner_CSharp.setPriceText(LOC.Beginner_CSharp_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Beginner_Dart.setPriceText(LOC.Beginner_Dart_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Beginner_Java.setPriceText(LOC.Beginner_Java_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_C.setPriceText(LOC.Intermediate_C_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_CSharp.setPriceText(LOC.Intermediate_CSharp_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_Dart.setPriceText(LOC.Intermediate_Dart_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Intermediate_Java.setPriceText(LOC.Intermediate_Java_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_C.setPriceText(LOC.Advanced_C_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_CSharp.setPriceText(LOC.Advanced_CSharp_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_Dart.setPriceText(LOC.Advanced_Dart_Developer.getTotalPrice(LOC.buy_amount));
        GUI_Elements.Advanced_Java.setPriceText(LOC.Advanced_Java_Developer.getTotalPrice(LOC.buy_amount));


    }
}
