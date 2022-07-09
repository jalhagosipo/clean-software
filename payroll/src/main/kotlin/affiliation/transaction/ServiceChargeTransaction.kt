package affiliation.transaction

import PayrollDatabase
import affiliation.ServiceCharge
import Transaction
import affiliation.UnionAffiliation
import employee.Employee
import java.util.*


class ServiceChargeTransaction(
        private val empId: Int,
        private val timeMillis: Long,
        private val charge: Double
) : Transaction {

    override fun execute() {
        val e: Employee = Optional.ofNullable(PayrollDatabase.getEmployee(empId))
                .orElseThrow { IllegalArgumentException("Not found employee : $empId") }
        val uf = e.getAffiliation(UnionAffiliation::class.java)
        uf.addServiceCharge(ServiceCharge(timeMillis, charge))
    }
}