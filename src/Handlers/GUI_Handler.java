package Handlers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;

public class GUI_Handler implements ActionListener
{
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        switch (action) {
            case "goToApp":
                GUI_Elements.window.remove(GUI_Elements.StorePanel);
                GUI_Elements.window.add(GUI_Elements.AppPanel, BorderLayout.EAST);
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "goToStore":
                GUI_Elements.window.remove(GUI_Elements.AppPanel);
                GUI_Elements.window.add(GUI_Elements.StorePanel, BorderLayout.EAST);
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "goToGame":
                SoftvoperMain.CreateUI();
                GUI_Elements.main_window.setVisible(false);

        }
    }


}
