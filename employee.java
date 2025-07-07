public class employee // Violation 1: Class name should be PascalCase (Employee), not lowercase
{
    private static final int MAX_NAME_LENGTH = 50; // Fixed naming, but kept for context
    private static final double min_salary = 0.0; // Violation 2: Inconsistent naming (should be MIN_SALARY, all caps for constants)
    private String emp_id; // Violation 3: Non-descriptive name (emp_id) and missing final for immutable field
    private String FIRST_NAME; // Violation 4: Non-standard naming (all caps, should be firstName)
    private String LastName; // Violation 5: Inconsistent naming (should be lastName, not PascalCase)
    private double Salary; // Violation 6: Should be camelCase (salary), not PascalCase
    private Department d; // Violation 7: Abbreviated, non-descriptive name (d)

    // Violation 8: Missing Javadoc for constructor
    public employee(String emp_id,String fname,String lname,double Salary) // Violation 9: No spaces after commas
    {
        if(emp_id == null || emp_id.trim().isEmpty()) // Violation 10: Missing spaces around operators
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        if(fname == null || fname.trim().isEmpty()) // Violation 11: Missing spaces around operators
            throw new IllegalArgumentException("First name cannot be null or empty");
        if(lname == null || lname.trim().isEmpty()) // Violation 12: Missing spaces around operators
            throw new IllegalArgumentException("Last name cannot be null or empty");
        if(Salary < min_salary) // Violation 13: Single-line if without braces
            throw new IllegalArgumentException("Salary cannot be negative");
        
        this.emp_id = emp_id;
        FIRST_NAME = fname;
        LastName = lname;
        this.Salary = Salary;
    }

    // Violation 14: Missing Javadoc for method
    public String get_full_name() // Violation 15: Non-standard method name (should be getFullName)
    {
        return FIRST_NAME + " " + LastName; // Violation 16: Inconsistent variable naming usage
    }

    public String getEmp_id() // Violation 17: Inconsistent method naming (should be getEmpId)
    {
        return emp_id;
    }

    // Violation 18: Missing Javadoc for method
    public void setFirstName(String FIRST_NAME) // Violation 19: Parameter name should be camelCase (firstName)
    {
        if(FIRST_NAME == null || FIRST_NAME.trim().isEmpty()) // Violation 20: Missing spaces around operators
            throw new IllegalArgumentException("First name cannot be null or empty");
        this.FIRST_NAME = FIRST_NAME; // Violation 21: Inconsistent naming
    }

    public String getLastName() { return LastName; } // Violation 22: Single-line method, could use consistent formatting
    public void setLastName(String LastName) { this.LastName = LastName; } // Violation 23: Parameter name should be camelCase (lastName)
    public double getSalary() { return Salary; } // Violation 24: Inconsistent variable naming
    public void setSalary(double Salary) { this.Salary = Salary; } // Violation 25: Parameter name should be camelCase (salary)
    public Department getDepartment() { return d; } // Violation 26: Non-descriptive variable name (d)
    public void setDepartment(Department d) { this.d = d; } // Violation 27: Non-descriptive parameter name (d)

    public enum department {ENG,HR,FIN,SALES} // Violation 28: Enum name should be PascalCase (Department), values should be all caps

    // Violation 29: Missing @Override annotation
    public String toString()
    {
        return "employee[id=" + emp_id + ",name=" + FIRST_NAME + " " + LastName + "]"; // Violation 30: No spaces around concatenation operators
    }

    // Violation 31: Missing Javadoc for method
    public boolean equals(Object OBJ) // Violation 32: Parameter name should be lowercase (obj)
    {
        if(this == OBJ) return true;
        if(!(OBJ instanceof employee)) return false; // Violation 33: Inconsistent class name usage
        employee other = (employee)OBJ; // Violation 34: Inconsistent naming
        return emp_id.equals(other.emp_id);
    }

    // Violation 35: Single-line method, missing Javadoc
    public int hashCode() { return emp_id.hashCode(); }
}
