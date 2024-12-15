package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import SCoinSystem.SProject;
import SaveSystem.SaveSystem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;

public class LOC //Line of Code
{
    //
    static public int buy_amount = 1;
    static public int loc_cnt = 0;

    //Define all employees in game.
    static public Beginner Beginner_C_Developer;
    static public Beginner Beginner_CSharp_Developer;
    static public Beginner Beginner_Dart_Developer;
    static public Beginner Beginner_Java_Developer;

    static public Intermediate Intermediate_C_Developer;
    static public Intermediate Intermediate_CSharp_Developer;
    static public Intermediate Intermediate_Dart_Developer;
    static public Intermediate Intermediate_Java_Developer;

    static public Advanced Advanced_C_Developer;
    static public Advanced Advanced_CSharp_Developer;
    static public Advanced Advanced_Dart_Developer;
    static public Advanced Advanced_Java_Developer;

    static public Supporter Tester;
    static public Supporter Architect;
    static public Supporter ProjectManager;

    /**
     * Initialize Developers with empty input for new game.
     * @return
     */
    static public ArrayList<Developers> CreateEmptyDevelopers()
    {
        Beginner_C_Developer= new Beginner("C", "Beginner");
        Beginner_CSharp_Developer = new Beginner("CSharp", "Beginner");
        Beginner_Dart_Developer = new Beginner("Dart", "Beginner");
        Beginner_Java_Developer = new Beginner("Java", "Beginner");

        Intermediate_C_Developer= new Intermediate("C", "Intermediate");
        Intermediate_CSharp_Developer = new Intermediate("CSharp", "Intermediate");
        Intermediate_Dart_Developer = new Intermediate("Dart", "Intermediate");
        Intermediate_Java_Developer = new Intermediate("Java", "Intermediate");

        Advanced_C_Developer= new Advanced("C", "Advanced");
        Advanced_CSharp_Developer = new Advanced("CSharp", "Advanced");
        Advanced_Dart_Developer = new Advanced("Dart", "Advanced");
        Advanced_Java_Developer = new Advanced("Java", "Advanced");

        return SaveSystem.CreateDeveloperList();
    }

