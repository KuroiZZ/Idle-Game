package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;

import javax.swing.*;

public class LOC //Line of Code
{
    static public int buy_amount = 1;
    static public int loc_cnt = 0; //LOC counter

    static public Beginner Beginner_C_Developer= new Beginner("C", "Beginner");
    static public Beginner Beginner_CSharp_Developer = new Beginner("CSharp", "Beginner");
    static public Beginner Beginner_Dart_Developer = new Beginner("Dart", "Beginner");
    static public Beginner Beginner_Java_Developer = new Beginner("Java", "Beginner");

    static public Intermediate Intermediate_C_Developer= new Intermediate("C", "Intermediate");
    static public Intermediate Intermediate_CSharp_Developer = new Intermediate("CSharp", "Intermediate");
    static public Intermediate Intermediate_Dart_Developer = new Intermediate("Dart", "Intermediate");
    static public Intermediate Intermediate_Java_Developer = new Intermediate("Java", "Intermediate");

    static public Advanced Advanced_C_Developer= new Advanced("C", "Advanced");
    static public Advanced Advanced_CSharp_Developer = new Advanced("CSharp", "Advanced");
    static public Advanced Advanced_Dart_Developer = new Advanced("Dart", "Advanced");
    static public Advanced Advanced_Java_Developer = new Advanced("Java", "Advanced");

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

                GUI_Elements.LOCLabel.setText("Number of LOC: "+ loc_cnt);
            }
        });
        timer.start();
    }
}
