package SCoinSystem;

import Handlers.SupporterCheckbox_Handler;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SProject
{
    private int NecessaryLOC;
    private int SCoinToEarn;
    private int TimeSecond;
    private String LanguageType;
    private String RankType;
    private int NecessaryDeveloperCount;
    public boolean hasTester;
    public boolean hasArchitect;
    public boolean hasProjectManager;
    private int progressValue;

    /**
     *  Consturcts SProject object with jsonString.
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
        NecessaryLOC = necessaryLOC;
        SCoinToEarn = ScoinToEarn;
        TimeSecond = timeSecond;
        LanguageType = languageType;
        RankType = rankType;
        NecessaryDeveloperCount = necessaryDeveloperCount;
        this.hasTester = hasTester;
        this.hasArchitect = hasArchitect;
        this.hasProjectManager = hasProjectManager;
        this.progressValue = progressValue;
    }

    /**
     * This consturctor construct SProject object when craeting or loading into game.
     * @param sProject
     */
    public SProject(SProject sProject)
    {
        this.hasTester = sProject.HasTester();
        this.hasArchitect = sProject.HasArchitect();
        this.hasProjectManager = sProject.HasProjectManager();
        NecessaryLOC = sProject.getNecessaryLOC();
        SCoinToEarn = sProject.getSCoinToEarn();
        TimeSecond = sProject.getTimeSecond();
        LanguageType = sProject.getLanguageType();;
        RankType = sProject.getRankType();
        NecessaryDeveloperCount = sProject.getNecessaryDeveloperCount();
        this.progressValue = sProject.getProgressValue();
    }

    /**
     * This contructor construct SProject object when saving game.
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
        if(hasArchitect)
        {
            return NecessaryLOC - (NecessaryLOC / 10);
        }
        else
        {
            return NecessaryLOC;
        }
    }

    public int getSCoinToEarn()
    {
        if(hasTester)
        {
            return SCoinToEarn * 2;
        }
        else
        {
            return SCoinToEarn;
        }
    }

    public int getTimeSecond()
    {
        if(hasProjectManager)
        {
            return TimeSecond - (TimeSecond / 2);
        }
        else
        {
            return TimeSecond;
        }
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

    public void setProgressValue(int progressValue)
    {
        this.progressValue = progressValue;
    }
}
