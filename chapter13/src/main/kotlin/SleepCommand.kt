class SleepCommand(
        private val sleepTime: Long = 0,
        private val engine: ActiveObjectEngine? = null,
        private val wakeupCommand: Command? = null
): Command {
    private var startTime: Long = 0
    private var started: Boolean = false

    override fun execute() {
        val currentTime = System.currentTimeMillis()
        if (!started) {
            started = true
            startTime = currentTime
            engine?.addCommand(this)
        } else if ((currentTime - startTime) < sleepTime) {
            engine?.addCommand(this)
        } else {
            if (wakeupCommand != null) {
                engine?.addCommand(wakeupCommand)
            }
        }
    }
}