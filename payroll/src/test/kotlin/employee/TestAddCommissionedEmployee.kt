package employee

import PayrollDatabase
import classification.CommissionedClassification
import method.HoldMethod
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import schedule.BiWeeklySchedule


class TestAddCommissionedEmployee {

    @Test
    @Throws(Exception::class)
    fun testAddCommissionedEmployee() {
        // given
        val empId = 3
        val name = "Robert"
        val address = "Office Address"
        val salary = 10000.00
        val commissionRate = 0.1
        val t = AddCommissionedEmployee(empId, name, address, salary.toInt(), commissionRate)

        // when
        t.execute()

        // then
        val e: Employee = PayrollDatabase.getEmployee(empId)!!
        assertEmployee(e, name, address)
        assertClassification(e.pc as? CommissionedClassification, salary, commissionRate)
        assertSchedule(e.ps as? BiWeeklySchedule)
        assertMethod(e.pm as? HoldMethod)
    }

    private fun assertEmployee(e: Employee, name: String, address: String) {
        assertNotNull(e)
        assertEquals(e.name, name)
        assertEquals(e.address, address)
    }

    private fun assertClassification(c: CommissionedClassification?, salary: Double, commissionRate: Double) {
        assertNotNull(c)
        assertEquals(c?.getSalary(), salary)
        assertEquals(c?.getCommissionRate(), commissionRate)
    }

    private fun assertSchedule(s: BiWeeklySchedule?) {
        assertNotNull(s)
    }

    private fun assertMethod(m: HoldMethod?) {
        assertNotNull(m)
    }
}