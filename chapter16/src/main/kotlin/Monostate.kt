class Monostate {
    companion object {
        private var itsX = 0
    }
    constructor()

    fun setX(x: Int) {
        itsX = x
    }

    fun getX(): Int {
        return itsX
    }
}