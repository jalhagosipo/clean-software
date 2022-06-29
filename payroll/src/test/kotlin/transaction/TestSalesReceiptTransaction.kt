package transaction

import PayrollDatabase
import SalesReceipt
import classification.CommissionedClassification
import employee.AddCommissionedEmployee
import employee.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.util.*


class TestSalesReceiptTransaction {
    @Test
    @Throws(Exception::class)
    fun testSalesReceiptTransaction() {
        // given
        val empId = 5
        val t = AddCommissionedEmployee(empId, "Bill", "Home", 2500, 1.2)
        t.execute()
        val timeMillis = System.currentTimeMillis()
        val amount = 100.0
        // when
        val srt = SalesReceiptTransaction(Date(timeMillis), amount, empId)
        srt.execute()
        // then
        val e: Employee = PayrollDatabase.getEmployee(empId)!!
        assertNotNull(e)
        assertCommissionedClassification(e.getClassification(CommissionedClassification::class.java), timeMillis, amount)
    }

    private fun assertCommissionedClassification(cc: CommissionedClassification, timeMillis: Long, amount: Double) {
        assertNotNull(cc)
        val sr: SalesReceipt? = cc.getSalesReceipt(Date(timeMillis))
        assertNotNull(sr)
        assertEquals(sr?.amount, amount)
    }
}