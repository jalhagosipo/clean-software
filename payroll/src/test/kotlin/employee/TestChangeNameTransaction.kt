package employee

import PayrollDatabase
import employee.trasaction.AddHourlyEmployee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import employee.trasaction.ChangeNameTransaction

class TestChangeNameTransaction {

    @Test
    @Throws(Exception::class)
    fun testChangeNameTransaction() {
        // given
        val empId = 1
        val t = AddHourlyEmployee(empId, "Bill", "Home", 15.25)
        t.execute()
        val newName = "Bob"
        // when
        val cnt = ChangeNameTransaction(empId, newName)
        cnt.execute()
        // then
        val modified: Employee? = PayrollDatabase.getEmployee(empId)
        assertNotNull(modified)
        assertEquals(modified?.name, newName)
    }
}