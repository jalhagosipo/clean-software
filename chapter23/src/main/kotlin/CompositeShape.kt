class CompositeShape : Shape {
    private val itsShape = ArrayList<Shape>()
    fun add(s: Shape) {
        itsShape.add(s)
    }

    override fun draw() {
        for (i: Int in 0 until itsShape.size) {
            val shape = itsShape.elementAt(i)
            shape.draw()
        }
    }

}