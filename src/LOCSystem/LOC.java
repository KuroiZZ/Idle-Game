package LOCSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SoftvoperMain;

import javax.swing.*;

public class LOC //Line of Code
{
    public int loc_cnt; //LOC counter
    public LOC.LOCHandler loc_hndler = new LOC.LOCHandler();
    public Timer autoLOCIncreaser;
    Beginner C_Beginner = new Beginner();

    public static void main(String[] args)
    {
        new LOC(); //creates a new LOC object

    }

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
                    SoftvoperMain.LOCLabel.setText("Number of LOC: "+loc_cnt);
                    break;
                case "C Developer":
                    setAutoLOCIncreaser(1000); //1000 millisecond = 1 second
                    autoLOCIncreaser.start();
                    break;
                case "C_Beginner":
                    setAutoLOCIncreaser(C_Beginner.LinePerSecond);
                    autoLOCIncreaser.start();
            }
        }
    }

    public void setAutoLOCIncreaser(int LinePerSecond)//LOC is increased by 1 every "delayMS" millisecond
    {
        autoLOCIncreaser = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loc_cnt += LinePerSecond;
                SoftvoperMain.LOCLabel.setText("Number of LOC: "+loc_cnt);
            }
        });
    }
}
