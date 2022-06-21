package strategy

class ApplicationRunner(
        private val itsApplication: Application
) {

    fun run() {
        itsApplication.init()
        while(!itsApplication.done())
            itsApplication.idle()
        itsApplication.cleanup()
    }
}