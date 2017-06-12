package Archiver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class MongoWeatherContext implements DataContext {
    private MongoClient mongoClient;
    private MongoDatabase db;
    private String collectionName = "weatherTest";

    MongoWeatherContext() {
        try {
            mongoClient = new MongoClient("85.255.7.108", 27017);
            db = mongoClient.getDatabase("test");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private void appendCurrentDate(Document document){
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusHours(2);
        Document date = new Document();
        date.append("year", dateTime.getYear());
        date.append("month", dateTime.getMonthValue());
        date.append("day", dateTime.getDayOfMonth());
        date.append("hour", dateTime.getHour());
        date.append("minutes", dateTime.getMinute());
        document.append("date", date);
    }

    public void save(String item) {
        JsonStringToMongoDocumentConverter converter = new JsonStringToMongoDocumentConverter();
        Document document = converter.convert(item);
        appendCurrentDate(document);

        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertOne(document);
    }
}
