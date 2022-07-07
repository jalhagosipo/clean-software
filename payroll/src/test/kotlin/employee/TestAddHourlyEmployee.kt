package employee

import PayrollDatabase
import classification.HourlyClassification
import method.HoldMethod
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import schedule.WeeklySchedule


class TestAddHourlyEmployee {

    @Test
    @Throws(Exception::class)
    fun testAddHourlyEmployee() {
        // given
        val empId = 2
        val name = "Steve"
        val address = "Home Address"
        val hourlyWage = 100.00
        val t = AddHourlyEmployee(empId, name, address, hourlyWage)
        // when
        t.execute()
        // then
        val e: Employee = PayrollDatabase.getEmployee(empId)!!
        assertEmployee(e, name, address)
        assertClassification(e.getClassification(HourlyClassification::class.java), hourlyWage)
        assertSchedule(e.getSchedule(WeeklySchedule::class.java))
        assertMethod(e.getMethod(HoldMethod::class.java))
    }

    private fun assertEmployee(e: Employee, name: String, address: String) {
        assertNotNull(e)
        assertEquals(e.getName(), name)
        assertEquals(e.getAddress(), address)
    }

    private fun assertClassification(c: HourlyClassification, hourlyWage: Double) {
        assertNotNull(c)
        assertEquals(c.getRate(), hourlyWage)
    }

    private fun assertSchedule(s: WeeklySchedule) {
        assertNotNull(s)
    }

    private fun assertMethod(m: HoldMethod) {
        assertNotNull(m)
    }
}