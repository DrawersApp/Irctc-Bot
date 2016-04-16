package dictionary.bot;

import java.io.Serializable;

/**
 * Created by harshit on 27/1/16.
 */
public interface Operation extends Serializable {
    OutputBody makeRestCall(DrawersBotString body);
}
