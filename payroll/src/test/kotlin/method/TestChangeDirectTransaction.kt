package method

import PayrollDatabase
import employee.AddSalariedEmployee
import employee.Employee
import method.transaction.ChangeDirectTransaction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestChangeDirectTransaction {
    @Test
    @Throws(Exception::class)
    fun testChangeDirectionTransaction() {
        // given
        val empId = 7
        val t = AddSalariedEmployee(empId, "Bob", "Home", 5000.00)
        t.execute()
        val bank = "BANK"
        val account = "111-111111-11"
        // when
        val cdt = ChangeDirectTransaction(empId, bank, account)
        cdt.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e, bank, account)
    }

    private fun assertEmployee(e: Employee?, bank: String, account: String) {
        assertNotNull(e)
        val dm = e?.pm as? DirectMethod
        assertNotNull(dm)
        assertEquals(dm?.bank, bank)
        assertEquals(dm?.account, account)
    }
}