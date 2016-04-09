package dictionary.bot;

import org.drawers.bot.dto.DrawersMessage;

import java.io.UnsupportedEncodingException;

/**
 * Created by harshit on 30/1/16.
 */
public interface MessageSubscriber {
    /**
     * @return String
     * This text is shown when {@link #generateReply(DrawersMessage)} message throws exception.
     */
    DrawersMessage getErrorDefaultMessage(DrawersMessage message);

    /**
     *
     * @param message
     * @return DrawersMessage
     * This function takes the input message,
     * makes the computation and return the relevant reply.
     */
    DrawersMessage generateReply(DrawersMessage message) throws UnsupportedEncodingException;
}
