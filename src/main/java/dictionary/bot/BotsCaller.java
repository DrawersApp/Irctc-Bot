package dictionary.bot;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.stringprep.XmppStringprepException;

/**
 * Created by harshit on 20/1/16.
 */
public class BotsCaller implements MessageSubscriber {


    public static void main(String[] args) throws XmppStringprepException, SmackException.NotConnectedException, InterruptedException {
        BotsCaller botsCaller = new BotsCaller();
        Bot.getBot(botsCaller);
        while (true) {
        }
    }

    private String errorDefaultText = "Something went wrong";

    @Override
    public String generateReply(Message message) {
        String body = message.getBody();
        if (body == null) {
            return "Empty Message";
        }
        DrawersBotString drawersBotString = OperationsManager.getOperationsManager().getDrawersBotString(body);
        if (drawersBotString == null) {
            return "Incorrect message type";
        }
        OutputBody outputBody = OperationsManager.getOperationsManager().performOperations(drawersBotString);
        if (outputBody == null) {
            return "Incorrect message type";
        }
        String replyString = outputBody.toUserString();
        if (replyString == null || replyString.length() == 0) {
            return "Incorrect message type";
        }
        return replyString;
    }

    @Override
    public String getErrorDefaultText() {
        return errorDefaultText;
    }
}
