package com.Softvoper.Softvoper.Models;

import org.bson.Document;

import java.util.List;

/**
 * Save class' purpose is to validate the save data coming from game.
 * A save object must have 6 field.
 */
public class Save
{
    /**
        Save's String typed id in database. */
    private String Id;

    /**
        Save's String typed name. */
    private String Name;

    /**
        DeveloperList is a Document type list of developers from game */
    private List<Document> DeveloperList;

    /**
     * Document type list of supporter employees player hired in game.
     */
    private List<Document> SupporterList;

    /**
        LOCCount is an int type counter of Line Of Code(LOC)*/
    private int LOCCount;

    /**
        SCoinCount is an int type counter of SCoin*/
    private int SCoinCount;

    /**
     * Constructs from given Document object.
     * @param SaveDocument is a Document type Save contents.
     */
    public Save(Document SaveDocument)
    {
        this.Id = SaveDocument.get("_id", String.class);
        this.Name = SaveDocument.get("name", String.class);
        this.LOCCount = SaveDocument.get("loc_count_js", Integer.class);
        this.SCoinCount = SaveDocument.get("scoin_count_js", Integer.class);
        this.DeveloperList = SaveDocument.getList("developer", Document.class);
        this.SupporterList = SaveDocument.getList("supporter", Document.class);
    }
}
