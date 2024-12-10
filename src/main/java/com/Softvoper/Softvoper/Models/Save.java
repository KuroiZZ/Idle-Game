package com.Softvoper.Softvoper.Models;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public class Save
{
    private List<Document> DeveloperList;
    private int LOCCount;
    private int SCoinCount;

    /*
    public Save(List<Developers> DeveloperList, int LOCCount, int SCoinCount)
    {
        this.DeveloperList = DeveloperList;
        this.LOCCount = LOCCount;
        this.SCoinCount = SCoinCount;
    }*/

    public Save(Document BSONObject)
    {
        this.LOCCount = BSONObject.get("loc_count_js", Integer.class);
        this.SCoinCount = BSONObject.get("scoin_count_js", Integer.class);
        this.DeveloperList = BSONObject.getList("developer", Document.class);
    }
    /*
    public Document toBSON()
    {
        Document BSONObject = new Document("DeveloperList", this.DeveloperList)
                                .append("LOCCount", this.LOCCount)
                                .append("SCoinCount", this.SCoinCount);

        return BSONObject;
    }*/
}
