import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyAnalyzerTest {
    @Test
    public void getFrequentStringsWithStreamAPI() {
        List<String> words = new ArrayList<>();
        words.add("ppp");
        words.add("ppp");
        words.add("kkk");
        words.add("kkk");
        words.add("kkk");
        words.add("lll");
        words.add("lll");
        words.add("aaa");
        FrequencyAnalyzer analyzer = new FrequencyAnalyzer(2, 3, words);
        List<String> actual = analyzer.getFrequentStringsWithStreamAPI();
        actual = actual.stream().sorted().collect(Collectors.toList());
        List<String> expected = new ArrayList<>();
        expected.add("ppp");
        expected.add("kkk");
        expected.add("lll");
        expected = expected.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFrequentStringsWithThreads() {
        List<String> words = new ArrayList<>();
        words.add("kkk");
        words.add("ppp");
        words.add("kkk");
        words.add("kkk");
        words.add("kkk");
        words.add("lll");
        words.add("lll");
        words.add("aaa");
        FrequencyAnalyzer analyzer = new FrequencyAnalyzer(2, 3, words);
        List<String> actual = analyzer.getFrequentStringsWithThreads();
        actual = actual.stream().sorted().collect(Collectors.toList());
        List<String> expected = new ArrayList<>();
        expected.add("ppp");
        expected.add("kkk");
        expected.add("lll");
        expected = expected.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }
}
