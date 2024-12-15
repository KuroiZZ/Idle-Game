package Handlers;

import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.LOC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Control action to change Buy amount and reset price paramater's of employee's
 */
public class BuyAmount_Handler implements ActionListener
{
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        ImageIcon Rollovericon1 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton1.png"));
        ImageIcon Rollovericon10 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton10.png"));
        ImageIcon Rollovericon100 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/RolloverButton100.png"));

        ImageIcon icon1 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button1.png"));
        ImageIcon icon10 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button10.png"));
        ImageIcon icon100 = new ImageIcon(GUI_Elements.class.getClassLoader().getResource("images/StoreButtons/Button100.png"));

        switch (action) {
            case "1":
                LOC.buy_amount = 1;
                SoftvoperMain.ControlButtons();
                GUI_Elements.amount_1.setIcon(Rollovericon1);
                GUI_Elements.amount_10.setIcon(icon10);
                GUI_Elements.amount_100.setIcon(icon100);

                break;
            case "10":
                LOC.buy_amount = 10;
                SoftvoperMain.ControlButtons();
                GUI_Elements.amount_1.setIcon(icon1);
                GUI_Elements.amount_10.setIcon(Rollovericon10);
                GUI_Elements.amount_100.setIcon(icon100);
                break;
            case "100":
                LOC.buy_amount = 100;
                SoftvoperMain.ControlButtons();
                GUI_Elements.amount_1.setIcon(icon1);
                GUI_Elements.amount_10.setIcon(icon10);
                GUI_Elements.amount_100.setIcon(Rollovericon100);
                break;
        }

        GUI_Elements.Beginner_C_Button.setPriceText();
        GUI_Elements.Beginner_CSharp_Button.setPriceText();
        GUI_Elements.Beginner_Dart_Button.setPriceText();
        GUI_Elements.Beginner_Java_Button.setPriceText();
        GUI_Elements.Intermediate_C_Button.setPriceText();
        GUI_Elements.Intermediate_CSharp_Button.setPriceText();
        GUI_Elements.Intermediate_Dart_Button.setPriceText();
        GUI_Elements.Intermediate_Java_Button.setPriceText();
        GUI_Elements.Advanced_C_Button.setPriceText();
        GUI_Elements.Advanced_CSharp_Button.setPriceText();
        GUI_Elements.Advanced_Dart_Button.setPriceText();
        GUI_Elements.Advanced_Java_Button.setPriceText();
        GUI_Elements.Tester_Button.setPriceText();
        GUI_Elements.Architect_Button.setPriceText();
        GUI_Elements.ProjectManager_Button.setPriceText();

    }
}
