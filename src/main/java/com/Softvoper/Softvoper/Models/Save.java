package com.Softvoper.Softvoper.Models;

import org.bson.Document;

import java.util.List;

public class Save
{
    private List<Developers> DeveloperList;
    private int LOCCount;
    private int SCoinCount;

    public Save(List<Developers> DeveloperList, int LOCCount, int SCoinCount)
    {
        this.DeveloperList = DeveloperList;
        this.LOCCount = LOCCount;
        this.SCoinCount = SCoinCount;
    }
    public Document toBSON()
    {
        Document BSONObject = new Document("DeveloperList", this.DeveloperList)
                                .append("LOCCount", this.LOCCount)
                                .append("SCoinCount", this.SCoinCount);

        return BSONObject;
    }
}
