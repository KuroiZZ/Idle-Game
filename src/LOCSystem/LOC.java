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
    static public Beginner C_Beginner= new Beginner();
    static public Beginner Beginner_CSharp = new Beginner();
    static public Beginner Beginner_Dart = new Beginner();
    static public Beginner Beginner_Java = new Beginner();

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
                case "C_Beginner":
                    C_Beginner.setNTEandNNPEandNTL(C_Beginner.getNofTotalEmp()+buy_amount);
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
            }
        }
    }
    public static class BuyAmountHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();

            switch (action)
            {
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
                loc_cnt += C_Beginner.getNofTotalLOC() + Beginner_CSharp.getNofTotalLOC();
                loc_cnt += Beginner_Dart.getNofTotalLOC() + Beginner_Java.getNofTotalLOC();

                SoftvoperMain.LOCLabel.setText("Number of LOC: "+ loc_cnt);
            }
        });
        timer.start();
    }
}
