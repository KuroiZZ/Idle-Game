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
    private boolean hasTester;
    private boolean hasArchitect;
    private boolean hasProjectManager;
    private int progressValue;

    public SProject(int necessaryLOC, int ScoinToEarn, int timeSecond, String languageType, String rankType,
                    int necessaryDeveloperCount, boolean hasTester, boolean hasArchitect, boolean hasProjectManager)
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
        this.progressValue = 0;
    }

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
