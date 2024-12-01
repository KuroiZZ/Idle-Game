package SCoinSystem;

import GUI.SoftvoperMain;
import LOCSystem.LOC;

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
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();
            switch (action)
            {
                case "Beginner_C":
                    SCoin_count -= LOC.Beginner_C.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_CSharp":
                    SCoin_count -= LOC.Beginner_CSharp.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_Dart":
                    SCoin_count -= LOC.Beginner_Dart.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_Java":
                    SCoin_count -= LOC.Beginner_Java.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Intermediate_C":
                    SCoin_count -= LOC.Intermediate_C.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Intermediate_CSharp":
                    SCoin_count -= LOC.Intermediate_CSharp.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Intermediate_Dart":
                    SCoin_count -= LOC.Intermediate_Dart.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_C":
                    SCoin_count -= LOC.Advanced_C.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_CSharp":
                    SCoin_count -= LOC.Advanced_CSharp.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_Dart":
                    SCoin_count -= LOC.Advanced_Dart.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_Java":
                    SCoin_count -= LOC.Advanced_Java.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Temporary_Money":
                    SCoin_count += 10;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_C_Project":
                    LOC.Beginner_C.setNPEandNNPEandNTL(Beginner_C_Project.getNecessaryDeveloperCount() + LOC.Beginner_C.getNofProjectEmp());
                    LOC.loc_cnt -= Beginner_C_Project.getNecessaryLOC();
                    SoftvoperMain.LOCLabel.setText("Number of LOC: "+ LOC.loc_cnt);
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run()
                        {
                            SCoin_count += Beginner_C_Project.getSCoinToEarn();
                            SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                            LOC.Beginner_C.setNPEandNNPEandNTL(LOC.Beginner_C.getNofProjectEmp() - Beginner_C_Project.getNecessaryDeveloperCount());
                            timer.cancel();
                        }
                    };
                    timer.schedule(task, Beginner_C_Project.getTimeSecond()*1000);
                    break;
            }
        }
    }

    public static void ControlPrice()
    {

    }
}
