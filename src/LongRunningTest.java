import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongRunningTest {

    @Test
    void slowProcessingShouldPassEventually() {
        Main main = new Main();
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            total += main.slowDouble(i); // sleeps inside
        }
        System.out.println("[LongRunningTest] Computed total=" + total);
        // 2*(1+2+3+4+5) = 30
        assertEquals(30, total, "Sum of slowDouble from 1..5 should be 30");
    }
}
