package dictionary.bot;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by harshit on 25/1/16.
 */
public class DrawersBotString {
    public List<BotStringElement> getBotStringElements() {
        return botStringElements;
    }

    private List<BotStringElement> botStringElements;

    public DrawersBotString(List<BotStringElement> botStringElements) {
        this.botStringElements = botStringElements;
    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static DrawersBotString fromString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DrawersBotString.class);
    }
}
