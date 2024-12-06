package SCoinSystem;

public class SProject
{
    private int NecessaryLOC;
    private int SCoinToEarn;
    private int TimeSecond;
    private String LanguageType;
    private String RankType;
    private int NecessaryDeveloperCount;

    public SProject(int necessaryLOC, int ScoinToEarn, int timeSecond, String languageType, String rankType, int necessaryDeveloperCount)
    {
        NecessaryLOC = necessaryLOC;
        SCoinToEarn = ScoinToEarn;
        TimeSecond = timeSecond;
        LanguageType = languageType;
        RankType = rankType;
        NecessaryDeveloperCount = necessaryDeveloperCount;
    }

    public int getNecessaryLOC()
    {
        return NecessaryLOC;
    }

    public int getSCoinToEarn()
    {
        return SCoinToEarn;
    }

    public int getTimeSecond()
    {
        return TimeSecond;
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




}
