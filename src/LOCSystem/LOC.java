package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SoftvoperMain;

import javax.swing.*;

public class LOC //Line of Code
{
    static private int buy_amount = 1;
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
    /*
    public LOC()//constructor
    {
        loc_cnt = 0;
        C_Beginner = new Beginner();
        Beginner_CSharp = new Beginner();
        Beginner_Dart = new Beginner();
        Beginner_Java = new Beginner();
    }*/

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
                    Beginner_C.setNTEandNNPEandNTL(Beginner_C.getNofTotalEmp()+buy_amount);
                    break;
                case "Beginner_CSharp":
                    Beginner_CSharp.setNTEandNNPEandNTL(Beginner_CSharp.getNofTotalEmp()+buy_amount);
                    break;
                case "Beginner_Dart":
                    Beginner_Dart.setNTEandNNPEandNTL(Beginner_Dart.getNofTotalEmp()+buy_amount);
                    break;
                case "Beginner_Java":
                    Beginner_Java.setNTEandNNPEandNTL(Beginner_Java.getNofTotalEmp()+buy_amount);
                    break;
                case "Intermediate_C":
                    Intermediate_C.setNTEandNNPEandNTL(Intermediate_C.getNofTotalEmp()+buy_amount);
                    break;
                case "Intermediate_CSharp":
                    Intermediate_CSharp.setNTEandNNPEandNTL(Intermediate_CSharp.getNofTotalEmp()+buy_amount);
                    break;
                case "Intermediate_Dart":
                    Intermediate_Dart.setNTEandNNPEandNTL(Intermediate_Dart.getNofTotalEmp()+buy_amount);
                    break;
                case "Intermediate_Java":
                    Intermediate_Java.setNTEandNNPEandNTL(Intermediate_Java.getNofTotalEmp()+buy_amount);
                    break;
                case "Advanced_C":
                    Advanced_C.setNTEandNNPEandNTL(Advanced_C.getNofTotalEmp()+buy_amount);
                    break;
                case "Advanced_CSharp":
                    Advanced_CSharp.setNTEandNNPEandNTL(Advanced_CSharp.getNofTotalEmp()+buy_amount);
                    break;
                case "Advanced_Dart":
                    Advanced_Dart.setNTEandNNPEandNTL(Advanced_Dart.getNofTotalEmp()+buy_amount);
                    break;
                case "Advanced_Java":
                    Advanced_Java.setNTEandNNPEandNTL(Advanced_Java.getNofTotalEmp()+buy_amount);
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

                SoftvoperMain.LOCLabel.setText("Number of LOC: "+ loc_cnt);
            }
        });
        timer.start();
    }
}
