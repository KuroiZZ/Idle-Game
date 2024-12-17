package SCoinSystem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a project in the SCoin system.
 */
public class SProject
{

    /**
     * The number of lines of code required for the development of the project.
     */
    private int NecessaryLOC;

    /**
     * The amount of SCoin that can be earned by completing the project.
     */
    private int SCoinToEarn;

    /**
     * Time in seconds required to complete the project.
     */
    private int TimeSecond;

    /**
     * The programming language used in the project.
     */
    private String LanguageType;

    /**
     * The rank of the project (e.g., Beginner, Intermediate, Advanced).
     */
    private String RankType;

    /**
     * The number of developers required for the project.
     */
    private int NecessaryDeveloperCount;

    /**
     * Whether the project has a tester assigned.
     */
    public boolean hasTester;

    /**
     * Whether the project has an architect assigned.
     */
    public boolean hasArchitect;

    /**
     * Whether the project has a project manager assigned.
     */
    public boolean hasProjectManager;

    /**
     * The current progress of the project as a percentage (0-100).
     */
    private int progressValue;

    /**
     * Constructs an SProject object from the provided parameters.
     * This constructor is used when deserializing the project from a JSON string
     * @param necessaryLOC
     * @param ScoinToEarn
     * @param timeSecond
     * @param languageType
     * @param rankType
     * @param necessaryDeveloperCount
     * @param hasTester
     * @param hasArchitect
     * @param hasProjectManager
     * @param progressValue
     */
    @JsonCreator
    public SProject(@JsonProperty("necessaryLOC") int necessaryLOC, @JsonProperty("scoinToEarn") int ScoinToEarn,
                    @JsonProperty("timeSecond") int timeSecond, @JsonProperty("languageType") String languageType,
                    @JsonProperty("rankType")String rankType, @JsonProperty("necessaryDeveloperCount") int necessaryDeveloperCount,
                    @JsonProperty("hasTester") boolean hasTester, @JsonProperty("hasArchitect") boolean hasArchitect,
                    @JsonProperty("hasProjectManager") boolean hasProjectManager, @JsonProperty("progressValue") int progressValue)
    {
        this.NecessaryLOC = necessaryLOC;
        this.SCoinToEarn = ScoinToEarn;
        this.TimeSecond = timeSecond;
        this.LanguageType = languageType;
        this.RankType = rankType;
        this.NecessaryDeveloperCount = necessaryDeveloperCount;
        this.hasTester = hasTester;
        this.hasArchitect = hasArchitect;
        this.hasProjectManager = hasProjectManager;
        this.progressValue = progressValue;
    }

    /**
     * Constructs a copy of the provided SProject object.
     * Used to clone an existing project
     * @param sProject
     */
    public SProject(SProject sProject)
    {
        this.hasTester = sProject.HasTester();
        this.hasArchitect = sProject.HasArchitect();
        this.hasProjectManager = sProject.HasProjectManager();
        this.NecessaryLOC = sProject.getNecessaryLOC();
        this.SCoinToEarn = sProject.getSCoinToEarn();
        this.TimeSecond = sProject.getTimeSecond();
        this.LanguageType = sProject.getLanguageType();;
        this.RankType = sProject.getRankType();
        this.NecessaryDeveloperCount = sProject.getNecessaryDeveloperCount();
        this.progressValue = sProject.getProgressValue();
    }

    /**
     * Constructs a copy of the provided SProject object with a custom progress value.
     * Used for saving game progress with the project's current progress.
     * @param sProject
     * @param progressValue
     */
    public SProject(SProject sProject, int progressValue)
    {
        this.hasTester = sProject.HasTester();
        this.hasArchitect = sProject.HasArchitect();
        this.hasProjectManager = sProject.HasProjectManager();
        NecessaryLOC = sProject.NecessaryLOC;
        SCoinToEarn = sProject.SCoinToEarn;
        TimeSecond = sProject.TimeSecond;
        LanguageType = sProject.getLanguageType();;
        RankType = sProject.getRankType();
        NecessaryDeveloperCount = sProject.getNecessaryDeveloperCount();
        this.progressValue = progressValue;
    }

    public int getNecessaryLOC()
    {
        return NecessaryLOC;
    }

    /**
     * If an architect is assigned, it reduces the necessaryLOC by 10%.
     */
    public void setNecessaryLOC()
    {
        if(hasArchitect) this.NecessaryLOC = this.NecessaryLOC - (this.NecessaryLOC / 10);
    }

    public int getSCoinToEarn()
    {
        return SCoinToEarn;
    }

    /**
     * If a tester is assigned, it increases the ScoinToEarn by 100%.
     */
    public void setSCoinToEarn()
    {
        if(hasTester) this.SCoinToEarn = this.SCoinToEarn * 2;
    }

    public int getTimeSecond()
    {
        return this.TimeSecond;
    }

    /**
     * If a project manager is assigned, it reduces the TimeSecond by 50%.
     */
    public void setTimeSecond()
    {
        if(hasProjectManager) this.TimeSecond = this.TimeSecond - (this.TimeSecond / 2);
    }

    public String getLanguageType()
    {
        return LanguageType;
    }

    public String getRankType()
    {
        return RankType;
    }

    public int getNecessaryDeveloperCount()
    {
        return NecessaryDeveloperCount;
    }

    public boolean HasTester()
    {
        return hasTester;
    }

    public boolean HasArchitect()
    {
        return hasArchitect;
    }

    public boolean HasProjectManager()
    {
        return hasProjectManager;
    }

    public void setHasProjectManager(boolean hasProjectManager)
    {
        this.hasProjectManager = hasProjectManager;
    }

    public void setHasArchitect(boolean hasArchitect)
    {
        this.hasArchitect = hasArchitect;
    }

    public void setHasTester(boolean hasTester)
    {
        this.hasTester = hasTester;
    }

    public int getProgressValue()
    {
        return progressValue;
    }

}
