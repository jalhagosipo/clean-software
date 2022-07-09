package transaction

import PayrollDatabase
import TimeCard
import classification.HourlyClassification
import employee.AddHourlyEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.util.*

class TestTimeCardTransaction {

    @Test
    fun testTimeCardTransaction() {
        // given
        val empId = 5
        val t = AddHourlyEmployee(empId, "Bill", "Home", 15.25)
        t.execute()
        val date = Date(System.currentTimeMillis())
        val hours = 8.0
        // when
        val tct = TimeCardTransaction(date, hours, empId)
        tct.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertNotNull(e)
        assertHourlyClassification(e!!.pc as HourlyClassification, date, hours)
    }

    private fun assertHourlyClassification(hc: HourlyClassification, date: Date, hours: Double) {
        assertNotNull(hc)
        val tc: TimeCard? = hc.getTimeCard(date)
        assertNotNull(tc)
        assertEquals(tc?.getHours(), hours)
    }
}