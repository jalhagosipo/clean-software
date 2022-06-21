import java.util.*

class ActiveObjectEngine {
    private var commands = LinkedList<Command>()
    fun addCommand(c: Command) {
        commands.add(c)
    }

    fun run() {
        while (!commands.isEmpty()) {
            val c = commands.first
            commands.removeFirst()
            c.execute()
        }
    }
}