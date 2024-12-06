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

    static public Beginner Beginner_C= new Beginner();
    static public Beginner Beginner_CSharp = new Beginner();
    static public Beginner Beginner_Dart = new Beginner();
    static public Beginner Beginner_Java = new Beginner();

    static public Intermediate Intermediate_C= new Intermediate();
    static public Intermediate Intermediate_CSharp = new Intermediate();
    static public Intermediate Intermediate_Dart = new Intermediate();
    static public Intermediate Intermediate_Java = new Intermediate();

    static public Advanced Advanced_C= new Advanced();
    static public Advanced Advanced_CSharp = new Advanced();
    static public Advanced Advanced_Dart = new Advanced();
    static public Advanced Advanced_Java = new Advanced();

    static public void BuyDeveloper(Developers Developer, DeveloperButton Button)
    {
        Developer.setNTEandNNPEandNTL(Developer.getNofTotalEmp()+ buy_amount);
        Developer.setPriceAfterBuy(buy_amount);
        Button.setNofDeveloperText(Button.getNofDeveloperText() + buy_amount);
        Button.setPriceText(Developer.getTotalPrice(buy_amount));
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
                increment += Beginner_C.getNofTotalLOC() + Beginner_CSharp.getNofTotalLOC();
                increment += Beginner_Dart.getNofTotalLOC() + Beginner_Java.getNofTotalLOC();
                increment += Intermediate_C.getNofTotalLOC() + Intermediate_CSharp.getNofTotalLOC();
                increment += Intermediate_Dart.getNofTotalLOC() + Intermediate_Java.getNofTotalLOC();
                increment += Advanced_C.getNofTotalLOC() + Advanced_CSharp.getNofTotalLOC();
                increment += Advanced_Dart.getNofTotalLOC() + Advanced_Java.getNofTotalLOC();
                increment = increment/16;
                loc_cnt += increment;

                GUI_Elements.LOCLabel.setText("Number of LOC: "+ loc_cnt);
            }
        });
        timer.start();
    }
}
