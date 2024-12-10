package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LOCSystem.LOC;
import SCoinSystem.SCoin;

public class SoftvoperMain
{
    static public void CreateMainMenu()
    {
        GUI_Elements.InitializeMainWindow();
        GUI_Elements.main_window.setVisible(true);
    }

    static public void CreateUI()
    {
        GUI_Elements.InitializeMainScreen();
        GUI_Elements.InitializeCoderPanel();
        GUI_Elements.InitializeStorePanel();
        GUI_Elements.InitializeAppPanel();
        GUI_Elements.InitializeProjectInfoPanel();

        GUI_Elements.window.add(GUI_Elements.ProjectInfoPanel, BorderLayout.WEST);
        GUI_Elements.window.add(GUI_Elements.CoderPanel, BorderLayout.CENTER);
        GUI_Elements.window.add(GUI_Elements.StorePanel, BorderLayout.EAST);

        GUI_Elements.window.setVisible(true);

        ControlButtons();
        ControlProjects();

    }

    static public void ControlButtons()
    {
        GUI_Elements.Beginner_C_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Beginner_CSharp_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Beginner_Dart_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Beginner_Java_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Intermediate_C_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Intermediate_CSharp_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Intermediate_Dart_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Intermediate_Java_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Advanced_C_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Advanced_CSharp_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Advanced_Dart_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Advanced_Java_Button.setEnabledByScoin(SCoin.SCoin_count);
    }

    static public void ControlProjects()
    {
        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GUI_Elements.Beginner_C_Project.setEnabledByLOCandDevelopers(SCoin.Beginner_C_Project, LOC.loc_cnt, LOC.Beginner_C_Developer);
            }
        });
        timer.start();
    }
}
