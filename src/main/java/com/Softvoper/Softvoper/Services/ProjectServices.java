package com.Softvoper.Softvoper.Services;

import com.Softvoper.Softvoper.Models.Project;
import com.Softvoper.Softvoper.Models.Supporter;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


/**
 * ProjectServices contains functions to deal with Project model.
 * Doesn't include any variables and all functions are static.
 */
public class ProjectServices
{
    /**
     * Inserts projects to database from given save document.
     * @param SaveDoc Document of saved statement of the game.
     */
    public static void InsertProject(Document SaveDoc)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Project");

            String SaveID = SaveDoc.get("_id", String.class);
            List<Document> ProjectDocLisT = GetProjectDocumentList(SaveDoc);
            AddSaveIDtoProject(ProjectDocLisT, SaveID);
            try
            {
                for(Document DocProject: ProjectDocLisT)
                {
                    List<Project> ListProject = new ArrayList<Project>();
                    Project project = new Project(DocProject);
                    ListProject.add(project);
                }
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            InsertManyResult rs = collection.insertMany(ProjectDocLisT);
            if(rs != null)
            {
                System.out.println("Project başarıyla eklendi.");
            }
            else
            {
                System.out.println("Project ekleme işleminde bir sorun oluştu.");
            }
        }
    }

    /**
     * Gets Document typed projects from database by Save ID.
     * @param SaveID Supporter's save's id.
     * @return a list of projects.
     */
    public static List<Document> GetProject(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Project");

            Document filter = new Document("SaveID", SaveID);
            FindIterable<Document> doc = collection.find(filter);
            List<Document> ProjectDocList = new ArrayList<Document>();
            if (doc != null)
            {
                for(Document project: doc)
                {
                    project.remove("_id");
                    project.remove("SaveID");
                    ProjectDocList.add(project);
                }
                return ProjectDocList;
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
     * Deletes project from database.
     * @param SaveID Supporter's save's id.
     */
    public static void DeleteProject(String SaveID)
    {
        try ( MongoClient mongoClient = MongoClients.create(Client.getUrl()) )
        {
            MongoDatabase database = mongoClient.getDatabase(Client.getDatabase());
            MongoCollection<Document> collection = database.getCollection("Project");

            DeleteResult dr = collection.deleteMany(eq("SaveID", SaveID));

            if(dr != null)
            {
                System.out.println("Project başarıyla silindi.");
            }
            else
            {
                System.out.println("Project silinirken bir sorunla karşılaşıldı.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Updates project that belongs to one specific save from database.
     * @param ProjectDoc Document of updated new projects of the save.
     */
    public static void UpdateProject(Document ProjectDoc)
    {
        String SaveID = ProjectDoc.get("_id", String.class);
        DeleteProject(SaveID);
        InsertProject(ProjectDoc);
    }

    /**
     * Gets project's Document typed list from given save document.
     * @param SaveDoc is a Document typed save.
     * @return project's Document typed list that it finds.
     */
    private static List<Document> GetProjectDocumentList(Document SaveDoc)
    {
        List<Document> ProjectDocumentList = SaveDoc.getList("project", Document.class);

        return ProjectDocumentList;
    }

    /**
     * Add save id to received project.
     * @param ProjectDocumentList is Document typed list of received project.
     * @param SaveID is a String typed Id of save from database.
     * @return save id added version of received project.
     */
    private static List<Document> AddSaveIDtoProject(List<Document> ProjectDocumentList, String SaveID)
    {
        for(Document projectDocument: ProjectDocumentList)
        {
            projectDocument.append("SaveID", SaveID);
        }

        return ProjectDocumentList;
    }
}
