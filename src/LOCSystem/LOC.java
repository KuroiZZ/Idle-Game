package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;

public class LOC //Line of Code
{
    static public int buy_amount = 1;
    static public int loc_cnt = 0;

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

    static public void InitializeSupporters()
    {
        Tester = new Supporter("Tester", 8);
        Architect = new Supporter("Architect", 8);
        ProjectManager = new Supporter("ProjectManager", 8);
    }
    static public List<Developers> CreateEmptyDevelopers()
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

        List<Developers> developers = new ArrayList<Developers>(12);
        developers.add(LOC.Beginner_C_Developer);
        developers.add(LOC.Beginner_CSharp_Developer);
        developers.add(LOC.Beginner_Dart_Developer);
        developers.add(LOC.Beginner_Java_Developer);
        developers.add(LOC.Intermediate_C_Developer);
        developers.add(LOC.Intermediate_CSharp_Developer);
        developers.add(LOC.Intermediate_Dart_Developer);
        developers.add(LOC.Intermediate_Java_Developer);
        developers.add(LOC.Advanced_C_Developer);
        developers.add(LOC.Advanced_CSharp_Developer);
        developers.add(LOC.Advanced_Dart_Developer);
        developers.add(LOC.Advanced_Java_Developer);

        return developers;
    }


    static public List<Developers> CreateSavedDevelopers(ArrayList<String> Developers)
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

        List<Developers> developers = new ArrayList<Developers>(12);
        developers.add(LOC.Beginner_C_Developer);
        developers.add(LOC.Beginner_CSharp_Developer);
        developers.add(LOC.Beginner_Dart_Developer);
        developers.add(LOC.Beginner_Java_Developer);
        developers.add(LOC.Intermediate_C_Developer);
        developers.add(LOC.Intermediate_CSharp_Developer);
        developers.add(LOC.Intermediate_Dart_Developer);
        developers.add(LOC.Intermediate_Java_Developer);
        developers.add(LOC.Advanced_C_Developer);
        developers.add(LOC.Advanced_CSharp_Developer);
        developers.add(LOC.Advanced_Dart_Developer);
        developers.add(LOC.Advanced_Java_Developer);

        return developers;
    }


    static public void BuyDeveloper(Developers Developer, DeveloperButton Button)
    {
        Developer.setNTEandNNPEandNTL(Developer.getNofTotalEmp()+ buy_amount);
        Developer.setPriceAfterBuy(buy_amount);
        Button.setNofDeveloperText();
        Button.setPriceText();
        SoftvoperMain.ControlButtons();
    }

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
