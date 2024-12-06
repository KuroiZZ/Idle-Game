package SCoinSystem;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SProjectInformation;
import GUI.SoftvoperMain;
import LOCSystem.*;

import java.util.TimerTask;
import java.util.Timer;


public class SCoin
{
    static public int SCoin_count = 0;
    static public SProject Beginner_C_Project = new SProject(100000, 10, 10, "C", "Beginner", 20);

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

}
