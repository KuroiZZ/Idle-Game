package Handlers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;

import javax.swing.*;

public class GUI_Handler implements ActionListener
{
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        switch (action)
        {
            case "goToApp":
                GUI_Elements.window.remove(GUI_Elements.StorePanel);
                GUI_Elements.window.add(GUI_Elements.ProjectPanel, BorderLayout.EAST);
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "goToStore":
                GUI_Elements.window.remove(GUI_Elements.ProjectPanel);
                GUI_Elements.window.add(GUI_Elements.StorePanel, BorderLayout.EAST);
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "New_Game":
                GUI_Elements.window.getContentPane().removeAll();
                SoftvoperMain.CreateSaveMenu();
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "Load_Game":
                GUI_Elements.window.getContentPane().removeAll();
                SoftvoperMain.CreateSaveMenu();
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
        }
    }


}
