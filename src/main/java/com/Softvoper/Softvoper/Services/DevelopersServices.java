package com.Softvoper.Softvoper.Services;
import com.Softvoper.Softvoper.Models.Developers;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/** DevelopersServices contains functions to deal with Developers model.
 *  Doesn't include any variables and all functions are static.
 */
public class DevelopersServices
{
    /** Inserts developers to database from given save document.
     *
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
                    System.out.println(DocDeveloper);
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

    /** Gets Document typed developers from database by Save ID.
     *
     * @param SaveID Save's Id of the developer.
     * @return developers
     */
    public static Document GetDeveloper(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Developers");

            Document filter = new Document("SaveID", SaveID);
            Document doc = collection.find(filter).first();
            if (doc != null)
            {
                System.out.println(doc.toJson());
                return doc;
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

    /** Gets developer's Document typed list from given save document.
     *
     * @param SaveDoc is a Document typed save.
     * @return developer's Document typed list that it finds.
     */
    private static List<Document> GetDeveloperDocumentList(Document SaveDoc)
    {
        List<Document> DeveloperDocumentList = SaveDoc.getList("developers", Document.class);

        return DeveloperDocumentList;
    }


    /** Add save id to received developers.
     *
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
