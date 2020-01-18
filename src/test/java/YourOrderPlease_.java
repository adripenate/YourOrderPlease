import org.junit.Test;

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

    private static class YourOrderPlease {
        public static String orderPhrase(String phrase) {
            return "";
        }
    }
}
