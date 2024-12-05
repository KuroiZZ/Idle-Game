package SCoinSystem;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SProjectInformation;
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
    static public SProject Beginner_C_Project = new SProject(100000, 10, 10, "C", "Beginner", 20);
    public static class SCoinHandler implements ActionListener
    {
        static public void BuyDeveloper(Developers Developer)
        {
            SCoin_count -= Developer.getTotalPrice(LOC.buy_amount);
            GUI_Elements.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
        }

        static public void DevelopApp(Developers Developer, DeveloperButton Button, SProject Project)
        {
            Developer.setNPEandNNPEandNTL(Project.getNecessaryDeveloperCount() + Developer.getNofProjectEmp());
            Button.setNofDeveloperText(Button.getNofDeveloperText() - Project.getNecessaryDeveloperCount());
            LOC.loc_cnt -= Project.getNecessaryLOC();
            GUI_Elements.LOCLabel.setText("Number of LOC: "+ LOC.loc_cnt);
            CreateAppInformation(Project);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run()
                {
                    SCoin_count += Project.getSCoinToEarn();
                    GUI_Elements.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    Developer.setNPEandNNPEandNTL(Developer.getNofProjectEmp() - Project.getNecessaryDeveloperCount());
                    GUI_Elements.Beginner_C.setNofDeveloperText(Button.getNofDeveloperText() + Project.getNecessaryDeveloperCount());
                    SoftvoperMain.ControlButtons();
                    timer.cancel();
                }
            };
            timer.schedule(task, Project.getTimeSecond()*1000);
        }
        static public void CreateAppInformation(SProject App)
        {
            SProjectInformation Beginner_C_Project_Information = new SProjectInformation("League of Losers", App.getSCoinToEarn(), App.getRankType());
            java.util.Timer timer = new java.util.Timer();
            timer.scheduleAtFixedRate(new TimerTask()
            {
                int counter = 0;
                @Override
                public void run()
                {
                    if(counter < 100)
                    {
                        Beginner_C_Project_Information.setAppProgressValue(counter);
                        counter++;
                    }
                    else
                    {
                        GUI_Elements.CoderPanel.remove(Beginner_C_Project_Information);
                        GUI_Elements.window.revalidate();
                        GUI_Elements.window.repaint();
                        timer.cancel();
                    }
                }
            },0,App.getTimeSecond()*10);
            GUI_Elements.CoderPanel.add(Beginner_C_Project_Information);
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
