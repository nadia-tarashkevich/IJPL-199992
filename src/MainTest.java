import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testAddition() {
        Main main = new Main();
        assertEquals(5, main.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testAdditionFails() {
        Main main = new Main();
        assertEquals(4, main.add(2, 3), "2 + 3 should equal 4 for failure example");
    }
}
