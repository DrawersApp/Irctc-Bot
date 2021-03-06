package dictionary.bot;

/**
 * Created by harshit on 25/1/16.
 */
public enum  BotStringType {
    D("DATE"),
    L("LOCATION"),
    T("TIME"),
    S("STRING"),
    U("UNEDITABLE"),
    LI("LIST"),
    I("INTEGER");

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;
    BotStringType(String desc) {
        this.desc = desc;
    }
}
