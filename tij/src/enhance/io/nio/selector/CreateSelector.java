package enhance.io.nio.selector;

import java.io.IOException;
import java.nio.channels.Selector;

public class CreateSelector {
    public static void main(String[] args) {
        try {
            Selector open = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
