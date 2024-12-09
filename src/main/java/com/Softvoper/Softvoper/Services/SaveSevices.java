package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Save;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class SaveSevices
{
    public static void InsertSave(Save save)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            Document SaveDocument = save.toBSON();

            collection.insertOne(SaveDocument);
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
