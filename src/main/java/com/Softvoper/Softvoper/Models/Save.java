package com.Softvoper.Softvoper.Models;

import org.bson.Document;

import java.util.List;

/** Save class' purpose is to validate the save data coming from game.
 *  A save object must have 3 field.
 */
public class Save
{
    /**
        DeveloperList is a Document type list of developers from game */
    private List<Document> DeveloperList;

    /**
        LOCCount is an int type counter of Line Of Code(LOC)*/
    private int LOCCount;

    /**
        SCoinCount is an int type counter of SCoin*/
    private int SCoinCount;

    /** Constructs from given Document object.
     *
     * @param SaveDocument is a Document type Save contents.
     */
    public Save(Document SaveDocument)
    {
        this.LOCCount = SaveDocument.get("loc_count_js", Integer.class);
        this.SCoinCount = SaveDocument.get("scoin_count_js", Integer.class);
        this.DeveloperList = SaveDocument.getList("developer", Document.class);
    }
}
