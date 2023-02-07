package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class Main {
    public static void main(String[] args) {
        // Crear una conexión a MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        // Seleccionar la base de datos y la colección
        MongoDatabase database = mongoClient.getDatabase("agenda");
        MongoCollection<Document> collection = database.getCollection("contactos");
        // Crear un nuevo contacto
        Document contacto = new Document("nombre", "Juan")
                .append("telefono", "696552113");
        collection.insertOne(contacto);
        // Recuperar todos los contactos
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
        // Actualizar un contacto
        Document query = new Document("nombre", "Juan");
        Document update = new Document("$set", new Document("telefono", "2134213421")); collection.updateMany(query, update);
        // Eliminar un contacto
        collection.deleteMany(new Document("nombre", "Juan"));
        // Cerrar la conexión*/
        mongoClient.close();
    }
}
