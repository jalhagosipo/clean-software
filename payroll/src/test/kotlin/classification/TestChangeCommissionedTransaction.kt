package classification

import PayrollDatabase
import classification.transaction.ChangeCommissionedTransaction
import employee.Employee
import employee.trasaction.AddHourlyEmployee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import schedule.BiWeeklySchedule


class TestChangeCommissionedTransaction {

    @Test
    @Throws(Exception::class)
    fun testChangeCommissionedTransaction() {
        // given
        val empId = 4
        val t = AddHourlyEmployee(empId, "Lance", "Home", 25.32)
        t.execute()
        val salary = 3500.00
        val commissionRate = 2.2
        // when
        val cct = ChangeCommissionedTransaction(empId, salary, commissionRate)
        cct.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e, salary, commissionRate)
    }

    private fun assertEmployee(e: Employee?, salary: Double, commissionRate: Double) {
        assertNotNull(e)
        val cc: CommissionedClassification? = e?.pc as? CommissionedClassification
        assertNotNull(cc)
        assertEquals(cc?.salary, salary)
        assertEquals(cc?.commissionRate, commissionRate)
        val bws: BiWeeklySchedule? = e?.ps as? BiWeeklySchedule
        assertNotNull(bws)
    }
}