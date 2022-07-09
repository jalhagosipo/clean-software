package affiliation

import PayrollDatabase
import affiliation.transaction.ChangeUnaffiliatedTransaction
import employee.trasaction.AddHourlyEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestChangeUnaffiliatedTransaction {
    @Test
    @Throws(Exception::class)
    fun testChangeUnaffiliatedTransaction() {
        // given
        val empId = 2
        val t = AddHourlyEmployee(empId, "Bill", "home", 15.25)
        t.execute()
        // when
        val cut = ChangeUnaffiliatedTransaction(empId)
        cut.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e)
    }

    private fun assertEmployee(e: Employee?) {
        assertNotNull(e)
        assertEquals(e?.affiliation, AbstractAffiliation.NONE)
    }
}