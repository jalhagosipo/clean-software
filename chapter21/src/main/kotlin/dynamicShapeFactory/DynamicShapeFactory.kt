package dynamicShapeFactory

interface DynamicShapeFactory {
    fun make(shapeName: String): DynamicShape
}