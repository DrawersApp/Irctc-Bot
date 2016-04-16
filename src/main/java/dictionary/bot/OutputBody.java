package dictionary.bot;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by harshit on 27/1/16.
 */
public interface OutputBody extends Serializable {

    // It just prints object in json format.
    default String toUserString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
