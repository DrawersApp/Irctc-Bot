package dictionary.bot;

import dictionary.bot.operations.LiveStatusOperations;
import dictionary.bot.operations.PNRStatusOperation;
import dictionary.bot.operations.SeatAvailabilityOperations;
import dictionary.bot.operations.TrainBetweenStationOperations;
import org.drawers.bot.DrawersClient;
import org.drawers.bot.dto.DrawersMessage;

/**
 * Created by harshit on 20/1/16.
 */
public class BotsCaller extends DrawersClient implements MessageSubscriber {


    public BotsCaller(String clientId, String password) {
        super(clientId, password);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Load all the classes which contains string.
        Class.forName(LiveStatusOperations.class.getName());
        Class.forName(PNRStatusOperation.class.getName());
        Class.forName(TrainBetweenStationOperations.class.getName());
        Class.forName(SeatAvailabilityOperations.class.getName());
        System.out.print(DrawersBotStringHelp.getDrawersBotStringHelp().toJsonString());

        BotsCaller botsCaller = new BotsCaller("REPLACE_ME_CLIENT_ID", "REPLACE_ME_PASSWORD");
        botsCaller.startBot();
    }

    @Override
    public DrawersMessage processMessageAndReply(DrawersMessage message) {
        return generateReply(message);
    }

    @Override
    public DrawersMessage getErrorDefaultMessage(DrawersMessage message) {
        return new DrawersMessage(message.getSender(), "Something went wrong");
    }



    @Override
    public DrawersMessage generateReply(DrawersMessage message) {
        String body = message.getMessage();
        DrawersBotString drawersBotString = OperationsManager.getOperationsManager().getDrawersBotString(body);
        if (drawersBotString == null) {
            return new DrawersMessage(message.getSender(), "Incorrect message type");
        }
        OutputBody outputBody = OperationsManager.getOperationsManager().performOperations(drawersBotString);
        if (outputBody == null) {
            return new DrawersMessage(message.getSender(), "Incorrect message type");
        }
        String replyString = outputBody.toUserString();
        if (replyString == null || replyString.length() == 0) {
            return new DrawersMessage(message.getSender(), "Incorrect message type");
        }
        return new DrawersMessage(message.getSender(), replyString);
    }
}
