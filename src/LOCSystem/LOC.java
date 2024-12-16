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

/**
 * Manages the creation, buying, and updating of developers, supporters, and projects.
 * The `LOC` class handles initialization of employees
 * keeps track of the total Line of Code (LOC), and updates it over time as developers work.
 * It also manages the interaction between the game’s GUI and its underlying logic for developer and supporter purchases.
 */
public class LOC
{
    /**
     * The amount of developers or supporters to be bought at once.
     */
    static public int buy_amount = 1;

    /**
     * The total number of lines of code (LOC) accumulated in the game.
     * This value is updated periodically based on the total LOC produced by all developers.
     */
    static public float loc_cnt = 0f;

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
     * Initializes all developers with empty input for a new game.
     *
     * @return A list of developers created for the new game.
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
     * Initializes all developers using a saved game's developer JSON string list.
     *
     * @param Developers A list of JSON strings representing saved developers.
     * @return A list of developers loaded from the saved game.
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
     * Initializes all supporters with empty input for a new game.
     *
     * @return A list of supporters created for the new game.
     */
    static public ArrayList<Supporter> CreateEmptySupporters()
    {
        Tester = new Supporter("Tester", 40);
        Architect = new Supporter("Architect", 40);
        ProjectManager = new Supporter("ProjectManager", 40);

        return SaveSystem.CreateSupporterList();
    }


    /**
     * Initializes all supporters using a saved game's supporter JSON string list.
     *
     * @param Supporters A list of JSON strings representing saved supporters.
     * @return A list of supporters loaded from the saved game.
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
     * Initializes projects using a saved game's project JSON string list.
     *
     * @param Projects A list of JSON strings representing saved projects.
     * @return A list of projects loaded from the saved game.
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
     * Returns the chosen developer linked to the given type and rank.
     *
     * @param Type
     * @param Rank
     * @return The chosen developer based on the type and rank, or null if not found.
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
     * Returns the chosen developer button linked to the given type and rank.
     *
     * @param Type
     * @param Rank
     * @return The chosen developer button based on the type and rank, or null if not found.
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
     * Updates the Developer's Total, Project, NonProject employees count, and Total LOC.
     * Also updates the Developer button's developer count and price text.
     *
     * @param Developer The developer being bought.
     * @param Button The corresponding developer button.
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
     * Updates the Supporter's Total, Project, and NonProject employees count.
     * Also updates the Supporter button's count and price text.
     *
     * @param Supporter The supporter being bought.
     * @param Button The corresponding supporter button.
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
     * Creates a process that updates the loc_count value with the total LOC from all developers.
     * The update occurs periodically using a timer.
     */
    public static void UpdateLOC()
    {
        Timer timer = new Timer(62, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                float increment = 0f;
                increment += Beginner_C_Developer.getNofTotalLOC() + Beginner_CSharp_Developer.getNofTotalLOC();
                increment += Beginner_Dart_Developer.getNofTotalLOC() + Beginner_Java_Developer.getNofTotalLOC();
                increment += Intermediate_C_Developer.getNofTotalLOC() + Intermediate_CSharp_Developer.getNofTotalLOC();
                increment += Intermediate_Dart_Developer.getNofTotalLOC() + Intermediate_Java_Developer.getNofTotalLOC();
                increment += Advanced_C_Developer.getNofTotalLOC() + Advanced_CSharp_Developer.getNofTotalLOC();
                increment += Advanced_Dart_Developer.getNofTotalLOC() + Advanced_Java_Developer.getNofTotalLOC();
                increment = increment/16;
                loc_cnt += increment;

                String loc_count = String.format("%.02f", LOC.loc_cnt);
                GUI_Elements.LOCLabel.setText(loc_count);
            }
        });
        timer.start();
    }
}
