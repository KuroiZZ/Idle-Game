package com.Softvoper.Softvoper.Models;

import org.bson.Document;

/**
 * Supporter class' purpose is to validate the supporter employee data coming from game.
 * A supporter object must have 5 field.
 */
public class Supporter
{
    /**
     SaveID is a String typed ID of Save in database. */
    private String SaveID;

    /**
     * Number of total hired employee.
     */
    private int NofTotalEmp;

    /**
     * Number of employee working on a project.
     */
    private int NofProjectEmp;

    /**
     * Number of employee not working on a project.
     */
    private int NofNonProjectEmp;

    /**
     * Price to hire an employee.
     */
    private float Price;

    /**
     * Type of the support employee.
     */
    private String Type;

    /**
     * Constructs from given Document object.
     * @param SupporterDocument
     */
    public Supporter(Document SupporterDocument)
    {
        this.SaveID = SupporterDocument.get("SaveID", String.class);
        this.NofTotalEmp = SupporterDocument.get("noftotalemp", Integer.class);
        this.NofProjectEmp = SupporterDocument.get("nofprojectemp", Integer.class);
        this.NofNonProjectEmp = SupporterDocument.get("nofnonprojectemp", Integer.class);
        this.Price = SupporterDocument.get("price", Float.class);
        this.Type = SupporterDocument.get("type", String.class);
    }
}