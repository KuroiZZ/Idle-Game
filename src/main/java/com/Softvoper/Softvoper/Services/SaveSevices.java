package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Save;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;


/**
 * SaveServices contains functions to deal with save model.
 * Doesn't include any variables and all functions are static.
 */
public class SaveSevices
{
    /**
     * Saves the state of the game to database from given string.
     * @param save is a string typed save of game.
     */
    public static void InsertSave(String save)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            Document WholeSaveDoc = Document.parse(save);

            try { Save save1 = new Save(WholeSaveDoc); }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            if( GetSaveWithoutDevelopers(WholeSaveDoc.get("_id", String.class)) == null )
            {
                Document EditedSaveDoc = new Document(WholeSaveDoc);
                EditedSaveDoc.remove("Developers");

                InsertOneResult rs = collection.insertOne(EditedSaveDoc);
                if(rs != null)
                {
                    System.out.println("Save başarıyla eklendi.");

                    String SaveID = rs.getInsertedId().asString().getValue();
                    DevelopersServices.InsertDeveloper(WholeSaveDoc, SaveID);
                }
                else
                {
                    System.out.println("Save ekleme işleminde bir sorun oluştu.");
                }
            }
            else
            {
                System.out.println("Bu Id'e sahip save bulunmaktadır.");
            }
        }
    }

    /**
     * Gets saves from database. Saves don't have developers' information yet.
     * @param Id Save's id in database.
     * @return Unfinished saved state of the game.
     */
    private static Document GetSaveWithoutDevelopers(String Id)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            Document filter = new Document("_id", Id);
            Document doc = collection.find(filter).first();
            if (doc != null)
            {
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

    /**
     * Gets saves from database. Developers' information are now added to Save.
     * @param Id Id of the Save in database.
     * @return Finished saved state of the game.
     */
    public static String GetSave(String Id)
    {
        Document unfinishedSave = GetSaveWithoutDevelopers(Id);
        Document DevelopersDoc = DevelopersServices.GetDeveloper(Id);

        unfinishedSave.append("developers", DevelopersDoc);
        String Save = unfinishedSave.toJson();
        return Save;
    }

    public static void DeleteSave()
    {

    }
}
