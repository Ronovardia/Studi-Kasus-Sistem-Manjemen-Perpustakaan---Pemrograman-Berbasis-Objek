class Intern(
    id: String, name: String, val stipend: Double
) : Employee(id, name, 0.0) {
    override var status: EmployeeStatus = EmployeeStatus.Active
    override fun calculateSalary(): Double = stipend
}