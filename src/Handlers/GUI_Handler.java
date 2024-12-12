package Handlers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.Developers;
import LOCSystem.LOC;
import SCoinSystem.SCoin;
import SaveSystem.Save;
import SaveSystem.SaveSystem;
import com.fasterxml.jackson.core.JsonProcessingException;

public class GUI_Handler implements ActionListener
{
    private Save currentSave;

    public void setCurrentSave(Save save)
    {
        this.currentSave = save;
    }
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
                SoftvoperMain.CreateSaveMenu("New");
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
                GUI_Elements.window.getContentPane().removeAll();

                List<Developers> Developers = LOC.CreateEmptyDevelopers();
                SoftvoperMain.CreateGameMenu();
                SaveSystem.instant_save = new Save("Araba", Developers);
                try
                {
                    SaveSystem.SendSave(SaveSystem.instant_save.CreateJSON());
                }
                catch (JsonProcessingException e)
                {
                    throw new RuntimeException(e);
                }

                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                LOC.UpdateLOC();
                break;
            case "CreateGame_Old":
                GUI_Elements.window.getContentPane().removeAll();
                String saveJson = SaveSystem.GetSave(currentSave._id);
                String[] contents = SaveSystem.ParseJsonStringOneSave(saveJson);

                Pattern pattern = Pattern.compile("\\{[^}]*\\}");
                Matcher matcher = pattern.matcher(contents[4]);

                ArrayList<String> developer_strings = new ArrayList<>();

                while (matcher.find())
                {
                    developer_strings.add(matcher.group());
                }

                List<Developers> developers = LOC.CreateSavedDevelopers(developer_strings);
                LOC.loc_cnt = Integer.parseInt(contents[2]);
                SCoin.SCoin_count = Integer.parseInt(contents[3]);
                SoftvoperMain.CreateGameMenu();
                SaveSystem.instant_save = new Save(contents[0], contents[1], Integer.parseInt(contents[2]), Integer.parseInt(contents[3]), developers);
                GUI_Elements.window.revalidate();
                GUI_Elements.window.repaint();
                LOC.UpdateLOC();
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


        }
    }


}
