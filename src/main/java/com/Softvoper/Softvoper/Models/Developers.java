package com.Softvoper.Softvoper.Models;

import org.bson.Document;
import org.bson.types.ObjectId;

/** Developers class' purpose is to validate the developers data coming from save data.
 *  A developers object must have at least 7 field.
 */
public class Developers
{
    /**
        SaveID is a String typed ID of Save in database. */
    private String SaveID;

    /**
        NofTotalEmp is an int typed number of total employees. */
    private int NofTotalEmp;

    /**
        NofProjectEmp is an int typed number of employees working on project. */
    private int NofProjectEmp;

    /**
        Price is a double typed price to hire an employee. */
    private double Price;

    /**
        LinePerSecond is an int typed line written by employee per second. */
    private double LinePerSecond;

    /**
        Type is a string typed type of programming language employee works with.*/
    private String Type;

    /**
        Rank is a string typed rank that shows experiences of employees*/
    private String Rank;

    /** Constructs from given Document object.
     *
     * @param DeveloperDocument is a Document type Developer contents.
     */
    public Developers(Document DeveloperDocument)
    {
        this.SaveID = DeveloperDocument.get("SaveID", String.class);
        this.NofTotalEmp = DeveloperDocument.get("nofTotalEmp", Integer.class);
        this.NofProjectEmp = DeveloperDocument.get("nofProjectEmp", Integer.class);
        this.Price = DeveloperDocument.get("price", Double.class);
        this.LinePerSecond = DeveloperDocument.get("linePerSecond", Double.class);
        this.Type = DeveloperDocument.get("type", String.class);
        this.Rank = DeveloperDocument.get("rank", String.class);
    }


}
