open class Subject {
    private val itsObserver = ArrayList<Observer>()

    protected fun notifyObservers() {
        val it = itsObserver.iterator()
        while (it.hasNext()) {
            val observer = it.next()
            observer.update()
        }
    }

    fun registerObserver(observer: Observer) {
        itsObserver.add(observer)
    }
}
