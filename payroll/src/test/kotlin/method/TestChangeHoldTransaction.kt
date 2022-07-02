package method

import PayrollDatabase
import employee.AddSalariedEmployee
import employee.Employee
import method.transaction.ChangeHoldTransaction
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestChangeHoldTransaction {
    @Test
    @Throws(Exception::class)
    fun testChangeHoldTransaction() {
        // given
        val empId = 9
        val t = AddSalariedEmployee(empId, "Bob", "Home", 5000.00)
        t.execute()
        // when
        val cmt = ChangeHoldTransaction(empId)
        cmt.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e)
    }

    private fun assertEmployee(e: Employee?) {
        assertNotNull(e)
        val hm = e?.getMethod(HoldMethod::class.java)
        assertNotNull(hm)
    }
}