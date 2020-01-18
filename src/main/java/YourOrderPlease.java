import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class YourOrderPlease {
    public static String orderPhrase(String phrase) {
        List<String> separateWords = separateWordsIn(phrase);
        separateWords.sort(byIndex());
        return concatWords(separateWords);
    }

    private static List<String> separateWordsIn(String phrase) {
        return Arrays.asList(phrase.split(" "));
    }

    private static String concatWords(List<String> separateWords) {
        String orderedPhrase = "";
        for (String word: separateWords) orderedPhrase += word + " ";
        return orderedPhrase.trim();
    }

    private static Comparator<String> byIndex(){
        return (firstWord, secondWord) -> {
            int firstNumber = getNumberIn(firstWord);
            int secondNumber = getNumberIn(secondWord);
            return (firstNumber > secondNumber)? 1 : -1;
        };
    }

    private static int getNumberIn(String word) {
        return Integer.parseInt(word.replaceAll("\\D+", ""));
    }
}
