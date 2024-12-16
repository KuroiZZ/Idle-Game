package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LOCSystem.LOC;
import SCoinSystem.SCoin;

/**
 * The SoftvoperMain class handles the creation and management of different menu screens in the application.
 * It interacts with GUI elements, enables/disables buttons based on certain conditions, and controls project logic.
 */
public class SoftvoperMain
{
    /**
     * Initializes the main menu by calling the appropriate method from GUI_Elements.
     */
    static public void CreateMainMenu()
    {
        GUI_Elements.InitializeMainScreen();
    }

    /**
     * Initializes the game menu, including various panels and controls for the game screen.
     * Adds the panels to the window and controls button behavior.
     */
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

    /**
     * Initializes the save menu screen by calling the appropriate method from GUI_Elements.
     * This method sets up the UI elements for saving a project or loading an existing one.
     */
    static public void CreateSaveMenu()
    {
        GUI_Elements.InitializeSaveScreen();
    }

    /**
     * Controls the enabling/disabling of buttons based on the available SCoin count.
     * This method adjusts the state of buttons for various projects and actions.
     */
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

    /**
     * Controls the enabling/disabling of project buttons based on the number of lines of code (LOC)
     * and the number of developers available for each project.
     */
    static public void ControlProjects()
    {
        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GUI_Elements.User_ProjectButton.setEnabledByLOC(SCoin.User_Project, LOC.loc_cnt);

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
