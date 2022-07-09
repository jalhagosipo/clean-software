import employee.Employee
import java.util.*
import kotlin.collections.HashMap


class PaydayTransaction(payDate: Date) : Transaction {
    private val payDate: Date

    private val paychecks: MutableMap<Int, Paycheck> = HashMap()

    init {
        this.payDate = payDate.clone() as Date
    }

    override fun execute() {
        val employees: List<Employee> = PayrollDatabase.getAllEmployee()
        for (e in employees) {
            if (!e.isPayDate(payDate)) {
                continue
            }
            val pc = e.payday(payDate)
            paychecks[e.empId] = pc
        }
    }

    fun getPaycheck(empId: Int): Paycheck? {
        return paychecks[empId]
    }
}