class ShapeFactoryImplementation: ShapeFactory {
    override fun makeCircle(): Shape {
        return Circle()
    }

    override fun makeSquare(): Shape {
        return Square()
    }

}