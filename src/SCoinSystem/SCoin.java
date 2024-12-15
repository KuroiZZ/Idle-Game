package SCoinSystem;

import GUI.DeveloperButton;
import GUI.GUI_Elements;
import GUI.SProjectInformation;
import GUI.SoftvoperMain;
import Handlers.SupporterCheckbox_Handler;
import LOCSystem.*;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;


public class SCoin
{
    static public ArrayList<SProjectInformation> ActiveProjectInformations = new ArrayList<SProjectInformation>(10);
    static public ArrayList<SProject> ActiveProject = new ArrayList<SProject>();
    static public int SCoin_count = 0;
    static public SProject Beginner_C_Project = new SProject(100000, 10, 10, "C", "Beginner", 20,false,false,false, 0);

    static public void BuyEmployee(Employee Employee)
    {
        SCoin_count -= Employee.getTotalPrice(LOC.buy_amount);
        GUI_Elements.SCoinLabel.setText(String.valueOf(SCoin_count));
    }

    static public void DevelopApp(Developers Developer, DeveloperButton Button, SProject Project)
    {
        SProject newProject = new SProject(Project);
        newProject.setHasTester(SupporterCheckbox_Handler.is_Tester_Selected);
        newProject.setHasArchitect(SupporterCheckbox_Handler.is_Architect_Selected);
        newProject.setHasProjectManager(SupporterCheckbox_Handler.is_ProjectManager_Selected);

        if(newProject.HasTester())
        {
            LOC.Tester.setNPEandNNPE(1 + LOC.Tester.getNofProjectEmp());
            GUI_Elements.Tester_Button.setNofDeveloperText();
        }
        if(newProject.HasArchitect())
        {
            LOC.Architect.setNPEandNNPE(1 + LOC.Architect.getNofProjectEmp());
            GUI_Elements.Architect_Button.setNofDeveloperText();
        }
        if(newProject.HasProjectManager())
        {
            LOC.ProjectManager.setNPEandNNPE(1 + LOC.ProjectManager.getNofProjectEmp());
            GUI_Elements.ProjectManager_Button.setNofDeveloperText();
        }

        Developer.setNPEandNNPEandNTL(newProject.getNecessaryDeveloperCount() + Developer.getNofProjectEmp());
        Button.setNofDeveloperText();

        LOC.loc_cnt -= newProject.getNecessaryLOC();
        GUI_Elements.LOCLabel.setText(String.valueOf(LOC.loc_cnt));
        SProjectInformation Project_Information =  CreateAppInformation(newProject);
        ActiveProjectInformations.add(Project_Information);
        ActiveProject.add(newProject);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                SCoin_count += newProject.getSCoinToEarn();
                GUI_Elements.SCoinLabel.setText(String.valueOf(SCoin_count));

                if(newProject.HasTester())
                {
                    LOC.Tester.setNPEandNNPE(LOC.Tester.getNofProjectEmp() - 1);
                    GUI_Elements.Tester_Button.setNofDeveloperText();
                }
                if(newProject.HasArchitect())
                {
                    LOC.Architect.setNPEandNNPE(LOC.Architect.getNofProjectEmp() - 1);
                    GUI_Elements.Architect_Button.setNofDeveloperText();
                }
                if(newProject.HasProjectManager())
                {
                    LOC.ProjectManager.setNPEandNNPE(LOC.ProjectManager.getNofProjectEmp() - 1);
                    GUI_Elements.ProjectManager_Button.setNofDeveloperText();
                }

                Developer.setNPEandNNPEandNTL(Developer.getNofProjectEmp() - newProject.getNecessaryDeveloperCount());
                GUI_Elements.Beginner_C_Button.setNofDeveloperText();

                SoftvoperMain.ControlButtons();
                ActiveProjectInformations.remove(Project_Information);
                ActiveProject.remove(newProject);
                timer.cancel();

            }
        };
        timer.schedule(task, ((100 - newProject.getProgressValue())*newProject.getTimeSecond())*10);
    }

    static public void DevelopSavedApp(ArrayList<SProject> Project)
    {
        for (SProject project : Project)
        {
            SProject newProject = new SProject(project);
            Developers Developer = LOC.ChooseDeveloper(newProject.getLanguageType(), newProject.getRankType());
            DeveloperButton Button = LOC.ChooseDeveloperButton(newProject.getLanguageType(), newProject.getRankType());

            SProjectInformation Project_Information =  CreateAppInformation(newProject);

            ActiveProjectInformations.add(Project_Information);
            ActiveProject.add(newProject);

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run()
                {
                    SCoin_count += newProject.getSCoinToEarn();
                    GUI_Elements.SCoinLabel.setText(String.valueOf(SCoin_count));
                    Developer.setNPEandNNPEandNTL(Developer.getNofProjectEmp() - newProject.getNecessaryDeveloperCount()); // seçilen düzgün gelmeli
                    Button.setNofDeveloperText(); //Seçilen düzgün gelmeli
                    SoftvoperMain.ControlButtons();
                    ActiveProjectInformations.remove(Project_Information);
                    ActiveProject.remove(newProject);
                    timer.cancel();

                }
            };
            timer.schedule(task, ((100 - newProject.getProgressValue())*newProject.getTimeSecond())*10);
        }
    }

    static public SProjectInformation CreateAppInformation(SProject App)
    {
        SProjectInformation Beginner_C_Project_Information = new SProjectInformation("League of Losers", App.getSCoinToEarn(), App.getRankType(), App.getProgressValue());
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            int counter = App.getProgressValue();
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
                    GUI_Elements.ProjectInfoPanel.remove(Beginner_C_Project_Information);
                    GUI_Elements.window.revalidate();
                    GUI_Elements.window.repaint();
                    timer.cancel();
                }
            }
        },0,App.getTimeSecond()*10);
        GUI_Elements.ProjectInfoPanel.add(Beginner_C_Project_Information);

        return Beginner_C_Project_Information;
    }

}
