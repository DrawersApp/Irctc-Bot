package dictionary.bot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshit on 27/1/16.
 */
public class PNRStatusOperation implements Operation {

    public static DrawersBotString getPnrBotString() {
        return pnrBotString;
    }

    private static DrawersBotString pnrBotString;

    private String pnr;

    static  {
        List<BotStringElement> botStringElements = new ArrayList<>();
        botStringElements.add(new BotStringElement(BotStringType.U, "PNR NO."));
        botStringElements.add(new BotStringElement(BotStringType.S, "1234567890", null));
        pnrBotString = new DrawersBotString(botStringElements);
    }

    @Override
    public OutputBody makeRestCall(DrawersBotString body) {
        if (validate(body)) {
            PNRStatus pnrStatus = RetrofitAdapter.getRetrofitAdapter().getIrctcInterface().
                    getPnrStatus(pnr, RetrofitAdapter.getRetrofitAdapter().getApiKey());
            return pnrStatus;
        }
        return null;
    }

    @Override
    public String getString(OutputBody outputBody) {
        return null;
    }

    private boolean validate(DrawersBotString drawersBotString) {
        if (drawersBotString.getBotStringElements() == null ||
                drawersBotString.getBotStringElements().isEmpty()
                || drawersBotString.getBotStringElements().size() != pnrBotString.getBotStringElements().size()) {
            return false;
        }
        for (int i = 0 ; i< drawersBotString.getBotStringElements().size() ; i++) {
            BotStringElement botStringElement = drawersBotString.getBotStringElements().get(i);
            switch (botStringElement.getType().getDesc()) {
                case "UNEDITABLE":
                    if (!pnrBotString.getBotStringElements().get(i).getText().equals(botStringElement.getText())) {
                        return false;
                    }
                    break;
                case "String":
                    pnr = botStringElement.getText();
                    if (pnr == null) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}