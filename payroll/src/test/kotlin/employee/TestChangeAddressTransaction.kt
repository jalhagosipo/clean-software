package employee

import PayrollDatabase
import employee.trasaction.AddHourlyEmployee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import employee.trasaction.ChangeAddressTransaction


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
        assertEquals(modified?.address, newAddress)
    }
}