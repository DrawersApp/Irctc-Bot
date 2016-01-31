package dictionary.bot;

import dictionary.bot.operations.LiveStatus;
import dictionary.bot.operations.LiveStatusOperations;
import dictionary.bot.operations.PNRStatusOperation;
import jdk.internal.dynalink.beans.StaticClass;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by harshit on 20/1/16.
 */
public class BotsCaller implements MessageSubscriber {


    public static void main(String[] args) throws XmppStringprepException, SmackException.NotConnectedException, InterruptedException, ClassNotFoundException {
        Class.forName(LiveStatusOperations.class.getName());
        Class.forName(PNRStatusOperation.class.getName());
        BotsCaller botsCaller = new BotsCaller();
        Bot.getBot(botsCaller);
        while (true) {
            Thread.sleep(1000000000000L);
        }
    }

    private String errorDefaultText = "Something went wrong";

    @Override
    public String generateReply(Message message) throws UnsupportedEncodingException {
        String body = message.getBody();
        if (body == null) {
            return "Empty Message";
        }
        body = URLDecoder.decode(body, "UTF-8");
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
