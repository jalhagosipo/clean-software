import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class TestShapeFactory {

    private val factory: ShapeFactory = ShapeFactoryImplementation()

    @Test
    fun testCreateCircle() {
        val s: Shape = factory.makeCircle()
        assertEquals("Circle", s.shapeType)
    }

    @Test
    fun testCreateSquare() {
        val s: Shape = factory.makeSquare()
        assertEquals("Square", s.shapeType)
    }
}