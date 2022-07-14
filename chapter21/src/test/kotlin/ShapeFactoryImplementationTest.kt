import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import standardShapeFactory.Shape
import standardShapeFactory.ShapeFactory
import standardShapeFactory.ShapeFactoryImplementation


class TestShapeFactory {

    private val factory: ShapeFactory = ShapeFactoryImplementation()

    @Test
    fun testCreateCircle() {
        val s: Shape = factory.makeCircle()
        assertEquals("standardShapeFactory.Circle", s.shapeType)
    }

    @Test
    fun testCreateSquare() {
        val s: Shape = factory.makeSquare()
        assertEquals("standardShapeFactory.Square", s.shapeType)
    }
}