package affiliation

import PayrollDatabase
import affiliation.transaction.ChangeMemberTransaction
import employee.trasaction.AddHourlyEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestChangeMemberTransaction {
    companion object {
        const val MEMBER_ID = 0
    }

    @Test
    @Throws(Exception::class)
    fun testChangeAffiliatedTransaction() {
        // given
        val empId = 2
        val t = AddHourlyEmployee(empId, "Bill", "home", 15.25)
        t.execute()
        // when
        val dues = 99.42
        val cat = ChangeMemberTransaction(empId, MEMBER_ID, dues)
        cat.execute()
        // then
        val e: Employee? = PayrollDatabase.getEmployee(empId)
        assertEmployee(e, dues)
    }

    private fun assertEmployee(e: Employee?, dues: Double) {
        assertNotNull(e)
        val ua = e?.affiliation
        assertNotNull(ua)
        if (ua is UnionAffiliation) {
            assertEquals(ua?.dues, dues)
        }
    }
}