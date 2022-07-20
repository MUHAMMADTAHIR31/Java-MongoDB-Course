/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.mongodb.example;

import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Dell
 */
public class MongoCreateSingleDocument {
    
    public static void main(String[] args) {

        try{

            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("javaguides");

            try {
                database.createCollection("users");
                System.out.println("Collection created successfully");
            } catch (MongoCommandException e) {
                database.getCollection("users").drop();
            }

            
            MongoCollection < Document > collection = database.getCollection("users");

            Document d1 = new Document("_id", 6);
            d1.append("_firstName", "tahir");
            d1.append("_lastName", "korejo");
            collection.insertOne(d1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
    
