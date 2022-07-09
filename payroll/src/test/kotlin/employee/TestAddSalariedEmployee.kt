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
        assertClassification(e.pc as? SalariedClassification, salary)
        assertSchedule(e.ps as? MonthlySchedule)
        assertMethod(e.pm as? HoldMethod)
    }

    private fun assertEmployee(e: Employee, name: String, address: String) {
        assertNotNull(e)
        assertEquals(e.name, name)
        assertEquals(e.address, address)
    }

    private fun assertClassification(c: SalariedClassification?, salary: Double) {
        assertNotNull(c)
        assertEquals(c?.getSalary(), salary)
    }

    private fun assertSchedule(s: MonthlySchedule?) {
        assertNotNull(s)
    }

    private fun assertMethod(m: HoldMethod?) {
        assertNotNull(m)
    }
}