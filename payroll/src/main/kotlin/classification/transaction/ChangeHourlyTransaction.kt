package classification.transaction

import classification.HourlyClassification
import classification.PaymentClassification
import schedule.PaymentSchedule

import schedule.WeeklySchedule


class ChangeHourlyTransaction(
        empId: Int,
        private val hourlyRate: Double
) : ChangeClassificationTransaction(empId) {

    override val schedule: PaymentSchedule
        get() = WeeklySchedule()
    override val classification: PaymentClassification
        get() = HourlyClassification(hourlyRate)
}