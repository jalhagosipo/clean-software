import dynamicShapeFactory.DynamicCircle
import dynamicShapeFactory.DynamicDynamicShapeFactoryImplementation
import dynamicShapeFactory.DynamicShape
import dynamicShapeFactory.DynamicSquare
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import standardShapeFactory.Circle
import standardShapeFactory.Shape
import standardShapeFactory.ShapeFactory
import standardShapeFactory.ShapeFactoryImplementation


class TestShapeFactory {

    private val factory: ShapeFactory = ShapeFactoryImplementation()
    private val dynamicFactory: DynamicDynamicShapeFactoryImplementation = DynamicDynamicShapeFactoryImplementation()

    @Test
    fun testCreateCircle() {
        val s: Shape = factory.makeCircle()
        assertEquals("standardShapeFactory.Circle", s.shapeType)

        val s2: DynamicShape = dynamicFactory.make("Circle")
        assert(s2 is DynamicCircle)
    }

    @Test
    fun testCreateSquare() {
        val s: Shape = factory.makeSquare()
        assertEquals("standardShapeFactory.Square", s.shapeType)

        val s2: DynamicShape = dynamicFactory.make("Square")
        assert(s2 is DynamicSquare)
    }
}