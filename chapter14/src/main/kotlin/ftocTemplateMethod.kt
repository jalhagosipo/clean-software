import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ftocTemplateMethod: Application() {

    private var isr: InputStreamReader? = null
    private var br: BufferedReader? = null

    override fun init() {
        isr = InputStreamReader(System.`in`)
        br = BufferedReader(isr)
    }

    private fun readLineAndReturnNullIfError(): String? {
        return try {
            br?.readLine()
        } catch (e: IOException) {
            null
        }
    }

    override fun idle() {
        val fahrString = readLineAndReturnNullIfError()
        if (fahrString == null || fahrString.isEmpty()) {
            setDone()
        } else {
            val fahr = fahrString.toDouble()
            val celcius = 5.0 / 9.0 * (fahr - 32)
            println("F=$fahr, C=$celcius")
        }
    }

    override fun cleanup() {
        println("ftoc exit")
    }
}

fun main() {
 ftocTemplateMethod().run()
}