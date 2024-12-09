package com.Softvoper.Softvoper.Services;

public class Client
{
    private static String url = "mongodb://localhost:27017";

    private static String database = "Idlegame_API";

    public static String getUrl()
    {
        return url;
    }

    public static String getDatabase()
    {
        return database;
    }
}
