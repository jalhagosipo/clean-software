import affiliation.transaction.ChangeMemberTransaction
import employee.trasaction.AddHourlyEmployee
import employee.trasaction.AddSalariedEmployee
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import affiliation.transaction.ServiceChargeTransaction
import classification.transaction.TimeCardTransaction
import java.util.*


class TestPaydayTransaction {
    companion object {
        const val MEMBER_ID = 0
    }

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

    @Test
    @Throws(Exception::class)
    fun testPaySalariedUnionMemberDues() {
        // given
        val empId = 1
        val salary = 1000.00
        AddSalariedEmployee(empId, "Bob", "Home", salary).execute()
        val dues = 9.42
        ChangeMemberTransaction(empId, MEMBER_ID, dues).execute()
        val payDate: Date = getDate(2001, Calendar.NOVEMBER, 30)
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        val deductions = dues * 5 // 조합비 * 주 (해당 월은 금요일이 5번)
        assertPaycheck(pc, salary, deductions, salary - deductions, "Hold")
    }

    @Test
    @Throws(Exception::class)
    fun testPaySingleHourlyEmployeeNoTimeCards() {
        // given
        val empId = 2
        AddHourlyEmployee(empId, "Bill", "Home", 15.25).execute()
        val payDate: Date = getDate(2017, Calendar.JULY, 7) // 금요일
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        assertPaycheck(pc, 0.0, 0.0, 0.0, "Hold")
    }

    @Test
    @Throws(Exception::class)
    fun testPaySingleHourlyEmployeeOneTimeCard() {
        // given
        val empId = 2
        val hourlyWage = 15.25 // 시간당 급여
        AddHourlyEmployee(empId, "Bill", "Home", hourlyWage).execute()
        val payDate: Date = getDate(2017, Calendar.JULY, 7) // 금요일
        val hours = 2.0 // 일한 시간
        TimeCardTransaction(Date(payDate.time), hours, empId).execute()
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        val pay = hourlyWage * hours // 급여 = 시간당 급여 * 일한 시간
        assertPaycheck(pc, pay, 0.0, pay, "Hold")
    }

    @Test
    @Throws(Exception::class)
    fun testPaySingleHourlyEmployeeOnWrongDate() {
        // given
        val empId = 2
        val hourlyWage = 15.25 // 시간당 급여
        AddHourlyEmployee(empId, "Bill", "Home", hourlyWage).execute()
        val payDate: Date = getDate(2017, Calendar.JULY, 6) // 목요일
        val hours = 9.0 // 일한 시간
        TimeCardTransaction(Date(payDate.time), hours, empId).execute()
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        assertNull(pc)
    }

    @Test
    @Throws(Exception::class)
    fun testPaySingleHourlyEmployeeTwoTimeCards() {
        // given
        val empId = 2
        val hourlyWage = 15.25 // 시간당 급여
        AddHourlyEmployee(empId, "Bill", "Home", hourlyWage).execute()
        val payDate: Date = getDate(2017, Calendar.JULY, 7) // 금요일
        val hours = 2.0 // 일한 시간1
        TimeCardTransaction(Date(payDate.time), hours, empId).execute()
        val hours2 = 5.0
        TimeCardTransaction(getDate(2017, Calendar.JULY, 6), hours2, empId).execute()
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        val pay = hourlyWage * (hours + hours2) // 급여 = 시간당 급여 * 일한 시간
        assertPaycheck(pc, pay, 0.0, pay, "Hold")
    }

    @Test
    @Throws(Exception::class)
    fun testPaySingleHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods() {
        // given
        val empId = 2
        val hourlyWage = 15.25 // 시간당 급여
        AddHourlyEmployee(empId, "Bill", "Home", hourlyWage).execute()
        val payDate: Date = getDate(2017, Calendar.JULY, 14) // 금요일
        val hours = 2.0 // 일한 시간1
        TimeCardTransaction(Date(payDate.time), hours, empId).execute()
        val hours2 = 5.0
        TimeCardTransaction(getDate(2017, Calendar.JULY, 7), hours2, empId).execute() // 이전 기간에 일한 것 : 제외 대상
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        val pay = hourlyWage * hours // 급여 = 시간당 급여 * 일한 시간
        assertPaycheck(pc, pay, 0.0, pay, "Hold")
    }

    @Test
    @Throws(Exception::class)
    fun testPayHourlyUnionMemberServiceCharge() {
        // given
        val empId = 1
        val hourlyWage = 15.24
        AddHourlyEmployee(empId, "Bill", "Home", hourlyWage).execute()
        val dues = 9.42
        ChangeMemberTransaction(empId, MEMBER_ID, dues).execute()
        val payDate: Date = getDate(2001, Calendar.NOVEMBER, 9)
        val charge = 19.42
        ServiceChargeTransaction(empId, payDate.time, charge).execute()
        val hours = 8.0
        TimeCardTransaction(Date(payDate.time), hours, empId).execute()
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        assertPaycheck(pc, hourlyWage * hours, dues + charge, hourlyWage * hours - (dues + charge), "Hold")
    }

    @Test
    @Throws(Exception::class)
    fun testServiceChargesSpanningMultiplePayPeriods() {
        // given
        val empId = 1
        val hourlyWage = 15.24
        AddHourlyEmployee(empId, "Bill", "Home", hourlyWage).execute()
        val dues = 9.42
        ChangeMemberTransaction(empId, MEMBER_ID, dues).execute()
        val payDate: Date = getDate(2001, Calendar.NOVEMBER, 9)
        val charge = 19.42
        addServiceCharge(empId, getDate(2001, Calendar.NOVEMBER, 2), 100.00) // 지난 주 금요일
        addServiceCharge(empId, payDate, charge) // 기간 내
        addServiceCharge(empId, getDate(2001, Calendar.NOVEMBER, 16), 200.00) // 다음 주 금요일
        val hours = 8.0
        TimeCardTransaction(Date(payDate.time), hours, empId).execute()
        // when
        val pt = PaydayTransaction(payDate)
        pt.execute()
        // then
        val pc = pt.getPaycheck(empId)
        assertPaycheck(pc, hourlyWage * hours, dues + charge, hourlyWage * hours - (dues + charge), "Hold")
    }

    private fun addServiceCharge(empId: Int, date: Date, charge: Double) {
        ServiceChargeTransaction(empId, date.time, charge).execute()
    }
}