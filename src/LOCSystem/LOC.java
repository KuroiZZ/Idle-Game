package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SoftvoperMain;

import javax.swing.*;

public class LOC //Line of Code
{
    public int loc_cnt; //LOC counter
    public LOC.LOCHandler loc_hndler = new LOC.LOCHandler();
    public Beginner C_Beginner = new Beginner();
    public Beginner Beginner_CSharp = new Beginner();
    public Beginner Beginner_Dart = new Beginner();
    public Beginner Beginner_Java = new Beginner();

    public LOC()//constructor
    {
        loc_cnt = 0;
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
                    C_Beginner.NofTotalEmp++;
                    break;
                case "Beginner_CSharp":
                    Beginner_CSharp.NofTotalEmp++;
                    break;
                case "Beginner_Dart":
                    Beginner_Dart.NofTotalEmp++;
                    break;
                case "Beginner_Java":
                    Beginner_Java.NofTotalEmp++;
                    break;

            }
        }
    }
}
