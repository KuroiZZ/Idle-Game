package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Save;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.json.JsonObject;
import org.bson.types.ObjectId;

public class SaveSevices
{
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

            Document EditedSaveDoc = WholeSaveDoc;
            EditedSaveDoc.remove("developers");

            InsertOneResult rs = collection.insertOne(EditedSaveDoc);
            if(rs != null)
            {
                System.out.println("Save başarıyla eklendi.");
            }
            else
            {
                System.out.println("Save ekleme işleminde bir sorun oluştu.");
            }

            System.out.println(rs.getInsertedId());

            //DevelopersServices.InsertDeveloper(WholeSaveDoc);
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
