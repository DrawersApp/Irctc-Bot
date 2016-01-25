package dictionary.bot;

import com.google.gson.Gson;

/**
 * Created by harshit on 20/1/16.
 */
public class ChatMetaData {
    public ChatMetaData(String subType, long timestamp) {
        this.subType = subType;
        this.timestamp = timestamp;
    }

    private String subType;

    @Override
    public String toString() {
        return "dictionary.bot.ChatMetaData{" +
                "subType='" + subType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    private long timestamp;

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static ChatMetaData fromString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ChatMetaData.class);
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
