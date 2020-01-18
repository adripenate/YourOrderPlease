import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class YourOrderPleaseShould {
    @Test
    public void not_order_when_string_is_empty() {
        assertThat(YourOrderPlease.orderPhrase("")).isEqualTo("");
    }

    @Test
    public void not_order_when_string_has_one_word() {
        assertThat(YourOrderPlease.orderPhrase("H1ello")).isEqualTo("H1ello");
    }

    @Test
    public void order_when_string_has_two_word() {
        assertThat(YourOrderPlease.orderPhrase("Jos2eph H1ello")).isEqualTo("H1ello Jos2eph");
    }

    @Test
    public void order_when_string_has_three_words() {
        assertThat(YourOrderPlease.orderPhrase("Jos3eph H1ello lit2tle")).isEqualTo("H1ello lit2tle Jos3eph");
    }

    private static class YourOrderPlease {
        public static String orderPhrase(String phrase) {
            List<String> separateWords = Arrays.asList(phrase.split(" "));
            separateWords.sort(byIndex());
            return concatWords(separateWords);
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
}