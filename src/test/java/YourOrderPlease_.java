import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class YourOrderPlease_ {
    @Test
    public void should_not_order_when_string_is_empty() {
        assertThat(YourOrderPlease.orderPhrase("")).isEqualTo("");
    }

    @Test
    public void should_not_order_when_string_has_one_word() {
        assertThat(YourOrderPlease.orderPhrase("H1ello")).isEqualTo("H1ello");
    }

    @Test
    public void should_order_when_string_has_two_word() {
        assertThat(YourOrderPlease.orderPhrase("Jos2eph H1ello")).isEqualTo("H1ello Jos2eph");
    }

    @Test
    public void should_order_when_string_has_three_words() {
        assertThat(YourOrderPlease.orderPhrase("Jos3eph H1ello lit2tle")).isEqualTo("H1ello lit2tle Jos3eph");
    }

    private static class YourOrderPlease {
        public static String orderPhrase(String phrase) {
            if (!containsAnyWhiteSpace(phrase)) return phrase;
            List<String> separateWords = Arrays.asList(phrase.split(" "));

            Comparator<String> byIndex = (firstWord, secondWord) -> {
                firstWord = firstWord.replaceAll("\\D+","");
                secondWord = secondWord.replaceAll("\\D+","");
                return (Integer.parseInt(firstWord) > Integer.parseInt(secondWord))? 1 : -1;
            };

            separateWords.sort(byIndex);
            String orderedPhrase = "";
            for (String word: separateWords) {
                orderedPhrase += word + " ";
            }
            return orderedPhrase.trim();
        }

        private static boolean containsAnyWhiteSpace(String phrase) {
            return phrase.contains(" ");
        }
    }
}