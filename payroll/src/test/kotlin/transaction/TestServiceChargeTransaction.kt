package transaction

import PayrollDatabase
import affiliation.UnionAffiliation
import employee.AddHourlyEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestServiceChargeTransaction {

    companion object {
        const val MEMBER_ID = 0
    }
    @Test
    @Throws(Exception::class)
    fun testServiceChangeTransaction() {
        // given
        val empId = 6
        val af = fixtureEmployeeWithUnionAffiliation(empId)
        val timeMillis = System.currentTimeMillis()
        val amount = 12.95
        // when
        val sct = ServiceChargeTransaction(empId, timeMillis, amount)
        sct.execute()
        // then
        val sc = af.getServiceCharge(timeMillis)
        assertNotNull(sc)
        assertEquals(sc.amount, amount)
    }

    private fun fixtureEmployeeWithUnionAffiliation(empId: Int): UnionAffiliation {
        val t = AddHourlyEmployee(empId, "Bill", "Home", 15.25)
        t.execute()
        val e: Employee = PayrollDatabase.getEmployee(empId)!!
        val af = UnionAffiliation(MEMBER_ID, 12.5)
        e.affiliation = af
        return af
    }
}