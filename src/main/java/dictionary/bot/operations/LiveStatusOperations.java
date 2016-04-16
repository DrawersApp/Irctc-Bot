package dictionary.bot.operations;

import dictionary.bot.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by harshit on 27/1/16.
 */
public class LiveStatusOperations implements Operation {

    private static final long serialVersionUID = 5335845704004340784L;
    private static DrawersBotString liveStatusString;
    private String trainNumber;
    private Date date;
    @Override
    public OutputBody makeRestCall(DrawersBotString body) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        if (validate(body)) {
            LiveStatus liveStatus = RetrofitAdapter.getRetrofitAdapter().
                    getIrctcInterface().getLiveStatus(trainNumber, df.format(date),RetrofitAdapter.getRetrofitAdapter().getApiKey());
            return liveStatus;
        }
        return null;
    }

    static  {
        List<BotStringElement> botStringElements = new ArrayList<>();
        botStringElements.add(new BotStringElement(BotStringType.U, "Live Status Train no.:"));
        botStringElements.add(new BotStringElement(BotStringType.S, "12560", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "date:"));
        botStringElements.add(new BotStringElement(BotStringType.D, "23-11-2015", null));
        liveStatusString = new DrawersBotString(botStringElements);
        OperationsManager.getOperationsManager().registerOperations(OperationsType.LIVESTATUS,
                LiveStatusOperations.class,  botStringElements.get(0).getPlaceHolder());
        DrawersBotStringHelp.getDrawersBotStringHelp().getDrawersBotStrings().add(liveStatusString);
    }

    public static DrawersBotString toDrawersBotString() {
        return liveStatusString;
    }

    private boolean validate(DrawersBotString drawersBotString) {
        if (drawersBotString.getBotStringElements() == null ||
                drawersBotString.getBotStringElements().isEmpty()
                || drawersBotString.getBotStringElements().size() != liveStatusString.getBotStringElements().size()) {
            return false;
        }
        String regex = "[0-9]+";
        for (int i = 0 ; i< drawersBotString.getBotStringElements().size() ; i++) {
            BotStringElement botStringElement = drawersBotString.getBotStringElements().get(i);
            switch (botStringElement.getType().getDesc()) {
                case "DATE":
                    String date = botStringElement.getText();
                    if (date == null || !date.matches(regex)) {
                        return false;
                    }
                    this.date = new Date(Long.valueOf(date));
                    break;
                case "UNEDITABLE":
                    if (!liveStatusString.getBotStringElements().get(i).getText().equals(botStringElement.getText())) {
                        return false;
                    }
                    break;
                case "STRING":
                    trainNumber = botStringElement.getText();
                    if (trainNumber == null) {
                        return false;
                    }
                    break;
            }
        }
        if (this.date == null || this.trainNumber == null) {
            return false;
        }
        return true;
    }


}
