package dictionary.bot;

/**
 * Created by harshit on 25/1/16.
 */
public class BotStringElement {
    public BotStringType getType() {
        return type;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public String getText() {
        return text;
    }

    private BotStringType type;
    private String placeHolder;
    private String text;

    public BotStringElement(BotStringType type, String placeHolder, String text) {
        this.type = type;
        this.placeHolder = placeHolder;
        this.text = text;
    }

    public BotStringElement(BotStringType type, String text) {
        this.type = type;
        this.text = text;
        this.placeHolder = text;
    }
}
