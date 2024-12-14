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
import LOCSystem.Supporter;
import SCoinSystem.SCoin;
import SaveSystem.Save;
import SaveSystem.SaveSystem;
import com.fasterxml.jackson.core.JsonProcessingException;

public class GUI_Handler implements ActionListener
{
    private Save currentSave;
    public static String save_name;

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
                GUI_Elements.window.getContentPane().removeAll();
                LOC.InitializeSupporters();
                String saveJson = SaveSystem.GetSave(currentSave._id);
                System.out.println(saveJson);
                String[] contents = SaveSystem.ParseJsonStringOneSave(saveJson);

                System.out.println(contents[4]);
                System.out.println(contents[5]);

                Pattern pattern = Pattern.compile("\\{[^}]*\\}");
                Matcher matcherD = pattern.matcher(contents[4]);
                Matcher matcherS = pattern.matcher(contents[5]);

                ArrayList<String> developer_strings = new ArrayList<>();
                ArrayList<String> supporter_strings = new ArrayList<>();

                while (matcherD.find())
                {
                    developer_strings.add(matcherD.group());
                }
                while (matcherS.find())
                {
                    supporter_strings.add(matcherS.group());
                }

                ArrayList<Developers> developers = LOC.CreateSavedDevelopers(developer_strings);
                ArrayList<Supporter> supporter = LOC.CreateSavedSupporters(supporter_strings);
                LOC.loc_cnt = Integer.parseInt(contents[2]);
                SCoin.SCoin_count = Integer.parseInt(contents[3]);
                SoftvoperMain.CreateGameMenu();
                SaveSystem.instant_save = new Save(contents[0], contents[1], Integer.parseInt(contents[2]), Integer.parseInt(contents[3]), developers, supporter);
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
