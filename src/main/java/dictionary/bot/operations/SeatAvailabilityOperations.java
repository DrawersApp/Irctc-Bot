package dictionary.bot.operations;

import dictionary.bot.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by harshit on 27/1/16.
 */
public class SeatAvailabilityOperations implements Operation {

    private String sourceCode;
    private String destCode;
    private Date date;
    private static DrawersBotString seatAvailabilityString;

    @Override
    public OutputBody makeRestCall(DrawersBotString body) {
        return null;
    }

    static  {
        List<BotStringElement> botStringElements = new ArrayList<>();
        botStringElements.add(new BotStringElement(BotStringType.U, "Train from:"));
        botStringElements.add(new BotStringElement(BotStringType.S, "GKP", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "to:"));
        botStringElements.add(new BotStringElement(BotStringType.S, "LKO", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "date:"));
        botStringElements.add(new BotStringElement(BotStringType.D, "23-11-2015", null));
        seatAvailabilityString = new DrawersBotString(botStringElements);
        OperationsManager.getOperationsManager().registerOperations(OperationsType.SEATAVAILABILITY, SeatAvailabilityOperations.class,
                botStringElements.get(0).getPlaceHolder());
    }

}
