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

/**
 * The SCoin class manages the logic for creating and managing projects,
 * handling employee purchases, tracking progress, and updating SCoin balances.
 * It interacts with various GUI components to provide feedback on the state of the game.
 */
public class SCoin
{
    /**
        * List to store active projectInformation
        * It holds information about the active projects currently being developed.
        */
    static public ArrayList<SProjectInformation> ActiveProjectInformations = new ArrayList<SProjectInformation>(10);

    /**
     * List to store active projects.
     * It contains the projects that are being worked on or have been developed.
     */
    static public ArrayList<SProject> ActiveProject = new ArrayList<SProject>();

    /**
     * List to store active timers.
     * It tracks the timers associated with the active projects in the game.
     */
    static public ArrayList<Timer> ActiveTimers = new ArrayList<Timer>();

    /**
     * List to store active timer tasks.
     * It holds the timer tasks associated with the active projects.
     */
    static public ArrayList<TimerTask> ActiveTasks = new ArrayList<TimerTask>();

    /**
     * Global variable for the SCoin count, initialized to 0.
     */
    static public float SCoin_count = 0;

    // Sample user and project data
    static public SProject User_Project = new SProject(25, 1, 5, "User", "", 0, false, false, false, 0);
    static public SProject Beginner_C_Project = new SProject(1000, 10, 10, "C", "Beginner", 5,false,false,false, 0);
    static public SProject Beginner_CSharp_Project = new SProject(1000, 10, 10, "CSharp", "Beginner", 5,false,false,false, 0);
    static public SProject Beginner_Dart_Project = new SProject(1000, 10, 10, "Dart", "Beginner", 5,false,false,false, 0);
    static public SProject Beginner_Java_Project = new SProject(1000, 10, 10, "Java", "Beginner", 5,false,false,false, 0);

    static public SProject Intermediate_C_Project = new SProject(5000, 30, 25, "C", "Intermediate", 5,false,false,false, 0);
    static public SProject Intermediate_CSharp_Project = new SProject(5000, 30, 25, "CSharp", "Intermediate", 5,false,false,false, 0);
    static public SProject Intermediate_Dart_Project = new SProject(5000, 30, 25, "Dart", "Intermediate", 5,false,false,false, 0);
    static public SProject Intermediate_Java_Project = new SProject(5000, 30, 25, "Java", "Intermediate", 5,false,false,false, 0);

    static public SProject Advanced_C_Project = new SProject(20000, 70, 60, "C", "Advanced", 5,false,false,false, 0);
    static public SProject Advanced_CSharp_Project = new SProject(20000, 70, 60, "CSharp", "Advanced", 5,false,false,false, 0);
    static public SProject Advanced_Dart_Project = new SProject(20000, 70, 60, "Dart", "Advanced", 5,false,false,false, 0);
    static public SProject Advanced_Java_Project = new SProject(20000, 70, 60, "Java", "Advanced", 5,false,false,false, 0);

    /**
     * This method is used when purchasing an employee.
     * It decreases the SCoin count by the employee's total price and updates the SCoin label in the UI.
     *
     * @param Employee The employee being bought
     */
    static public void BuyEmployee(Employee Employee)
    {
        SCoin_count -= Employee.getTotalPrice(LOC.buy_amount);
        String sCoin_count = String.format("%.02f", SCoin_count);
        GUI_Elements.SCoinLabel.setText(sCoin_count);
    }

    /**
     * This method is used to create a new project, update the corresponding employee count,
     * decrease the LOC count, and activate the project.
     * Once the project finishes, it reassigns employees and updates the SCoin balance.
     *
     * @param Developer The developer assigned to the project
     * @param Button The button corresponding to the developer
     * @param Project The project being created
     */
    static public void DevelopApp(Developers Developer, DeveloperButton Button, SProject Project)
    {
        SProject newProject = new SProject(Project);
        newProject.setHasTester(SupporterCheckbox_Handler.is_Tester_Selected);
        newProject.setSCoinToEarn();
        newProject.setHasArchitect(SupporterCheckbox_Handler.is_Architect_Selected);
        newProject.setNecessaryLOC();
        newProject.setHasProjectManager(SupporterCheckbox_Handler.is_ProjectManager_Selected);
        newProject.setTimeSecond();

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

        if (Developer != null) Developer.setNPEandNNPEandNTL(newProject.getNecessaryDeveloperCount() + Developer.getNofProjectEmp());

        if (Button != null) Button.setNofDeveloperText();

        LOC.loc_cnt -= newProject.getNecessaryLOC();
        String loc_count = String.format("%.02f", LOC.loc_cnt);
        GUI_Elements.LOCLabel.setText(loc_count);
        SProjectInformation Project_Information =  CreateAppInformation(newProject);
        ActiveProjectInformations.add(Project_Information);
        ActiveProject.add(newProject);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                SCoin_count += newProject.getSCoinToEarn();
                String sCoin_count = String.format("%.02f", SCoin_count);
                GUI_Elements.SCoinLabel.setText(sCoin_count);

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

                if (Developer != null) Developer.setNPEandNNPEandNTL(Developer.getNofProjectEmp() - newProject.getNecessaryDeveloperCount());

                if (Button != null) Button.setNofDeveloperText();


                SoftvoperMain.ControlButtons();
                ActiveProjectInformations.remove(Project_Information);
                ActiveProject.remove(newProject);
                timer.cancel();

            }
        };
        timer.schedule(task, ((100 - newProject.getProgressValue())*newProject.getTimeSecond())*10);
        ActiveTimers.add(timer);
        ActiveTasks.add(task);
    }

    /**
     * This method is used to load saved projects from a list and resume their progress.
     * It creates new projects, assigns developers, updates employee counts, and handles the project lifecycle.
     *
     * @param Project The list of saved projects to be loaded
     */
    static public void DevelopSavedApp(ArrayList<SProject> Project)
    {
        for (SProject project : Project)
        {
            SProject newProject = new SProject(project, project.getProgressValue());
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
                    String sCoin_count = String.format("%.02f", SCoin_count);
                    GUI_Elements.SCoinLabel.setText(sCoin_count);

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

                    if (Developer != null) Developer.setNPEandNNPEandNTL(Developer.getNofProjectEmp() - newProject.getNecessaryDeveloperCount());

                    if (Button != null) Button.setNofDeveloperText();

                    SoftvoperMain.ControlButtons();
                    ActiveProjectInformations.remove(Project_Information);
                    ActiveProject.remove(newProject);
                    timer.cancel();

                }
            };
            timer.schedule(task, ((100 - newProject.getProgressValue())*newProject.getTimeSecond())*10);
            ActiveTimers.add(timer);
            ActiveTasks.add(task);
        }
    }

    /**
     * Creates an information panel for the activated project, displaying its details such as progress and SCoin to earn.
     * Also creates a progress bar based on the project's time value and updates the progress periodically.
     *
     * @param Project The project for which the information panel is created.
     * @return The created SProjectInformation object representing the project's progress and details.
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
