package Archiver;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by wiewiogr on 08.06.17.
 */
public class WeatherGetter {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    final String url = "http://api.openweathermap.org/data/2.5/weather?q=Cracow,pl&appid=27f275b70383b5e64a2c338f57d51e72&units=metric";

    public String get() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
