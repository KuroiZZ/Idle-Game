package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import SCoinSystem.SCoin;

import javax.swing.*;

public class LOC //Line of Code
{
    static public int buy_amount = 1;
    static public LOC.BuyAmountHandler buyamount_hndler = new LOC.BuyAmountHandler();
    static public int loc_cnt = 0; //LOC counter
    static public LOC.LOCHandler loc_hndler = new LOC.LOCHandler();
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
        Developer.setNTEandNNPEandNTL(Developer.getNofTotalEmp()+buy_amount);
        Button.setNofDeveloperText(Button.getNofDeveloperText() + buy_amount);
    }

    public static class LOCHandler implements ActionListener //handles events of LOC objects
    {
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();

            switch (action)
            {
                case "computer":
                    loc_cnt++;
                    break;
                case "Beginner_C":
                    LOC.BuyDeveloper(Beginner_C, GUI_Elements.Beginner_C);
                    break;
                case "Beginner_CSharp":
                    LOC.BuyDeveloper(Beginner_CSharp, GUI_Elements.Beginner_CSharp);
                    break;
                case "Beginner_Dart":
                    LOC.BuyDeveloper(Beginner_Dart, GUI_Elements.Beginner_Dart);
                    break;
                case "Beginner_Java":
                    LOC.BuyDeveloper(Beginner_Java, GUI_Elements.Beginner_Java);
                    break;
                case "Intermediate_C":
                    LOC.BuyDeveloper(Intermediate_C, GUI_Elements.Intermediate_C);
                    break;
                case "Intermediate_CSharp":
                    LOC.BuyDeveloper(Intermediate_CSharp, GUI_Elements.Intermediate_CSharp);
                    break;
                case "Intermediate_Dart":
                    LOC.BuyDeveloper(Intermediate_Dart, GUI_Elements.Intermediate_Dart);
                    break;
                case "Intermediate_Java":
                    LOC.BuyDeveloper(Intermediate_Java, GUI_Elements.Intermediate_Java);
                    break;
                case "Advanced_C":
                    LOC.BuyDeveloper(Advanced_C, GUI_Elements.Advanced_C);
                    break;
                case "Advanced_CSharp":
                    LOC.BuyDeveloper(Advanced_CSharp, GUI_Elements.Advanced_CSharp);
                    break;
                case "Advanced_Dart":
                    LOC.BuyDeveloper(Advanced_Dart, GUI_Elements.Advanced_Dart);
                    break;
                case "Advanced_Java":
                    LOC.BuyDeveloper(Advanced_Java, GUI_Elements.Advanced_Java);
                    break;

            }
        }
    }

    public static class BuyAmountHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String action = event.getActionCommand();

            switch (action) {
                case "1":
                    buy_amount = 1;
                    break;
                case "10":
                    buy_amount = 10;
                    break;
                case "100":
                    buy_amount = 100;
                    break;
            }
        }
    }
    public static void UpdateLOC()
    {
        Timer timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loc_cnt += Beginner_C.getNofTotalLOC() + Beginner_CSharp.getNofTotalLOC();
                loc_cnt += Beginner_Dart.getNofTotalLOC() + Beginner_Java.getNofTotalLOC();
                loc_cnt += Intermediate_C.getNofTotalLOC() + Intermediate_CSharp.getNofTotalLOC();
                loc_cnt += Intermediate_Dart.getNofTotalLOC() + Intermediate_Java.getNofTotalLOC();
                loc_cnt += Advanced_C.getNofTotalLOC() + Advanced_CSharp.getNofTotalLOC();
                loc_cnt += Advanced_Dart.getNofTotalLOC() + Advanced_Java.getNofTotalLOC();

                GUI_Elements.LOCLabel.setText("Number of LOC: "+ loc_cnt);
            }
        });
        timer.start();
    }
}
