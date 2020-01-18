import org.junit.Test;

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

}