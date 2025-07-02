/**
 * Represents an Employee with basic information and operations.
 * This class manages employee data following standard Java coding conventions.
 *
 * @author Grok
 * @version 1.0
 * @since 2025-06-30
 */
public class Employee {
    // Constants
    private static final int MAX_NAME_LENGTH = 50;
    private static final double MIN_SALARY = 0.0;

    // Instance variables
    private final String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private Department department;

    /**
     * Constructs an Employee with the specified details.
     *
     * @param employeeId unique identifier for the employee
     * @param firstName  employee's first name
     * @param lastName   employee's last name
     * @param salary     employee's monthly salary
     * @throws IllegalArgumentException if parameters are invalid
     */
    public Employee(String employeeId, String firstName, String lastName, double salary) {
        validateEmployeeId(employeeId);
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validateSalary(salary);

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    /**
     * Validates the employee ID.
     *
     * @param employeeId the ID to validate
     * @throws IllegalArgumentException if ID is null or empty
     */
    private void validateEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
    }

    /**
     * Validates a name string.
     *
     * @param name     the name to validate
     * @param fieldName the field name for error messages
     * @throws IllegalArgumentException if name is invalid
     */
    private void validateName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(fieldName + " cannot exceed " + MAX_NAME_LENGTH + " characters");
        }
    }

    /**
     * Validates the salary amount.
     *
     * @param salary the salary to validate
     * @throws IllegalArgumentException if salary is negative
     */
    private void validateSalary(double salary) {
        if (salary < MIN_SALARY) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }

    /**
     * Gets the employee's full name.
     *
     * @return concatenated first and last name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First name");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last name");
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        validateSalary(salary);
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Represents a department within the organization.
     */
    public enum Department {
        ENGINEERING,
        HR,
        FINANCE,
        MARKETING
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return string containing employee details
     */
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", salary=" + salary +
                ", department=" + (department != null ? department : "Not assigned") +
                '}';
    }

    /**
     * Checks if two employees are equal based on their employeeId.
     *
     * @param obj the object to compare with
     * @return true if the employees have the same ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        return employeeId.equals(other.employeeId);
    }

    /**
     * Generates a hash code for the employee.
     *
     * @return hash code based on employeeId
     */
    @Override
    public int hashCode() {
        return employeeId.hashCode();
    }
}
