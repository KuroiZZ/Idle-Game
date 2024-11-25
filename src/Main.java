import GUI.SoftvoperMain;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args)
    {
        SoftvoperMain UI = new SoftvoperMain();
        UI.CreateUI();

        Timer timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int C_Beginner_Amount = UI.loc_System.C_Beginner.getNofTotalEmp() * UI.loc_System.C_Beginner.getLinePerSecond();
                int CSharp_Beginner_Amount = UI.loc_System.Beginner_CSharp.getNofTotalEmp() * UI.loc_System.Beginner_CSharp.getLinePerSecond();
                int Dart_Beginner_Amount = UI.loc_System.Beginner_Dart.getNofTotalEmp() * UI.loc_System.Beginner_Dart.getLinePerSecond();
                int Java_Beginner_Amount = UI.loc_System.Beginner_Java.getNofTotalEmp() * UI.loc_System.Beginner_Java.getLinePerSecond();

                UI.loc_System.loc_cnt += C_Beginner_Amount + CSharp_Beginner_Amount + Dart_Beginner_Amount + Java_Beginner_Amount;

                UI.LOCLabel.setText("Number of LOC: "+UI.loc_System.loc_cnt);
            }
        });
        timer.start();

    }
}