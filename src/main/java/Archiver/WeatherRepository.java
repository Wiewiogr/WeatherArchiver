package Archiver;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class WeatherRepository {
    DataContext context;

    WeatherRepository(DataContext context){
        this.context = context;
    }

    public void save(String item){
        context.save(item);
    }
}
