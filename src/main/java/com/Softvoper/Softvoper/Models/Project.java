package com.Softvoper.Softvoper.Models;

import org.bson.Document;

/**
 * Project class' purpose is to validate the project's data coming from save data.
 * A project object must have at least 10 field.
 */
public class Project
{
    /**
     * SaveID is a String typed ID of Save in database.
     */
    private String SaveID;

    /**
     * Necessary LOC number to create/develop a project.
     */
    private int NecessaryLOC;

    /**
     * Number of SCoin that will be earned when the project is over.
     */
    private int SCoinToEarn;

    /**
     * Project's finish time in seconds.
     */
    private int TimeSecond;

    /**
     * The main programming language used in project.
     */
    private String LanguageType;

    /**
     * Defines how hard the project is. Can be Beginner, Intermediate or Advanced.
     */
    private String RankType;

    /**
     * Necessary developer number to create/develop a project.
     */
    private int NecessaryDeveloperCount;

    /**
     * Specifies whether the project has a tester employee or not.
     */
    private boolean hasTester;

    /**
     * Specifies whether the project has a software architect employee or not.
     */
    private boolean hasArchitect;

    /**
     * Specifies whether the project has a project manager employee or not.
     */
    private boolean hasProjectManager;


    /**
     * Constructs project from given Document object.
     * @param ProjeDoc Project's data.
     */
    public Project(Document ProjeDoc)
    {
        this.SaveID = ProjeDoc.get("SaveID", String.class);
        this.NecessaryLOC = ProjeDoc.get("NecessaryLOC", Integer.class);
        this.SCoinToEarn = ProjeDoc.get("SCoinToEarn", Integer.class);
        this.TimeSecond = ProjeDoc.get("TimeSecond", Integer.class);
        this.LanguageType = ProjeDoc.get("LanguageType", String.class);
        this.RankType = ProjeDoc.get("RankType", String.class);
        this.NecessaryDeveloperCount = ProjeDoc.get("NecessaryDeveloperCount", Integer.class);
        this.hasTester = ProjeDoc.get("hasTester", Boolean.class);
        this.hasArchitect = ProjeDoc.get("hasArchitect", Boolean.class);
        this.hasProjectManager = ProjeDoc.get("hasProjectManager", Boolean.class);
    }
}
