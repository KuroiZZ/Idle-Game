package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Save;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;


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
                EditedSaveDoc.remove("developers");
                EditedSaveDoc.remove("supporter");
                EditedSaveDoc.remove("project");

                InsertOneResult rs = collection.insertOne(EditedSaveDoc);
                if(rs != null)
                {
                    System.out.println("Save başarıyla eklendi.");

                    String SaveID = rs.getInsertedId().asString().getValue();
                    DevelopersServices.InsertDeveloper(WholeSaveDoc, SaveID);
                    SupporterServices.InsertSupporter(WholeSaveDoc);
                    if(WholeSaveDoc.get("project", Document.class) != null)
                    {
                        ProjectServices.InsertProject(WholeSaveDoc);
                    }
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
     * Gets save from database. Saves don't have developers' information yet.
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
     * Gets save from database. Developers' information are now added to Save.
     * @param Id Id of the Save in database.
     * @return Finished saved state of the game.
     */
    public static String GetSave(String Id)
    {
        Document unfinishedSave = GetSaveWithoutDevelopers(Id);
        List<Document> DevelopersDoc = DevelopersServices.GetDeveloper(Id);
        List<Document> SupporterDoc = SupporterServices.GetSupporter(Id);
        List<Document> ProjectDoc = ProjectServices.GetProject(Id);

        if((unfinishedSave != null) && (DevelopersDoc != null) && (SupporterDoc != null))// These docs can't be null.
        {
            unfinishedSave.append("developers", DevelopersDoc);
            unfinishedSave.append("supporter", SupporterDoc);
            if(ProjectDoc != null)// While ProjectDoc can be null.
            {
                unfinishedSave.append("project", ProjectDoc);
            }
            String Save = unfinishedSave.toJson();
            return Save;
        }
        else
        {
            System.out.println("No matching documents found.");
            throw new NullPointerException();
        }
    }

    /**
     * Gets all documents (in this case Save documents) in a collection from database.
     * @return A string contains all saved states of the games that have been recorded so far.
     */
    public static String GetAllSaves()
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            if(collection != null)
            {
                String allSaves = "[";
                int index = 0;
                for(Document document: collection.find())
                {
                    if(index != collection.countDocuments() - 1)
                    {
                        allSaves += document.toJson() + ",";
                    }
                    else
                    {
                        allSaves += document.toJson();
                    }
                    index++;
                }
                allSaves += "]";
                return allSaves;
            }
            else
            {
                System.out.println("There is no save");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deletes a certain save and its developers from database.
     * @param Id Id of the Save to deleted in database.
     */
    public static void DeleteSave(String Id)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            if( GetSaveWithoutDevelopers(Id) != null )
            {
                DeleteResult dr = collection.deleteOne(eq("_id", Id));

                if (dr != null) {
                    System.out.println("Save başarıyla silindi.");
                    DevelopersServices.DeleteDeveloper(Id);
                    SupporterServices.DeleteSupporter(Id);
                    ProjectServices.DeleteProject(Id);
                }
                else {
                    System.out.println("Save silinirken bir sorunla karşılaşıldı.");
                }
            }
            else
            {
                System.out.println("Bu id'ye sahip save bulunmamaktadır.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Updates a certain save and its developers from database.
     * @param UpdatedSave Updated Saved statement of the game.
     */
    public static void UpdateSave(String UpdatedSave)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Save");

            Document WholeUpdatedSaveDoc = Document.parse(UpdatedSave);

            try { Save save1 = new Save(WholeUpdatedSaveDoc); }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            String UpdatedSaveId = WholeUpdatedSaveDoc.get("_id", String.class);

            if( GetSaveWithoutDevelopers(UpdatedSaveId) != null )
            {
                Document EditedUpdatedSaveDoc = new Document(WholeUpdatedSaveDoc);
                EditedUpdatedSaveDoc.remove("developers");
                EditedUpdatedSaveDoc.remove("supporter");
                EditedUpdatedSaveDoc.remove("project");

                Bson filter = eq("_id", UpdatedSaveId);
                Bson update = new Document("$set", EditedUpdatedSaveDoc);
                UpdateResult rs = collection.updateOne(filter, update);

                if(rs != null)
                {
                    System.out.println("Save başarıyla güncellendi.");

                    DevelopersServices.UpdateDeveloper(WholeUpdatedSaveDoc);
                    SupporterServices.UpdateSupporter(WholeUpdatedSaveDoc);
                    ProjectServices.UpdateProject(WholeUpdatedSaveDoc);
                }
                else
                {
                    System.out.println("Save güncelleme işleminde bir sorun oluştu.");
                }
            }
            else
            {
                System.out.println("Bu Id'e sahip save bulunmamaktadır.");
            }
        }
    }
}
