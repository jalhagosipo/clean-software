package affiliation

import DateUtils
import Paycheck
import java.util.*


class UnionAffiliation(
        val memberId: Int,
        val dues: Double
) : AbstractAffiliation() {

    private val serviceCharges: MutableList<ServiceCharge> = ArrayList()

    fun getServiceCharge(timeMillis: Long): ServiceCharge {
        return serviceCharges.stream()
                .filter { it.timeMillis != null && it.timeMillis == timeMillis }
                .findAny()
                .orElse(null)
    }

    fun addServiceCharge(serviceCharge: ServiceCharge) {
        serviceCharges.add(serviceCharge)
    }

    override fun calculateDeductions(pc: Paycheck): Double {
        val fridayCount = numberOfFridayCountInPeriod(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())
        return dues * fridayCount + getTotalServiceCharge(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())
    }

    private fun getTotalServiceCharge(payPeriodStartDate: Date?, payPeriodEndDate: Date?): Double {
        return serviceCharges.stream()
                .filter { DateUtils.between(Date(it.timeMillis), payPeriodStartDate, payPeriodEndDate) }
                .mapToDouble(ServiceCharge::amount)
                .sum()
    }

    private fun numberOfFridayCountInPeriod(startDate: Date?, endDate: Date?): Int {
        var count = 0
        val startCalendar = DateUtils.toCalendar(startDate)
        val endCalendar = DateUtils.toCalendar(endDate)
        while (startCalendar <= endCalendar) {
            if (startCalendar[Calendar.DAY_OF_WEEK] == Calendar.FRIDAY) {
                count++
            }
            startCalendar.add(Calendar.DATE, 1)
        }
        return count
    }
}