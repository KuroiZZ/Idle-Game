package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SoftvoperMain;

import javax.swing.*;

public class LOC //Line of Code
{
    public int loc_cnt; //LOC counter
    public LOC.LOCHandler loc_hndler = new LOC.LOCHandler();
    public Beginner C_Beginner;
    public Beginner Beginner_CSharp;
    public Beginner Beginner_Dart;
    public Beginner Beginner_Java;

    public LOC()//constructor
    {
        loc_cnt = 0;
        C_Beginner = new Beginner();
        Beginner_CSharp = new Beginner();
        Beginner_Dart = new Beginner();
        Beginner_Java = new Beginner();
    }

    public class LOCHandler implements ActionListener //handles events of LOC objects
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
                    C_Beginner.setNTEandNNPEandNTL(C_Beginner.getNofTotalEmp()+1);
                    break;
                case "Beginner_CSharp":
                    Beginner_CSharp.setNTEandNNPEandNTL(Beginner_CSharp.getNofTotalEmp()+1);
                    break;
                case "Beginner_Dart":
                    Beginner_Dart.setNTEandNNPEandNTL(Beginner_Dart.getNofTotalEmp()+1);
                    break;
                case "Beginner_Java":
                    Beginner_Java.setNTEandNNPEandNTL(Beginner_Java.getNofTotalEmp()+1);
                    break;

            }
        }
    }
    public void UpdateLOC()
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
