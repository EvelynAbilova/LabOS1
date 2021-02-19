import java.util.*;
import java.util.stream.Collectors;

//int NumOfThreads, int NumOfQueries, List<String> Test
public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfThreads = scanner.nextInt();
        int numberOfQueries = scanner.nextInt();
        int size = scanner.nextInt();
        FrequencyAnalyzer analyzer=new FrequencyAnalyzer(numberOfThreads,numberOfQueries, RandomString.getRandomString(size));
    }
}