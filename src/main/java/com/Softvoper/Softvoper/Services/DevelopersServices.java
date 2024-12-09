package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Developers;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import com.Softvoper.Softvoper.Services.Client;
import org.bson.types.ObjectId;

import java.util.List;

public class DevelopersServices
{
    public static void Main()
    {

    }
    public static void InsertDeveloper(Developers developers)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Developers");

            Document DeveloperDocument = developers.toBSON();

            collection.insertOne(DeveloperDocument);
        }
    }
    public static void InsertDeveloperList(List<Developers> DeveloperList)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Developers");

            for (Developers developer : DeveloperList) {
                Document DeveloperDocument = developer.toBSON();
                collection.insertOne(DeveloperDocument);
            }
        }
    }
    public static void FindDeveloper(ObjectId SaveID)
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
            }
            else
            {
                System.out.println("No matching documents found.");
            }
        }
    }
}
