package classification

import PayrollDatabase
import classification.transaction.ChangeHourlyTransaction
import employee.trasaction.AddCommissionedEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import schedule.WeeklySchedule


class TestChangeHourlyTransaction {

    @Test
    @Throws(Exception::class)
    fun testChangeHourlyTransaction() {
        // given
        val empId = 3
        val t = AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2)
        t.execute()
        val rate = 27.52
        // when
        val cht = ChangeHourlyTransaction(empId, rate)
        cht.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e, rate)
    }

    private fun assertEmployee(e: Employee?, rate: Double) {
        assertNotNull(e)
        val hc = e?.pc as? HourlyClassification
        assertNotNull(hc)
        assertEquals(hc?.rate, rate)
        val ws = e?.ps as? WeeklySchedule
        assertNotNull(ws)
    }
}