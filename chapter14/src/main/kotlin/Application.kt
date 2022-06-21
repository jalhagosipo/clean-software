abstract class Application {
    private var isDone = false

    protected abstract fun init()
    protected abstract fun idle()
    protected abstract fun cleanup()

    protected fun setDone() {
        isDone = true
    }

    protected fun done(): Boolean {
        return isDone
    }

    fun run() {
        init()
        while(!done())
            idle()
        cleanup()
    }
}