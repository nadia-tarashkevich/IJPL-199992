import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testAddition() {
        Main main = new Main();
        assertEquals(5, main.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testAdditionAgain() {
        Main main = new Main();
        assertEquals(5, main.add(2, 3), "2 + 3 should equal 5 (second check)");
    }
}
