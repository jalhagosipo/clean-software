package transaction

import PayrollDatabase
import TimeCard
import classification.HourlyClassification
import employee.Employee
import java.util.*


class TimeCardTransaction(
        private val itsDate: Date,
        private val itsHours: Double,
        private val itsEmpid: Int
) : Transaction {

    override fun execute() {
        val e: Employee = PayrollDatabase.getEmployee(itsEmpid) ?: throw Exception("No such employee.")
        try {
            // 277쪽. paymentClassification 가져와서 형변환하는건데 바로 이렇게썼네?
            val hc: HourlyClassification = e.getClassification(HourlyClassification::class.java)
            hc.addTimeCard(TimeCard(itsDate, itsHours))
        } catch (e: Exception) {
            throw Exception("Tried to add timecard to non-hourly employee")
        }


    }
}