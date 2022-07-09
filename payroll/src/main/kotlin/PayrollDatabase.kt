import affiliation.UnionAffiliation
import employee.Employee

object PayrollDatabase {
    private val itsEmployees: MutableMap<Int, Employee> = HashMap()
    private val itsUnionMembers: MutableMap<Int, Int> = HashMap()

    fun getEmployee(empId: Int): Employee? {
        return itsEmployees[empId]
    }

    fun addEmployee(empId: Int, employee: Employee) {
        itsEmployees[empId] = employee
    }

    fun deleteEmployee(empId: Int) {
        itsEmployees.remove(empId)
    }

    fun removeUnionMember(memberId: Int) {
        itsUnionMembers.remove(memberId)
    }

    fun addUnionMember(memberId: Int, e: Employee?) {
        itsUnionMembers[memberId] = e?.empId!!
    }

    fun getAllEmployee(): List<Employee> {
        return itsEmployees.toList().map { it.second }
    }
}