package Archiver;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class MongoWeatherContextTest {
    @Test
    public void add_score() throws IOException {
        DataContext dataContext = new MongoWeatherContext();
        WeatherGetter getter = new WeatherGetter();
        dataContext.save(getter.get());
    }

}