import employee.Employee

object PayrollDatabase {
    private var itsEmployees: MutableMap<Int, Employee?> = HashMap()

    fun getEmployee(empId: Int): Employee? {
        return itsEmployees?.get(empId)
    }

    fun addEmployee(empId: Int, employee: Employee) {
        itsEmployees?.put(empId, employee)
    }

    fun deleteEmployee(empId: Int) {
        itsEmployees?.put(empId, null)
    }

    fun clear() {
        itsEmployees = HashMap()
    }
}