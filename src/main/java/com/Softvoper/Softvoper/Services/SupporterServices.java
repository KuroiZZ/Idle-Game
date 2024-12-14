package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Developers;
import com.Softvoper.Softvoper.Models.Supporter;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * SupporterServices contains functions to deal with Supporter model.
 * Doesn't include any variables of its own and all functions are static.
 */
public class SupporterServices
{
    /**
     * Inserts supporter to database from given save document.
     * @param SaveDoc Document of saved statement of the game.
     */
    public static void InsertSupporter(Document SaveDoc)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Supporter");

            String SaveID = SaveDoc.get("_id", String.class);
            List<Document> SupporterDocLisT = GetSupporterDocumentList(SaveDoc);
            AddSaveIDtoSupporter(SupporterDocLisT, SaveID);
            try
            {
                for(Document DocSupporter: SupporterDocLisT)
                {
                    List<Supporter> ListSupporter = new ArrayList<Supporter>();
                    Supporter supporter = new Supporter(DocSupporter);
                    ListSupporter.add(supporter);
                }
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            InsertManyResult rs = collection.insertMany(SupporterDocLisT);
            if(rs != null)
            {
                System.out.println("Supporter başarıyla eklendi.");
            }
            else
            {
                System.out.println("Supporter ekleme işleminde bir sorun oluştu.");
            }
        }
    }

    /**
     * Gets Document typed supporter from database by Save ID.
     * @param SaveID Supporter's save's id.
     * @return a list of supporter.
     */
    public static List<Document> GetSupporter(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Supporter");

            Document filter = new Document("SaveID", SaveID);
            FindIterable<Document> doc = collection.find(filter);
            List<Document> SupporterDocList = new ArrayList<Document>();
            if (doc != null)
            {
                for(Document supporter: doc)
                {
                    supporter.remove("_id");
                    supporter.remove("SaveID");
                    SupporterDocList.add(supporter);
                }
                return SupporterDocList;
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
     * Deletes supporter from database.
     * @param SaveID Supporter's save's id.
     */
    public static void DeleteSupporter(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Supporter");

            DeleteResult dr = collection.deleteMany(eq("SaveID", SaveID));

            if(dr != null)
            {
                System.out.println("Supporter başarıyla silindi.");
            }
            else
            {
                System.out.println("Supporter silinirken bir sorunla karşılaşıldı.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Updates supporter that belongs to one specific save from database.
     * @param SupporterDoc Document of updated new supporter of the save.
     */
    public static void UpdateSupporter(Document SupporterDoc)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Supporter");

            String SaveID = SupporterDoc.get("_id", String.class);

            List<Document> SupporterDocLisT = GetSupporterDocumentList(SupporterDoc);
            List<Document> NewSupporterDocLisT = AddSaveIDtoSupporter(SupporterDocLisT, SaveID);
            try
            {
                for(Document DocSupporter: NewSupporterDocLisT)
                {
                    List<Supporter> ListSupporter = new ArrayList<Supporter>();
                    Supporter supporter = new Supporter(DocSupporter);
                    ListSupporter.add(supporter);
                }
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            DeleteSupporter(SaveID);
            InsertSupporter(SupporterDoc);
        }
    }

    /**
     * Gets supporter's Document typed list from given save document.
     * @param SaveDoc is a Document typed save.
     * @return supporter's Document typed list that it finds.
     */
    private static List<Document> GetSupporterDocumentList(Document SaveDoc)
    {
        List<Document> SupporterDocumentList = SaveDoc.getList("supporter", Document.class);

        return SupporterDocumentList;
    }

    /**
     * Add save id to received supporter.
     * @param SupporterDocumentList is Document typed list of received supporter.
     * @param SaveID is a String typed Id of save from database.
     * @return save id added version of received supporter.
     */
    private static List<Document> AddSaveIDtoSupporter(List<Document> SupporterDocumentList, String SaveID)
    {
        for(Document supporterDocument: SupporterDocumentList)
        {
            supporterDocument.append("SaveID", SaveID);
        }

        return SupporterDocumentList;
    }
}
