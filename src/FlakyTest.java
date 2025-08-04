import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FlakyTest {

    @Test
    void sometimesFailsBasedOnTime() {
        long second = System.currentTimeMillis() / 1000L;
        boolean pass = (second % 2 == 0); // fails roughly every other second
        System.out.println("[FlakyTest] Current second=" + second + ", will " + (pass ? "PASS" : "FAIL"));
        assertTrue(pass, "This flaky test fails on odd seconds to cause auto-navigation/focus changes");
    }
}
