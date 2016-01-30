package dictionary.bot;

import dictionary.bot.operations.LiveStatusOperations;
import dictionary.bot.operations.PNRStatusOperation;
import dictionary.bot.operations.SeatAvailabilityOperations;
import dictionary.bot.operations.TrainBetweenStationOperations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by harshit on 27/1/16.
 */
public class OperationsManager {
    public OperationsManager() {
        operationMap.put(OperationsType.LIVESTATUS, LiveStatusOperations.class);
        operationMap.put(OperationsType.PNRCHECK, PNRStatusOperation.class);
        operationMap.put(OperationsType.SEATAVAILABILITY, SeatAvailabilityOperations.class);
        operationMap.put(OperationsType.TRAIN, TrainBetweenStationOperations.class);
    }

    public static OperationsManager getOperationsManager() {
        return operationsManager;
    }

    private static OperationsManager operationsManager = new OperationsManager();

    private Map<OperationsType, Class<? extends Operation>> operationMap = new HashMap<>();

    public DrawersBotString getDrawersBotString(String inputString) {
        DrawersBotString drawersBotString = DrawersBotString.fromString(inputString);
        return drawersBotString;
    }

    public OutputBody performOperations(DrawersBotString drawersBotString) {
        if (drawersBotString.getBotStringElements().isEmpty()) {
            return null;
        }
        String placeHolder = drawersBotString.getBotStringElements().get(0).getPlaceHolder();
        if ("PNR NO.".equals(placeHolder)) {
            try {
                return operationMap.get(OperationsType.PNRCHECK).newInstance().makeRestCall(drawersBotString);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if ("Live Status Train no.:".equals(placeHolder)) {
            try {
                return operationMap.get(OperationsType.LIVESTATUS).newInstance().makeRestCall(drawersBotString);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
