package standardShapeFactory

interface ShapeFactory {
    fun makeCircle(): Shape
    fun makeSquare(): Shape
}