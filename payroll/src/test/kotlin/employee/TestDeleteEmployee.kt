package employee

import PayrollDatabase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import employee.trasaction.DeleteEmployeeTransaction

class TestDeleteEmployee {

    @Test
    fun testDeleteEmployee() {
        // given
        val empId = 4
        val t = AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2)
        t.execute()
        // when
        val dt = DeleteEmployeeTransaction(empId)
        dt.execute()
        // then
        assertEquals(PayrollDatabase.getEmployee(empId), null)
    }
}