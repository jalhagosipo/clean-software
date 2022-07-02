import employee.AddSalariedEmployee
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*


class TestPaydayTransaction {
    @Test
    @Throws(Exception::class)
    fun testPaySingleSalariedEmployee() {
        // given
        val empId = 1
        val salary = 1000.00
        AddSalariedEmployee(empId, "Bob", "Home", salary).execute()
        val payDate: Date = getDate(2001, Calendar.NOVEMBER, 30)
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        assertPaycheck(pc, salary, 0.0, salary, "Hold")
    }

    private fun assertPaycheck(pc: Paycheck?, grossPay: Double, deductions: Double, netPay: Double, disposition: String) {
        assertNotNull(pc)
        assertEquals(pc?.grossPay, grossPay)
        assertEquals(pc?.deductions, deductions)
        assertEquals(pc?.netPay, netPay)
        assertEquals(pc!!.getField("Disposition"), disposition)
    }

    private fun getDate(year: Int, month: Int, date: Int): Date {
        val payCalendar = Calendar.getInstance()
        payCalendar[year, month] = date
        return payCalendar.time
    }

    @Test
    @Throws(Exception::class)
    fun testPaySingleSalariedEmployeeOnWrongDate() {
        val empId = 1
        val salary = 1000.00
        AddSalariedEmployee(empId, "Bob", "Home", salary).execute()
        val payDate: Date = getDate(2001, Calendar.NOVEMBER, 29)
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        assertNull(pc)
    }

}