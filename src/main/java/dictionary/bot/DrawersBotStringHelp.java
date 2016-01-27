package dictionary.bot;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Help send when user connects for the first time.
 */
public class DrawersBotStringHelp {
    private List<DrawersBotString> drawersBotStrings;

    public static DrawersBotStringHelp getDrawersBotStringHelp() {
        return drawersBotStringHelp;
    }

    private static DrawersBotStringHelp drawersBotStringHelp = new DrawersBotStringHelp();

    private DrawersBotStringHelp() {
        drawersBotStrings = new ArrayList<>();
        drawersBotStrings.add(PNRStatusOperation.getPnrBotString());
        drawersBotStrings.add(LiveStatusOperations.toDrawersBotString());

    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static DrawersBotStringHelp fromString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DrawersBotStringHelp.class);
    }
}
