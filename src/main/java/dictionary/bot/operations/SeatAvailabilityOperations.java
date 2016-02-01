package dictionary.bot.operations;

import com.sun.org.apache.regexp.internal.RE;
import dictionary.bot.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by harshit on 27/1/16.
 */
public class SeatAvailabilityOperations implements Operation {

    private String trainNumber;
    private String sourceCode;
    private String destCode;
    private Date doj;
    private String quota;
    private String classType = "SL";

    public static DrawersBotString getSeatAvailabilityString() {
        return seatAvailabilityString;
    }

    private static DrawersBotString seatAvailabilityString;

    @Override
    public OutputBody makeRestCall(DrawersBotString body) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        if (validate(body)) {
            RetrofitAdapter.getRetrofitAdapter().getIrctcInterface().getSeat(trainNumber,sourceCode, destCode, df.format(doj),
                    quota, RetrofitAdapter.getRetrofitAdapter().getApiKey());
        }
        return null;
    }

    private boolean validate(DrawersBotString drawersBotString) {
        if (drawersBotString.getBotStringElements() == null ||
                drawersBotString.getBotStringElements().isEmpty()
                || drawersBotString.getBotStringElements().size() != seatAvailabilityString.getBotStringElements().size()) {
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
                    this.doj = new Date(Long.valueOf(date));
                    break;
                case "UNEDITABLE":
                    if (!seatAvailabilityString.getBotStringElements().get(i).getText().equals(botStringElement.getText())) {
                        return false;
                    }
                    break;
                case "STRING":
                    if (i == 3) {
                        sourceCode = botStringElement.getText();
                    } else {
                        destCode = botStringElement.getText();
                    }
                    break;
                case "LIST":
                    if (QuotaType.GENERAL.name().equals(botStringElement.getPlaceHolder())) {
                        quota = QuotaType.valueOf(botStringElement.getText()).getType();
                        if (quota == null) {
                            return false;
                        }
                    }
                    if (ClassType.SL.name().equals(botStringElement.getPlaceHolder())) {
                        classType = ClassType.valueOf(botStringElement.getText()).name();
                        if (classType == null) {
                            return false;
                        }
                    }
                    break;
                case "INTEGER":
                    trainNumber = botStringElement.getText();
                    if (trainNumber == null) {
                        return false;
                    }
                    break;
            }
        }
        if (this.doj == null || this.trainNumber == null || this.quota == null) {
            return false;
        }
        return true;
    }

    static  {
        List<BotStringElement> botStringElements = new ArrayList<>();
        botStringElements.add(new BotStringElement(BotStringType.U, "Train NO."));
        botStringElements.add(new BotStringElement(BotStringType.I, "12560", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "from:"));
        botStringElements.add(new BotStringElement(BotStringType.S, "GKP", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "to:", null));
        botStringElements.add(new BotStringElement(BotStringType.S, "LKO", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "date:"));
        botStringElements.add(new BotStringElement(BotStringType.D, "12-05-2016", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "quota:"));
        botStringElements.add(new BotStringElement(BotStringType.LI, QuotaType.GENERAL.name(),
                QuotaType.GENERAL.name(), Arrays.asList(QuotaType.GENERAL.name(), QuotaType.TATKAL.name())));
        botStringElements.add(new BotStringElement(BotStringType.U, "class:"));
        botStringElements.add(new BotStringElement(BotStringType.LI, ClassType.SL.name(),
                ClassType.SL.name(), Arrays.asList(ClassType.AC1.name(), ClassType.AC2.name(),
                ClassType.AC3.name(), ClassType.SL.name(), ClassType.CC.name())));
        seatAvailabilityString = new DrawersBotString(botStringElements);
        OperationsManager.getOperationsManager().registerOperations(OperationsType.SEATAVAILABILITY, SeatAvailabilityOperations.class,
                botStringElements.get(0).getPlaceHolder());
        DrawersBotStringHelp.getDrawersBotStringHelp().getDrawersBotStrings().add(seatAvailabilityString);
    }



}
