package com.Softvoper.Softvoper.Models;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.boot.jackson.JsonComponent;

import javax.sound.sampled.Line;

public class Developers
{
    private ObjectId SaveID;
    private int NofTotalEmp; //Number of total employees (NTE)
    private int NofProjectEmp; //Number of employees working on project (NPE)
    private int NofNonProjectEmp; //Number of employees not working on project (NNPE)
    private float Price; //price to hire an employee
    private int LinePerSecond; //line per second (LPS)
    private int NofTotalLOC; //Number of total loc written by NonProject employee (NTL)
    private String Type;
    private String Rank;

    public Developers(ObjectId SaveID, int NofTotalEmp, int NofProjectEmp, float Price, int LinePerSecond, String Type, String Rank)
    {
        this.SaveID = SaveID;
        this.NofTotalEmp = NofTotalEmp;
        this.NofProjectEmp = NofProjectEmp;
        this.NofNonProjectEmp = NofTotalEmp - NofProjectEmp;
        this.Price = Price;
        this.LinePerSecond = LinePerSecond;
        this.NofTotalLOC = NofNonProjectEmp * LinePerSecond;
        this.Type = Type;
        this.Rank = Rank;
    }

    public Developers(Document BSONObject)
    {
        this.SaveID = BSONObject.get("SaveID", ObjectId.class);
        this.NofTotalEmp = BSONObject.get("NofTotalEmp", Integer.class);
        this.NofProjectEmp = BSONObject.get("NofProjectEmp", Integer.class);
        this.Price = BSONObject.get("Price", Float.class);
        this.LinePerSecond = BSONObject.get("LinePerSecond", Integer.class);
        this.Type = BSONObject.get("Type", String.class);
        this.Rank = BSONObject.get("Rank", String.class);
    }

    public Document toBSON()
    {
        Document BSONObject = new Document("SaveID", this.SaveID)
                                .append("NofTotalEmp",this.NofTotalEmp)
                                .append("NofProjectEmp", this.NofProjectEmp)
                                .append("Price", this.Price)
                                .append("LinePerSecond", this.LinePerSecond)
                                .append("Type", this.Type)
                                .append("Rank", this.Rank);

        return BSONObject;
    }
}
