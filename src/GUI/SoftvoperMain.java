package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LOCSystem.LOC;
import SCoinSystem.SCoin;

public class SoftvoperMain
{
    static public void CreateUI()
    {
        GUI_Elements.InitializeMainScreen();
        GUI_Elements.InitializeCoderPanel();
        GUI_Elements.InitializeStorePanel();
        GUI_Elements.InitializeAppPanel();

        GUI_Elements.window.add(GUI_Elements.CoderPanel, BorderLayout.WEST);
        GUI_Elements.window.add(GUI_Elements.StorePanel, BorderLayout.EAST);

        GUI_Elements.window.setVisible(true);

        ControlButtons();
        ControlProjects();
    }

    static public void ControlButtons()
    {
        GUI_Elements.Beginner_C.setEnabledByScoin(LOC.Beginner_C, SCoin.SCoin_count);
        GUI_Elements.Beginner_CSharp.setEnabledByScoin(LOC.Beginner_CSharp, SCoin.SCoin_count);
        GUI_Elements.Beginner_Dart.setEnabledByScoin(LOC.Beginner_Dart, SCoin.SCoin_count);
        GUI_Elements.Beginner_Java.setEnabledByScoin(LOC.Beginner_Java, SCoin.SCoin_count);
        GUI_Elements.Intermediate_C.setEnabledByScoin(LOC.Intermediate_C, SCoin.SCoin_count);
        GUI_Elements.Intermediate_CSharp.setEnabledByScoin(LOC.Intermediate_CSharp, SCoin.SCoin_count);
        GUI_Elements.Intermediate_Dart.setEnabledByScoin(LOC.Intermediate_Dart, SCoin.SCoin_count);
        GUI_Elements.Intermediate_Java.setEnabledByScoin(LOC.Intermediate_Java, SCoin.SCoin_count);
        GUI_Elements.Advanced_C.setEnabledByScoin(LOC.Advanced_C, SCoin.SCoin_count);
        GUI_Elements.Advanced_CSharp.setEnabledByScoin(LOC.Advanced_CSharp, SCoin.SCoin_count);
        GUI_Elements.Advanced_Dart.setEnabledByScoin(LOC.Advanced_Dart, SCoin.SCoin_count);
        GUI_Elements.Advanced_Java.setEnabledByScoin(LOC.Advanced_Java, SCoin.SCoin_count);

    }

    static public void ControlProjects()
    {
        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GUI_Elements.Beginner_C_Project.setEnabledByLOCandDevelopers(SCoin.Beginner_C_Project, LOC.loc_cnt, LOC.Beginner_C);
            }
        });
        timer.start();
    }
}
