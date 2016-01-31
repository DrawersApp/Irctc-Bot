package dictionary.bot;

import com.google.gson.Gson;

/**
 * Created by harshit on 27/1/16.
 */
public interface OutputBody {
    // It just prints object in json format.
    default String toUserString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
