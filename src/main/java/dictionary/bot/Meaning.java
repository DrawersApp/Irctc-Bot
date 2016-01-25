package dictionary.bot;

import java.util.List;

/**
 * Created by harshit on 20/1/16.
 */
public class Meaning {
    @Override
    public String toString() {
        return "dictionary.bot.Meaning{" +
                "definitions=" + definitions +
                '}';
    }

    private List<Definitions> definitions;

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }

    public class Definitions {
        @Override
        public String toString() {
            return "Definitions{" +
                    "text='" + text + '\'' +
                    '}';
        }

        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
