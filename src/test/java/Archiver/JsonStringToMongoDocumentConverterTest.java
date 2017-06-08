package Archiver;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class JsonStringToMongoDocumentConverterTest {
    String json = "{\"coord\":{\"lon\":19.94,\"lat\":50.06},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"base\":\"stations\",\"main\":{\"temp\":18,\"pressure\":1021,\"humidity\":48,\"temp_min\":18,\"temp_max\":18},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":240},\"clouds\":{\"all\":20},\"dt\":1496908800,\"sys\":{\"type\":1,\"id\":5352,\"message\":0.004,\"country\":\"PL\",\"sunrise\":1496889102,\"sunset\":1496947649},\"id\":3085041,\"name\":\"Śródmieście\",\"cod\":200}";
    JsonStringToMongoDocumentConverter converter = new JsonStringToMongoDocumentConverter();


    @Test
    public void convert() throws Exception {
        Document document = converter.convert(json);

        Assert.assertEquals(document.get("main"), "Clouds");
        Assert.assertEquals(document.get("description"), "few clouds");
        Assert.assertEquals(document.get("icon"), "02d");
        Assert.assertEquals(document.get("temperature"), 18);
        Assert.assertEquals(document.get("humidity"), 48);
        Assert.assertEquals(document.get("pressure"), 1021);
        Assert.assertEquals(document.get("visibilty"), 10000);
        Assert.assertEquals(document.get("windSpeed"), 3.6);
        Assert.assertEquals(document.get("windDegree"), 240);
        Assert.assertEquals(document.get("clouds"), 20);
    }

}