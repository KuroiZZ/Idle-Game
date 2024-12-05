package SCoinSystem;

public class SProject
{
    public int NecessaryLOC;
    public int SCoinToEarn;
    public int TimeSecond;
    public String LanguageType;
    public String RankType;
    public int NecessaryDeveloperCount;

    public SProject(int necessaryLOC, int SCoinToEarn, int timeSecond, String languageType, String rankType, int necessaryDeveloperCount)
    {
        NecessaryLOC = necessaryLOC;
        this.SCoinToEarn = SCoinToEarn;
        TimeSecond = timeSecond;
        LanguageType = languageType;
        RankType = rankType;
        NecessaryDeveloperCount = necessaryDeveloperCount;
    }

    public int getNecessaryLOC()
    {
        return NecessaryLOC;
    }

    public void setNecessaryLOC(int necessaryLOC)
    {
        NecessaryLOC = necessaryLOC;
    }

    public int getSCoinToEarn()
    {
        return SCoinToEarn;
    }

    public void setSCoinToEarn(int SCoinToEarn)
    {
        this.SCoinToEarn = SCoinToEarn;
    }

    public int getTimeSecond()
    {
        return TimeSecond;
    }

    public void setTimeSecond(int timeSecond)
    {
        TimeSecond = timeSecond;
    }

    public String getLanguageType()
    {
        return LanguageType;
    }

    public void setLanguageType(String languageType)
    {
        LanguageType = languageType;
    }

    public String getRankType()
    {
        return RankType;
    }

    public void setRankType(String rankType)
    {
        RankType = rankType;
    }

    public int getNecessaryDeveloperCount()
    {
        return NecessaryDeveloperCount;
    }

    public void setNecessaryDeveloperCount(int necessaryDeveloperCount)
    {
        NecessaryDeveloperCount = necessaryDeveloperCount;
    }


}
