package SCoinSystem;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


public class SCoin
{
    static public int SCoin_count = 0;
    static public SCoinHandler SCoin_hndler = new SCoinHandler();
    static public SApp Beginner_C_Project = new SApp(100000, 10, 10, "C", "Beginner", 20);
    public static class SCoinHandler implements ActionListener
    {
        static public void BuyDeveloper(Developers Developer)
        {
            SCoin_count -= Developer.getTotalPrice(LOC.buy_amount);
            GUI_Elements.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
        }

        static public void DevelopApp(Developers Developer, DeveloperButton Button, SApp App)
        {
            Developer.setNPEandNNPEandNTL(App.getNecessaryDeveloperCount() + Developer.getNofProjectEmp());
            Button.setNofDeveloperText(Button.getNofDeveloperText() - App.getNecessaryDeveloperCount());
            LOC.loc_cnt -= App.getNecessaryLOC();
            GUI_Elements.LOCLabel.setText("Number of LOC: "+ LOC.loc_cnt);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run()
                {
                    SCoin_count += App.getSCoinToEarn();
                    GUI_Elements.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    Developer.setNPEandNNPEandNTL(Developer.getNofProjectEmp() - App.getNecessaryDeveloperCount());
                    GUI_Elements.Beginner_C.setNofDeveloperText(Button.getNofDeveloperText() + App.getNecessaryDeveloperCount());
                    SoftvoperMain.ControlButtons();
                    timer.cancel();
                }
            };
            timer.schedule(task, App.getTimeSecond()*1000);
        }

        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();
            switch (action)
            {
                case "Beginner_C":
                    BuyDeveloper(LOC.Beginner_C);
                    break;
                case "Beginner_CSharp":
                    BuyDeveloper(LOC.Beginner_CSharp);
                    break;
                case "Beginner_Dart":
                    BuyDeveloper(LOC.Beginner_Dart);
                    break;
                case "Beginner_Java":
                    BuyDeveloper(LOC.Beginner_Java);
                    break;
                case "Intermediate_C":
                    BuyDeveloper(LOC.Intermediate_C);
                    break;
                case "Intermediate_CSharp":
                    BuyDeveloper(LOC.Intermediate_CSharp);
                    break;
                case "Intermediate_Dart":
                    BuyDeveloper(LOC.Intermediate_Dart);
                    break;
                case "Intermediate_Java":
                    BuyDeveloper(LOC.Intermediate_Java);
                    break;
                case "Advanced_C":
                    BuyDeveloper(LOC.Advanced_C);
                    break;
                case "Advanced_CSharp":
                    BuyDeveloper(LOC.Advanced_CSharp);
                    break;
                case "Advanced_Dart":
                    BuyDeveloper(LOC.Advanced_Dart);
                    break;
                case "Advanced_Java":
                    BuyDeveloper(LOC.Advanced_Java);
                    break;
                case "Temporary_Money":
                    SCoin_count += 10;
                    GUI_Elements.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    SoftvoperMain.ControlButtons();
                    break;
                case "Beginner_C_Project":
                    DevelopApp(LOC.Beginner_C, GUI_Elements.Beginner_C, Beginner_C_Project);
                    break;
            }
        }
    }

    public static void ControlPrice()
    {

    }
}
