/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmongodb.java.mongodb.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Dell
 */
public class ConnectToDB {
    
    public static void main(String args[]) {

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                

            MongoDatabase database = mongoClient.getDatabase("javaguides");

           //---------- Creating Collection -------------------------//  
            MongoCollection<Document> table = database.getCollection("employee");  
            //---------- Creating Document ---------------------------//    
            Document doc = new Document("name", "Peter John");  
            doc.append("id",12);  
            //----------- Inserting Data ------------------------------//  
            table.insertOne(doc);  

            for (String name: database.listCollectionNames()) {

                System.out.println(name);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
