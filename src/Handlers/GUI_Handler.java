package Handlers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.Developers;
import LOCSystem.LOC;
import LOCSystem.Supporter;
import SCoinSystem.SCoin;
import SCoinSystem.SProject;
import SaveSystem.Save;
import SaveSystem.SaveSystem;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Handles the various GUI actions and transitions between different screens and operations in the game.
 * It processes button clicks related to saving, loading, creating games, and navigating between different panels.
 */
public class GUI_Handler implements ActionListener
{
    private Save currentSave;
    public static String save_name;

    public void setCurrentSave(Save save)
    {
        this.currentSave = save;
    }

    /**
     * This method handles the actions triggered by button clicks in the GUI.
     * It processes the action commands for switching panels, loading and saving games, and navigating menus.
     *
     * @param event the action event triggered by the button click.
     */
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
            case "Load_Game":
                GUI_Elements.window.getContentPane().removeAll();
                SoftvoperMain.CreateSaveMenu("Load");
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "CreateGame_New":
                GUI_Elements.window.setEnabled(false);

                GUI_Elements.InitializeInputFrame();
                break;
            case "CreateGame_Old":
                // Load an existing game
                GUI_Elements.window.getContentPane().removeAll();
                String saveJson = SaveSystem.GetSave(currentSave._id);
                String[] contents = SaveSystem.ParseJsonStringOneSave(saveJson);

                // Use regex to extract developer, supporter, and project data from the save file
                Pattern pattern = Pattern.compile("\\{[^}]*\\}");
                Matcher matcherD = pattern.matcher(contents[4]);
                Matcher matcherS = pattern.matcher(contents[5]);
                Matcher matcherP = pattern.matcher(contents[6]);

                ArrayList<String> developer_strings = new ArrayList<String>();
                ArrayList<String> supporter_strings = new ArrayList<String>();
                ArrayList<String> project_strings = new ArrayList<String>();

                // Collect developer, supporter, and project data
                while (matcherD.find())
                {
                    developer_strings.add(matcherD.group());
                }
                while (matcherS.find())
                {
                    supporter_strings.add(matcherS.group());
                }
                while (matcherP.find())
                {
                    project_strings.add(matcherP.group());
                }

                // Create developers, supporters, and projects from the saved data
                ArrayList<Developers> developers = LOC.CreateSavedDevelopers(developer_strings);
                ArrayList<Supporter> supporter = LOC.CreateSavedSupporters(supporter_strings);
                ArrayList<SProject> project = LOC.CreateSavedProjects(project_strings);

                // Load the save data into the game state
                LOC.loc_cnt = Float.parseFloat(contents[2]);
                SCoin.SCoin_count = Float.parseFloat(contents[3]);
                SaveSystem.instant_save = new Save(contents[0], contents[1], Float.parseFloat(contents[2]), Float.parseFloat(contents[3]), developers, supporter, project);

                SoftvoperMain.CreateGameMenu();  // Create the game menu
                SCoin.DevelopSavedApp(SaveSystem.instant_save.project);  // Start developing saved app projects
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                LOC.UpdateLOC();  // Update the LOC (lines of code) tracker
                break;
            case "Save":
                try
                {
                    SaveSystem.UpdateInstantSave();
                    SaveSystem.ModifySave(SaveSystem.instant_save.CreateJSON());
                }
                catch (JsonProcessingException e)
                {
                    throw new RuntimeException(e);
                }
                break;
            case "Delete":
                SaveSystem.DeleteSave(currentSave._id);
                GUI_Elements.window.getContentPane().removeAll();
                SoftvoperMain.CreateMainMenu();
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;
            case "Main_Menu":
                GUI_Elements.window.getContentPane().removeAll();
                SoftvoperMain.CreateMainMenu();
                SaveSystem.instant_save = null;
                for (Timer t : SCoin.ActiveTimers)
                {
                    t.cancel();
                }
                for (TimerTask ts : SCoin.ActiveTasks)
                {
                    ts.cancel();
                }
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                break;


        }
    }


}
