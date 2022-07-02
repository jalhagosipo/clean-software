package classification.transaction

import classification.HourlyClassification
import classification.PaymentClassification
import schedule.PaymentSchedule

import schedule.WeaklySchedule


class ChangeHourlyTransaction(
        empId: Int?,
        private val hourlyRate: Double
) : ChangeClassificationTransaction(empId) {

    override val schedule: PaymentSchedule
        get() = WeaklySchedule()
    override val classification: PaymentClassification
        get() = HourlyClassification(hourlyRate)
}