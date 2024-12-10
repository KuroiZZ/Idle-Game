package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Save;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.bson.types.ObjectId;


/** SaveServices contains functions to deal with save model.
 *  Doesn't include any variables and all functions are static.
 */
public class SaveSevices
{
    /** Inserts saves to database from given save string.
     *
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

            Document EditedSaveDoc = new Document(WholeSaveDoc);
            EditedSaveDoc.remove("Developers");

            InsertOneResult rs = collection.insertOne(EditedSaveDoc);
            if(rs != null)
            {
                System.out.println("Save başarıyla eklendi.");
            }
            else
            {
                System.out.println("Save ekleme işleminde bir sorun oluştu.");
            }
            ObjectId SaveID = rs.getInsertedId().asObjectId().getValue();
            DevelopersServices.InsertDeveloper(WholeSaveDoc, SaveID);
        }
    }

    public static void FindSave(ObjectId objectId)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            Document filter = new Document("objectId", objectId);
            Document doc = collection.find(filter).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
