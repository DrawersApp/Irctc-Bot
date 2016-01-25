package dictionary.bot;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by harshit on 20/1/16.
 */
public interface DictionaryInterface {

    @Headers({
            "Accept: application/json",
            "X-Mashape-Key: YgXFx8fyJemshaRWbzMMcZ21Vcpqp1CE4jAjsnAFa0RBW99WmV"
    })
    @GET("/define")
    Meaning getMeaning(@Query("word") String word);
}
