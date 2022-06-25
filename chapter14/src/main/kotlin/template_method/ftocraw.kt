package template_method

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val isr = InputStreamReader(System.`in`)
    val br = BufferedReader(isr)
    var done = false

    while (!done) {
        val fahrString = br.readLine()
        if (fahrString == null || fahrString.isEmpty()) {
            done = true
        } else {
            val fahr = fahrString.toDouble()
            val celcius = 5.0 / 9.0 * (fahr - 32)
            println("F=$fahr, C=$celcius")
        }
    }
    println("ftoc exit")
}