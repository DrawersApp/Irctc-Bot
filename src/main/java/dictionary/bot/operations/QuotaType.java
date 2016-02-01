package dictionary.bot.operations;

/**
 * Created by harshit on 1/2/16.
 */
public enum QuotaType {
    GENERAL("GN"),
    TATKAL("CK");

    private String type;

    QuotaType(String type) {
        this.type = type;
    }

}
