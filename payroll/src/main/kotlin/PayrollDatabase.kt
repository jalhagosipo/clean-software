import affiliation.UnionAffiliation
import employee.Employee

object PayrollDatabase {
    private var itsEmployees: MutableMap<Int, Employee?> = HashMap()
    private var itsUnionMembers: MutableMap<Int, Int> = HashMap()

    fun getEmployee(empId: Int): Employee? {
        return itsEmployees?.get(empId)
    }

    fun addEmployee(empId: Int, employee: Employee) {
        itsEmployees?.put(empId, employee)
    }

    fun deleteEmployee(empId: Int) {
        itsEmployees?.remove(empId)
    }

    fun removeUnionMember(memberId: Int) {
        itsUnionMembers?.remove(memberId)
    }

    fun addUnionMember(memberId: Int, e: Employee?) {
        itsUnionMembers[memberId] = e?.empId!!
    }

    fun getAllEmployee(): List<Employee> {
        return itsEmployees.toList().filter{ it.second != null}.map { it.second!! }
    }
}