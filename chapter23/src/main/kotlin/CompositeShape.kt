class CompositeShape : Shape {
    private val itsShape = ArrayList<Shape>()
    fun add(s: Shape) {
        itsShape.add(s)
    }

    override fun draw() {
        itsShape.forEach { it.draw() }
    }

}