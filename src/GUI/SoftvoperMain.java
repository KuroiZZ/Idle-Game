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
        GUI_Elements.InitializeMainScreen();
    }

    static public void CreateGameMenu()
    {
        GUI_Elements.InitializeGameScreen();
        GUI_Elements.InitializeCoderPanel();
        GUI_Elements.InitializeStorePanel();
        GUI_Elements.InitializeProjectPanel();
        GUI_Elements.InitializeProjectInfoPanel();

        GUI_Elements.window.add(GUI_Elements.ProjectInfoPanel, BorderLayout.WEST);
        GUI_Elements.window.add(GUI_Elements.CoderPanel, BorderLayout.CENTER);
        GUI_Elements.window.add(GUI_Elements.StorePanel, BorderLayout.EAST);

        ControlButtons();
        ControlProjects();
    }

    static public void CreateSaveMenu(String LoadOrNew)
    {
        GUI_Elements.InitializeSaveScreen(LoadOrNew);
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
        GUI_Elements.Tester_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.Architect_Button.setEnabledByScoin(SCoin.SCoin_count);
        GUI_Elements.ProjectManager_Button.setEnabledByScoin(SCoin.SCoin_count);
    }

    static public void ControlProjects()
    {
        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GUI_Elements.Beginner_C_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Beginner_C_Project, LOC.loc_cnt, LOC.Beginner_C_Developer);
                GUI_Elements.Beginner_CSharp_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Beginner_CSharp_Project, LOC.loc_cnt, LOC.Beginner_CSharp_Developer);
                GUI_Elements.Beginner_Dart_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Beginner_Dart_Project, LOC.loc_cnt, LOC.Beginner_Dart_Developer);
                GUI_Elements.Beginner_Java_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Beginner_Java_Project, LOC.loc_cnt, LOC.Beginner_Java_Developer);

                GUI_Elements.Intermediate_C_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Intermediate_C_Project, LOC.loc_cnt, LOC.Intermediate_C_Developer);
                GUI_Elements.Intermediate_CSharp_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Intermediate_CSharp_Project, LOC.loc_cnt, LOC.Intermediate_CSharp_Developer);
                GUI_Elements.Intermediate_Dart_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Intermediate_Dart_Project, LOC.loc_cnt, LOC.Intermediate_Dart_Developer);
                GUI_Elements.Intermediate_Java_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Intermediate_Java_Project, LOC.loc_cnt, LOC.Intermediate_Java_Developer);

                GUI_Elements.Advanced_C_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Advanced_C_Project, LOC.loc_cnt, LOC.Advanced_C_Developer);
                GUI_Elements.Advanced_CSharp_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Advanced_CSharp_Project, LOC.loc_cnt, LOC.Advanced_CSharp_Developer);
                GUI_Elements.Advanced_Dart_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Advanced_Dart_Project, LOC.loc_cnt, LOC.Advanced_Dart_Developer);
                GUI_Elements.Advanced_Java_ProjectButton.setEnabledByLOCandDevelopers(SCoin.Advanced_Java_Project, LOC.loc_cnt, LOC.Advanced_Java_Developer);
            }
        });
        timer.start();
    }
}
