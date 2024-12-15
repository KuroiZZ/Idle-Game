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
    //Creating ActiveProject and ActiveProjectInformation list for saving game
    //This need because we want to know all the projects at that time.
    static public ArrayList<SProjectInformation> ActiveProjectInformations = new ArrayList<SProjectInformation>(10);
    static public ArrayList<SProject> ActiveProject = new ArrayList<SProject>();
    //Global SCoin_count variable defined.
    static public int SCoin_count = 0;
    //Projects Created.
    static public SProject Beginner_C_Project = new SProject(100000, 10, 10, "C", "Beginner", 20,false,false,false, 0);
    static public SProject Beginner_CSharp_Project = new SProject(100000, 10, 10, "CSharp", "Beginner", 20,false,false,false, 0);
    static public SProject Beginner_Dart_Project = new SProject(100000, 10, 10, "Dart", "Beginner", 20,false,false,false, 0);
    static public SProject Beginner_Java_Project = new SProject(100000, 10, 10, "Java", "Beginner", 20,false,false,false, 0);

    static public SProject Intermediate_C_Project = new SProject(100000, 10, 10, "C", "Intermediate", 20,false,false,false, 0);
    static public SProject Intermediate_CSharp_Project = new SProject(100000, 10, 10, "CSharp", "Intermediate", 20,false,false,false, 0);
    static public SProject Intermediate_Dart_Project = new SProject(100000, 10, 10, "Dart", "Intermediate", 20,false,false,false, 0);
    static public SProject Intermediate_Java_Project = new SProject(100000, 10, 10, "Java", "Intermediate", 20,false,false,false, 0);

    static public SProject Advanced_C_Project = new SProject(100000, 10, 10, "C", "Advanced", 20,false,false,false, 0);
    static public SProject Advanced_CSharp_Project = new SProject(100000, 10, 10, "CSharp", "Advanced", 20,false,false,false, 0);
    static public SProject Advanced_Dart_Project = new SProject(100000, 10, 10, "Dart", "Advanced", 20,false,false,false, 0);
    static public SProject Advanced_Java_Project = new SProject(100000, 10, 10, "Java", "Advanced", 20,false,false,false, 0);

    /**
     * When buying employee this function decreases the SCoin_count and set label to new value
     * @param Employee
     */
    static public void BuyEmployee(Employee Employee)
    {
        SCoin_count -= Employee.getTotalPrice(LOC.buy_amount);
        GUI_Elements.SCoinLabel.setText(String.valueOf(SCoin_count));
    }

    /**
     * Creates Project, ProjectInformation panel,
     * Decreases the used employees count and texts, decreases LOC count and text.
     * Activates project and when it finishes reassign employees
     * When project finishes increase SCoin_Count
     * This function used for create new project.
     * @param Developer
     * @param Button
     * @param Project
     */
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
                Button.setNofDeveloperText();

                SoftvoperMain.ControlButtons();
                ActiveProjectInformations.remove(Project_Information);
                ActiveProject.remove(newProject);
                timer.cancel();

            }
        };
        timer.schedule(task, ((100 - newProject.getProgressValue())*newProject.getTimeSecond())*10);
    }


    /**
     * Creates Project, ProjectInformation panel,
     * Decreases the used employees count and texts, decreases LOC count and text.
     * Activates project and when it finishes reassign employees
     * When project finishes increase SCoin_Count
     * This function used for load saved projects.
     * @param Project
     */
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
                    Button.setNofDeveloperText();
                    SoftvoperMain.ControlButtons();
                    ActiveProjectInformations.remove(Project_Information);
                    ActiveProject.remove(newProject);
                    timer.cancel();

                }
            };
            timer.schedule(task, ((100 - newProject.getProgressValue())*newProject.getTimeSecond())*10);
        }
    }

    /**
     * Creates information panel for activated project.
     * Creates progressBar with selected projects time value.
     * Increases progressBar with periods.
     * @param Project
     * @return
     */
    static public SProjectInformation CreateAppInformation(SProject Project)
    {
        SProjectInformation Project_Information = new SProjectInformation(Project.getSCoinToEarn(), Project.getRankType(), Project.getProgressValue());
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            int counter = Project.getProgressValue();
            @Override
            public void run()
            {
                if(counter < 100)
                {
                    Project_Information.setAppProgressValue(counter);
                    counter++;
                }
                else
                {
                    GUI_Elements.ProjectInfoPanel.remove(Project_Information);
                    GUI_Elements.window.revalidate();
                    GUI_Elements.window.repaint();
                    timer.cancel();
                }
            }
        },0,Project.getTimeSecond()*10);
        GUI_Elements.ProjectInfoPanel.add(Project_Information);

        return Project_Information;
    }

}
