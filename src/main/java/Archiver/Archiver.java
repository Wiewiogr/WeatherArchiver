package Archiver;

import org.bson.Document;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class Archiver {
    WeatherGetter getter = new WeatherGetter();
    WeatherRepository repository = new WeatherRepository(new MongoWeatherContext());

    public void run() throws IOException {

        while (true){
            if(shouldSave()){
                saveWeather();
            }
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveWeather(){
        System.out.println("Weather saved on " + LocalDateTime.now().toString() + ".");
        try {
            repository.save(getter.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean shouldSave(){
        LocalDateTime date = LocalDateTime.now();
        if(date.getMinute() == 0 || date.getMinute() == 30) return true;
        return false;
    }

}
