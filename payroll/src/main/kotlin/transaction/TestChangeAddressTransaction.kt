package transaction

import PayrollDatabase
import employee.AddHourlyEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


class TestChangeAddressTransaction {

    @Test
    @Throws(Exception::class)
    fun testChangeAddressTransaction() {
        // given
        val empId = 2
        val t = AddHourlyEmployee(empId, "Bill", "Home", 15.25)
        t.execute()
        val newAddress = "Office"
        // when
        val cnt = ChangeAddressTransaction(empId, newAddress)
        cnt.execute()
        // then
        val modified: Employee? = PayrollDatabase.getEmployee(empId)
        assertNotNull(modified)
        assertEquals(modified?.getAddress(), newAddress)
    }
}