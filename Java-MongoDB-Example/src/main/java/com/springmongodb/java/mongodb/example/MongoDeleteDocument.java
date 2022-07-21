/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.mongodb.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Dell
 */
public class MongoDeleteDocument {
    
      public static void main(String[] args) {
        // Creating a Mongo client
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            // Accessing the database
            MongoDatabase database = mongoClient.getDatabase("javaguides");

            // Retieving a collection
            MongoCollection < Document > collection = database.getCollection("users");

            // Deleting the documents
            collection.deleteOne(Filters.eq("_id", 6));
            System.out.println("Document deleted successfully...");

            MongoCursor < Document > cur = collection.find().iterator();

            while (cur.hasNext()) {
                
                Document doc = cur.next();
                List users = new ArrayList < > (doc.values());

                System.out.printf("%s: %s%n", users.get(1), users.get(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
}      
