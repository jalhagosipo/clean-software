package employee

import PayrollDatabase
import classification.SalariedClassification
import method.HoldMethod
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import schedule.MonthlySchedule

class TestAddSalariedEmployee {

    @Test
    fun testAddSalariedEmployee() {
        // given
        val empId = 1
        val name = "Bob"
        val address = "Home"
        val salary = 10000.00
        val t = AddSalariedEmployee(empId, name, address, salary)
        // when
        t.execute()
        // then
        val e: Employee = PayrollDatabase.getEmployee(empId)!!
        assertEmployee(e, name, address)
        assertClassification(e.getClassification(SalariedClassification::class.java), salary)
        assertSchedule(e.getSchedule(MonthlySchedule::class.java))
        assertMethod(e.getMethod(HoldMethod::class.java))
    }

    private fun assertEmployee(e: Employee, name: String, address: String) {
        assertNotNull(e)
        assertEquals(e.getName(), name)
        assertEquals(e.getAddress(), address)
    }

    private fun assertClassification(c: SalariedClassification, salary: Double) {
        assertNotNull(c)
        assertEquals(c.getSalary(), salary)
    }

    private fun assertSchedule(s: MonthlySchedule) {
        assertNotNull(s)
    }

    private fun assertMethod(m: HoldMethod) {
        assertNotNull(m)
    }
}