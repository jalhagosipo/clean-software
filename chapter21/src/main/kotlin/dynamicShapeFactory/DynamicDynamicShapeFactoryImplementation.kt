package dynamicShapeFactory

class DynamicDynamicShapeFactoryImplementation: DynamicShapeFactory {

    override fun make(shapeName: String): DynamicShape {
        return when (shapeName) {
            "Circle" -> DynamicCircle()
            "Square" -> DynamicSquare()
            else -> throw Exception("ShapeFactory cannot create ${shapeName}")
        }
    }
}