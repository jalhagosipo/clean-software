package method

import PayrollDatabase
import employee.AddSalariedEmployee
import employee.Employee
import method.transaction.ChangeMailTransaction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestChangeMailTransaction {

    @Test
    @Throws(Exception::class)
    fun testChangeMailTransaction() {
        // given
        val empId = 8
        val t = AddSalariedEmployee(empId, "Bob", "Home", 5000.00)
        t.execute()
        val address = "address@domain.com"
        // when
        val cmt = ChangeMailTransaction(empId, address)
        cmt.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e, address)
    }

    private fun assertEmployee(e: Employee?, address: String) {
        assertNotNull(e)
        val dm = e?.pm as? MailMethod
        assertNotNull(dm)
        assertEquals(dm?.address, address)
    }
}