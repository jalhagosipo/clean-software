package classification

import Paycheck
import java.util.Date

class HourlyClassification(
        val rate: Double
) : PaymentClassification {

    private val timeCards: MutableList<TimeCard> = ArrayList()

    fun getTimeCard(date: Date): TimeCard? {
        return timeCards.stream()
                .filter { it != null && it.itsDate == date }
                .findAny()
                .orElse(null)
    }

    fun addTimeCard(timeCard: TimeCard) {
        timeCards.add(timeCard)
    }

    private fun calculatePayForTimeCard(timeCard: TimeCard): Double {
        val hours = timeCard.itsHours
        val overtime = 0.0.coerceAtLeast(hours - OVERTIME_LIMIT_HOURS)
        val straightTime = hours - overtime
        return straightTime * rate + overtime * rate * OVERTIME_RATE
    }

    override fun calculatePay(pc: Paycheck): Double {
        var totalPay = 0.0

        for (timeCard in timeCards) {
            if (isInPayPeriod(timeCard.itsDate, pc)) {
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