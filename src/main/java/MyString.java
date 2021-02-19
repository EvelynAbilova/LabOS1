import java.util.HashMap;
import java.util.Map;

public class MyString {
    public static Map<String, Integer> strings = new HashMap<>();
    private String tempString;

    public MyString(String string) {
        this.tempString = string;
        if (!strings.containsKey(string)) {
            strings.put(string, 0);
        }
    }

    public String getString() {
        return tempString;
    }

    public synchronized static void increaseCounter(MyString myString) {
        String string = myString.getString();
        strings.put(string, strings.get(string) + 1);
    }
}