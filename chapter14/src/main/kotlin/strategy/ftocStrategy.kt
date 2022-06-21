package strategy

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ftocStrategy: Application {
    private lateinit var isr: InputStreamReader
    private lateinit var br: BufferedReader
    private var isDone: Boolean = false

    override fun init() {
        isr = InputStreamReader(System.`in`)
        br = BufferedReader(isr)
    }

    private fun readLineAndReturnNullIfError(): String? {
        return try {
            br.readLine()
        } catch (e: IOException) {
            null
        }
    }

    override fun idle() {
        val fahrString = readLineAndReturnNullIfError()
        if (fahrString == null || fahrString.isEmpty()) {
            isDone = true
        } else {
            val fahr = fahrString.toDouble()
            val celcius = 5.0 / 9.0 * (fahr - 32)
            println("F=$fahr, C=$celcius")
        }
    }

    override fun cleanup() {
        println("ftoc exit")
    }

    override fun done(): Boolean {
        return isDone
    }
}

fun main() {
    ApplicationRunner(ftocStrategy()).run()
}