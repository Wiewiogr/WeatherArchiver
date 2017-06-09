package Archiver;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.bson.Document;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class JsonStringToMongoDocumentConverter {

    public Document convert(String stringJson){
        JsonObject json = Json.parse(stringJson).asObject();

        Document document = new Document();

        String main = json.get("weather").asArray().get(0).asObject().get("main").asString();
        String description = json.get("weather").asArray().get(0).asObject().get("description").asString();
        String icon = json.get("weather").asArray().get(0).asObject().get("icon").asString();
        int temperature = json.get("main").asObject().get("temp").asInt();
        int humidity = json.get("main").asObject().get("humidity").asInt();
        int pressure = json.get("main").asObject().get("pressure").asInt();
        int visibilty = json.get("visibility").asInt();
        double windSpeed = json.get("wind").asObject().get("speed").asDouble();

        int windDegree = -1;
        if(json.get("wind").asObject().get("deg") != null) {
            windDegree = json.get("wind").asObject()
                    .get("deg")
                    .asInt();
        }

        int clouds = json.get("clouds").asObject().get("all").asInt();

        document.append("main", main);
        document.append("description", description);
        document.append("icon", icon);
        document.append("temperature", temperature);
        document.append("humidity", humidity);
        document.append("pressure", pressure);
        document.append("visibilty", visibilty);
        document.append("windSpeed", windSpeed);
        document.append("clouds", clouds);
        document.append("windDegree", windDegree);

        return document;
    }
}
