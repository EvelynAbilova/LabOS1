import java.util.*;
import java.util.stream.Collectors;

public class FrequencyAnalyzer {
    private int numberOfThreads;
    private int numberOfQueries;
    private List<String> words;

    public FrequencyAnalyzer(int numberOfThreads, int numberOfQueries, List<String> words) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfQueries = numberOfQueries;
        this.words = words;
    }

    public List<String> getFrequentStringsWithThreads() {
        List<List<String>> listOfLists = new ArrayList<>();
        if (words.size() < numberOfThreads) {
            numberOfThreads = words.size();
        }
        //Дробим на куски массив
        for (int i = 0; i < words.size(); i++) {
            if (words.size() - i >= 2 * numberOfThreads) {
                int tmpI = i + (words.size() / numberOfThreads);
                ArrayList<String> tmp = new ArrayList<>();
                for (; i < tmpI; i++) {
                    tmp.add(words.get(i));
                }
                listOfLists.add(tmp);

            } else {
                List<String> tmp = new ArrayList<>();
                for(;i< words.size();i++) {
                    tmp.add(words.get(i));
                }
                listOfLists.add(tmp);
            }
        }
        //Запускаем поток на выполнение если для него есть массив(кусочек) из массива массивов
        for (int i = 0; i < numberOfThreads; i++) {
            MyThread thread = new MyThread();
            thread.setStrings(listOfLists.get(i));
            thread.start();
        }
        return getMapResult();

    }

    public List<String> getFrequentStringsWithStreamAPI() {
        //STREAM API
        words.stream()
                .parallel()
                .forEach(s -> {
                    MyString newMyString = new MyString(s);
                    MyString.increaseCounter(newMyString);
                });
        return getMapResult();
    }

    private List<String> getMapResult() {
        List<Integer> integers = MyString.strings.values().stream().
                sorted().
                collect(Collectors.toList());
        Collections.reverse(integers);
        List<Integer> firstNValues = new ArrayList<>();
        for (int i = 0; i < numberOfQueries; i++) {
            firstNValues.add(integers.get(i));
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < firstNValues.size(); i++) {
            if (strings.size() < numberOfQueries) {
                int tmpI = i;
                strings.addAll(MyString.strings.keySet()//перебираем строки из ключей мэпа перебираем
                        .stream()
                        .filter(s -> MyString.strings.get(s).equals(integers.get(tmpI)))
                        .collect(Collectors.toList()));
            }
        }
        List<String> ResultString = new ArrayList<>();
        for (int i = 0; i < numberOfQueries; i++) {
            ResultString.add(strings.get(i));
        }
        return ResultString;
    }
}
