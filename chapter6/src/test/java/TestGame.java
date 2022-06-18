import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGame {

    private Game g;

    @BeforeEach
    public void setUp() {
        g = new Game();
    }

    @Test
    public void testOneThrow() {
        g.add(5);
        assertEquals(5, g.score());
    }

    @Test
    public void testTwoThrowsNoMark() {
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
    }

    @Test
    public void testFourThrowsNoMark() {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }

    @Test
    public void testSimpleSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.scoreForFrame(1));
    }
}
