package dictionary.bot.operations;

import dictionary.bot.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by harshit on 27/1/16.
 */
public class TrainBetweenStationOperations implements Operation {

    private String sourceCode;
    private String destCode;
    private Date date;
    @Override
    public OutputBody makeRestCall(DrawersBotString body) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM");
        if (validate(body)) {
            Trains trains = RetrofitAdapter.getRetrofitAdapter().getIrctcInterface().getTrainBetweenStations(sourceCode,
                    destCode, df.format(date), RetrofitAdapter.getRetrofitAdapter().getApiKey());
            return trains;
        }
        return null;
    }

    public static DrawersBotString getTrainBetweenStationsString() {
        return trainBetweenStationsString;
    }

    private static final DrawersBotString trainBetweenStationsString;

    static  {
        List<BotStringElement> botStringElements = new ArrayList<>();
        botStringElements.add(new BotStringElement(BotStringType.U, "Train from:"));
        botStringElements.add(new BotStringElement(BotStringType.S, "GKP", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "to:"));
        botStringElements.add(new BotStringElement(BotStringType.S, "LKO", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "date:"));
        botStringElements.add(new BotStringElement(BotStringType.D, "23-11-2015", null));
        trainBetweenStationsString = new DrawersBotString(botStringElements);
        OperationsManager.getOperationsManager().registerOperations(OperationsType.TRAIN, TrainBetweenStationOperations.class,
                botStringElements.get(0).getPlaceHolder());
    }

    private boolean validate(DrawersBotString drawersBotString) {
        if (drawersBotString.getBotStringElements() == null ||
                drawersBotString.getBotStringElements().isEmpty()
                || drawersBotString.getBotStringElements().size() != trainBetweenStationsString.getBotStringElements().size()) {
            return false;
        }
        String regex = "[0-9]+";
        for (int i = 0 ; i< drawersBotString.getBotStringElements().size() ; i++) {
            BotStringElement botStringElement = drawersBotString.getBotStringElements().get(i);
            switch (botStringElement.getType().getDesc()) {
                case "UNEDITABLE":
                    if (!trainBetweenStationsString.getBotStringElements().get(i).getText().equals(botStringElement.getText())) {
                        return false;
                    }
                    break;
                case "STRING":
                    if (i == 1) {
                        sourceCode = botStringElement.getText();
                    } else {
                        destCode = botStringElement.getText();
                    }

                    if (sourceCode == null || destCode == null) {
                        return false;
                    }
                    break;
                case "DATE":
                    String date = botStringElement.getText();
                    if (date == null || !date.matches(regex)) {
                        return false;
                    }
                    this.date = new Date(Long.valueOf(date));
                    break;

            }
        }
        if (date == null || sourceCode == null || destCode == null) {
            return false;
        }
        return true;
    }
}
