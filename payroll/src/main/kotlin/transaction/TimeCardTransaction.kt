package transaction

import PayrollDatabase
import TimeCard
import Transaction
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
            val hc: HourlyClassification = e.pc as HourlyClassification
            hc.addTimeCard(TimeCard(itsDate, itsHours))
        } catch (e: Exception) {
            throw Exception("Tried to add timecard to non-hourly employee")
        }


    }
}