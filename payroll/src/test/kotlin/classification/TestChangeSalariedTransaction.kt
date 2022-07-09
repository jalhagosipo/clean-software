package classification

import PayrollDatabase
import classification.transaction.ChangeSalariedTransaction
import employee.trasaction.AddHourlyEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import schedule.MonthlySchedule


class TestChangeSalariedTransaction {

    @Test
    @Throws(Exception::class)
    fun testChangeSalariedTransaction() {
        // given
        val empId = 4
        val t = AddHourlyEmployee(empId, "Bob", "Home", 25.24)
        t.execute()
        val salary = 2500.00
        // when
        val cst = ChangeSalariedTransaction(empId, salary)
        cst.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e, salary)
    }

    private fun assertEmployee(e: Employee?, salary: Double) {
        assertNotNull(e)
        val sc = e?.pc as? SalariedClassification
        assertNotNull(sc)
        assertEquals(sc?.salary, salary)
        val ms = e?.ps as? MonthlySchedule
        assertNotNull(ms)
    }
}