    /**
     * Initialize Developers with saved game's developer jsonstring list.
     * @param Developers
     * @return
     */
    static public ArrayList<Developers> CreateSavedDevelopers(ArrayList<String> Developers)
    {
        ObjectMapper map = new ObjectMapper();
        try
        {
            Beginner_C_Developer = map.readValue(Developers.get(0), Beginner.class);
            Beginner_CSharp_Developer = map.readValue(Developers.get(1), Beginner.class);
            Beginner_Dart_Developer = map.readValue(Developers.get(2), Beginner.class);
            Beginner_Java_Developer = map.readValue(Developers.get(3), Beginner.class);

            Intermediate_C_Developer = map.readValue(Developers.get(4), Intermediate.class);
            Intermediate_CSharp_Developer = map.readValue(Developers.get(5), Intermediate.class);
            Intermediate_Dart_Developer = map.readValue(Developers.get(6), Intermediate.class);
            Intermediate_Java_Developer = map.readValue(Developers.get(7), Intermediate.class);

            Advanced_C_Developer = map.readValue(Developers.get(8), Advanced.class);
            Advanced_CSharp_Developer = map.readValue(Developers.get(9), Advanced.class);
            Advanced_Dart_Developer = map.readValue(Developers.get(10), Advanced.class);
            Advanced_Java_Developer = map.readValue(Developers.get(11), Advanced.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

        return SaveSystem.CreateDeveloperList();
    }

    /**
     * Initialize Supporters with empty input for new game.
     * @return
     */
    static public ArrayList<Supporter> CreateEmptySupporters()
    {
        Tester = new Supporter("Tester", 40);
        Architect = new Supporter("Architect", 40);
        ProjectManager = new Supporter("ProjectManager", 40);

        return SaveSystem.CreateSupporterList();
    }

    /**
     * Initialize Supporters with saved game's supporter jsonstring list.
     * @param Supporters
     * @return
     */
    static public ArrayList<Supporter> CreateSavedSupporters(ArrayList<String> Supporters)
    {
        ObjectMapper map = new ObjectMapper();
        try
        {
            Tester = map.readValue(Supporters.get(0), Supporter.class);
            Architect = map.readValue(Supporters.get(1), Supporter.class);
            ProjectManager = map.readValue(Supporters.get(2), Supporter.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }


        return SaveSystem.CreateSupporterList();
    }

    /**
     * Initialize Projects with saved game's project jsonstring list
     * @param Projects
     * @return
     */
    static public ArrayList<SProject> CreateSavedProjects(ArrayList<String> Projects)
    {
        ArrayList<SProject> projects = new ArrayList<SProject>();
        ObjectMapper map = new ObjectMapper();
        try
        {
            for (int i = 0; i<Projects.size(); i++)
            {
                SProject project = map.readValue(Projects.get(i), SProject.class);
                projects.add(project);
            }
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

        return projects;
    }

    /**
     * Returns choosed Developer linked to Type and Rank paramaters
     * @param Type
     * @param Rank
     * @return
     */
    static public Developers ChooseDeveloper(String Type, String Rank)
    {
        if (Objects.equals(Type, "C"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return LOC.Beginner_C_Developer;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return LOC.Intermediate_C_Developer;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return LOC.Advanced_C_Developer;
            }
        }
        else if (Objects.equals(Type, "CSharp"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return LOC.Beginner_CSharp_Developer;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return LOC.Intermediate_CSharp_Developer;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return LOC.Advanced_CSharp_Developer;
            }
        }
        else if (Objects.equals(Type, "Dart"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return LOC.Beginner_Dart_Developer;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return LOC.Intermediate_Dart_Developer;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return LOC.Advanced_Dart_Developer;
            }
        }
        else if (Objects.equals(Type, "Java"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return LOC.Beginner_Java_Developer;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return LOC.Intermediate_Java_Developer;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return LOC.Advanced_Dart_Developer;
            }
        }
        return null;
    }

    /**
     * Returns choosed DeveloperButton linked to Type and Rank paramaters
     * @param Type
     * @param Rank
     * @return
     */
    static public DeveloperButton ChooseDeveloperButton(String Type, String Rank)
    {
        if (Objects.equals(Type, "C"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return GUI_Elements.Beginner_C_Button;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return GUI_Elements.Intermediate_C_Button;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return GUI_Elements.Advanced_C_Button;
            }
        }
        else if (Objects.equals(Type, "CSharp"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return GUI_Elements.Beginner_CSharp_Button;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return GUI_Elements.Intermediate_CSharp_Button;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return GUI_Elements.Advanced_CSharp_Button;
            }
        }
        else if (Objects.equals(Type, "Dart"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return GUI_Elements.Beginner_Dart_Button;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return GUI_Elements.Intermediate_Dart_Button;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return GUI_Elements.Advanced_Dart_Button;
            }
        }
        else if (Objects.equals(Type, "Java"))
        {
            if (Objects.equals(Rank, "Beginner"))
            {
                return GUI_Elements.Beginner_Java_Button;
            }
            else if (Objects.equals(Rank, "Intermediate"))
            {
                return GUI_Elements.Intermediate_Java_Button;
            }
            else if (Objects.equals(Rank, "Advanced"))
            {
                return GUI_Elements.Advanced_Java_Button;
            }
        }
        return null;
    }

    /**
     * Changes Developer's Total, Project , NonProject employees number and Number of Total LOC.
     * Changes Developer button's Developer count and price text.
     * @param Developer
     * @param Button
     */
    static public void BuyDeveloper(Developers Developer, DeveloperButton Button)
    {
        Developer.setNTEandNNPEandNTL(Developer.getNofTotalEmp()+ buy_amount);
        Developer.setPriceAfterBuy(buy_amount);
        Button.setNofDeveloperText();
        Button.setPriceText();
        SoftvoperMain.ControlButtons();
    }

    /**
     * Changes Supporter's Total, Project and NonProject employees number.
     * Changes Supporter button's Supporter count and price text.
     * @param Supporter
     * @param Button
     */
    static public void BuySupporter(Supporter Supporter, DeveloperButton Button)
    {
        Supporter.setNTEandNNPE(Supporter.getNofTotalEmp() + buy_amount);
        Supporter.setPriceAfterBuy(buy_amount);
        Button.setNofDeveloperText();
        Button.setPriceText();
        SoftvoperMain.ControlButtons();
    }


    /**
     * Creates process which update loc_count's value with Developer's Number of Total LOC.
     */
    public static void UpdateLOC()
    {
        Timer timer = new Timer(62, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int increment = 0;
                increment += Beginner_C_Developer.getNofTotalLOC() + Beginner_CSharp_Developer.getNofTotalLOC();
                increment += Beginner_Dart_Developer.getNofTotalLOC() + Beginner_Java_Developer.getNofTotalLOC();
                increment += Intermediate_C_Developer.getNofTotalLOC() + Intermediate_CSharp_Developer.getNofTotalLOC();
                increment += Intermediate_Dart_Developer.getNofTotalLOC() + Intermediate_Java_Developer.getNofTotalLOC();
                increment += Advanced_C_Developer.getNofTotalLOC() + Advanced_CSharp_Developer.getNofTotalLOC();
                increment += Advanced_Dart_Developer.getNofTotalLOC() + Advanced_Java_Developer.getNofTotalLOC();
                increment = increment/16;
                loc_cnt += increment;

                GUI_Elements.LOCLabel.setText(String.valueOf(loc_cnt));
            }
        });
        timer.start();
    }
}
