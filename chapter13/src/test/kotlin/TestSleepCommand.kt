import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TestSleepCommand {

    private var commandExecuted = false

    @Test
    fun testSleep() {
        val wakeup = object : Command {
            override fun execute() {
                commandExecuted = true
            }
        }
        val e = ActiveObjectEngine()
        val c = SleepCommand(1000, e, wakeup)
        e.addCommand(c)
        val start = System.currentTimeMillis()
        e.run()
        val stop = System.currentTimeMillis()
        val sleepTime = (stop - start)
        assertTrue(sleepTime > 1000 ) // "SleepTime " + sleepTime + " expected > 1000"
        assertTrue(sleepTime < 1100) // "SleepTime " + sleepTime + " expected < 1100"
        assertTrue(commandExecuted) // "Command Executed"
    }
}