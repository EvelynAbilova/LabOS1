import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomString {
    public static List<String> getRandomString(int size) {
        ArrayList<String> Words = new ArrayList<>();
        Words.add("oh");
        Words.add("hi");
        Words.add("Mark");
        Words.add("i");
        Words.add("did");
        Words.add("not");
        Words.add("hit");
        Words.add("her");

        Random random = new Random();
        List<String> RandomString = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            RandomString.add(Words.get(random.nextInt(Words.size())));
        }
        System.out.println(RandomString);
        return RandomString;
    }
}
