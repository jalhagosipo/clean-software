package classification

import Paycheck
import TimeCard
import java.util.Date

class HourlyClassification(
        private val rate: Double
) : PaymentClassification {

    private var timeCards: MutableList<TimeCard> = ArrayList()

    fun getRate(): Double {
        return rate
    }

    fun getTimeCard(date: Date): TimeCard? {
        return if (timeCards == null) {
            null
        } else timeCards.stream()
                .filter { it != null && it.getDate() == date }
                .findAny()
                .orElse(null)
    }

    fun addTimeCard(timeCard: TimeCard) {
        timeCards.add(timeCard)
    }

    private fun calculatePayForTimeCard(timeCard: TimeCard): Double {
        val hours = timeCard.getHours()
        val overtime = Math.max(0.0, hours - OVERTIME_LIMIT_HOURS)
        val straightTime = hours - overtime
        return straightTime * rate + overtime * rate * OVERTIME_RATE
    }

    override fun calculatePay(pc: Paycheck): Double {
        var totalPay = 0.0

        for (timeCard in timeCards) {
            if (isInPayPeriod(timeCard.getDate(), pc)) {
                totalPay += calculatePayForTimeCard(timeCard)
            }
        }
        return totalPay
    }

    companion object {
        private const val OVERTIME_LIMIT_HOURS = 8.0
        private const val OVERTIME_RATE = 1.5
    }

}