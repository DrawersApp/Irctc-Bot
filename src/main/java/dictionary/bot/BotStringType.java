package dictionary.bot;

/**
 * Created by harshit on 25/1/16.
 */
public enum  BotStringType {
    D("DATE"),
    L("LOCATION"),
    T("TIME"),
    S("String"),
    U("UNEDITABLE");

    private String desc;
    BotStringType(String desc) {
        this.desc = desc;
    }
}
