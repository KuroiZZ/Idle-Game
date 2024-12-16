package com.Softvoper.Softvoper.Services;
import com.Softvoper.Softvoper.Models.Developers;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * DevelopersServices contains functions to deal with Developers model.
 * Doesn't include any variables and all functions are static.
 */
public class DevelopersServices
{
    /**
     * Inserts developers to database from given save document.
     * @param SaveDoc is a Document typed save.
     * @param SaveID is a ObjectId typed Id of save from database.
     */
    public static void InsertDeveloper(Document SaveDoc, String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Developers");


            List<Document> DeveloperDocLisT = GetDeveloperDocumentList(SaveDoc);
            AddSaveIDtoDevelopers(DeveloperDocLisT, SaveID);
            try
            {
                for(Document DocDeveloper: DeveloperDocLisT)
                {
                    List<Developers> ListDevelopers = new ArrayList<Developers>();
                    Developers developer = new Developers(DocDeveloper);
                    ListDevelopers.add(developer);
                }
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            InsertManyResult rs = collection.insertMany(DeveloperDocLisT);
            if(rs != null)
            {
                System.out.println("Developers başarıyla eklendi.");
            }
            else
            {
                System.out.println("Developers ekleme işleminde bir sorun oluştu.");
            }
        }
    }

    /**
     * Gets Document typed developers from database by Save ID.
     * @param SaveID Save's Id of the developer.
     * @return developers
     */
    public static List<Document> GetDeveloper(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Developers");

            Document filter = new Document("SaveID", SaveID);
            FindIterable<Document> doc = collection.find(filter);
            List<Document> DeveloperDocList = new ArrayList<Document>();
            if (doc != null)
            {
                for(Document developer: doc)
                {
                    developer.remove("_id");
                    developer.remove("SaveID");
                    DeveloperDocList.add(developer);
                }
                return DeveloperDocList;
            }
            else
            {
                System.out.println("No matching documents found.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deletes Developers from database.
     * @param SaveID Save's Id of the developer.
     */
    public static void DeleteDeveloper(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Developers");

            DeleteResult dr = collection.deleteMany(eq("SaveID", SaveID));

            if(dr != null)
            {
                System.out.println("Developers başarıyla silindi.");
            }
            else
            {
                System.out.println("Developers silinirken bir sorunla karşılaşıldı.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Updates developers that belongs to one specific save from database.
     * @param DeveloperDoc Updated new developers of the save.
     */
    public static void UpdateDeveloper(Document DeveloperDoc)
    {
        String SaveID = DeveloperDoc.get("_id", String.class);

        DeleteDeveloper(SaveID);
        InsertDeveloper(DeveloperDoc, SaveID);
    }

    /**
     * Gets developer's Document typed list from given save document.
     * @param SaveDoc is a Document typed save.
     * @return developer's Document typed list that it finds.
     */
    private static List<Document> GetDeveloperDocumentList(Document SaveDoc)
    {
        List<Document> DeveloperDocumentList = SaveDoc.getList("developers", Document.class);

        return DeveloperDocumentList;
    }


    /**
     * Add save id to received developers.
     * @param DeveloperDocumentList is Document typed list of received developers.
     * @param SaveID is a ObjectId typed Id of save from database.
     * @return save id added version of received developers.
     */
    private static List<Document> AddSaveIDtoDevelopers(List<Document> DeveloperDocumentList, String SaveID)
    {
        for(Document developerDocument: DeveloperDocumentList)
        {
            developerDocument.append("SaveID", SaveID);
        }

        return DeveloperDocumentList;
    }
}
