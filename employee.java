public class Employee //no javadoc 
{
private static final int max_name_length=50; // inconsistent naming
private static final double MinSalary=0.0; // inconsistent naming
private final String ID; // unclear variable name
private String FIRSTNAME; // all caps, non-standard
private String lastName;
private double salary;
private Department dept; // abbreviated name
/**
 * Constructs an Employee with the specified details.
 *
 * @param employeeId unique identifier for the employee
 * @param firstName  employee's first name
 * @param lastName   employee's last name
 * @param salary     employee's monthly salary
 * @throws IllegalArgumentException if parameters are invalid
 */
public Employee(String employeeId,String firstName,String lastName,double salary) //no spaces after commas
{
validateEmployeeId(employeeId);
validateName(firstName,"First name");
validateName(lastName,"Last name");
validateSalary(salary);
ID=employeeId; // no this. prefix
FIRSTNAME=firstName;
lastName=lastName;
this.salary=salary;
}
private void validateEmployeeId(String employeeId){
if(employeeId==null||employeeId.trim().isEmpty()) // missing spaces around operators
throw new IllegalArgumentException("Employee ID cannot be null or empty");
}
private void validateName(String name,String fieldName) // no javadoc
{
if(name==null||name.trim().isEmpty()) // missing spaces
throw new IllegalArgumentException(fieldName+" cannot be null or empty");
if(name.length()>max_name_length)
throw new IllegalArgumentException(fieldName+" cannot exceed "+max_name_length+" characters");
}
private void validateSalary(double salary) //no javadoc
{
if(salary<MinSalary) throw new IllegalArgumentException("Salary cannot be negative"); // single line, no braces
}
public String getFullName(){
return FIRSTNAME+" "+lastName; // inconsistent naming
}
public String getEmployeeId(){
return ID;
}
public String getFirstName(){
return FIRSTNAME;
}
public void setFirstName(String firstName){
validateName(firstName,"First name");
FIRSTNAME=firstName;
}
public String getLastName(){
return lastName;
}
public void setLastName(String lastName){
validateName(lastName,"Last name");
this.lastName=lastName;
}
public double getSalary(){
return salary;
}
public void setSalary(double salary){
validateSalary(salary);
this.salary=salary;
}
public Department getDepartment(){
return dept;
}
public void setDepartment(Department department){
dept=department; // no this. prefix
}
public enum Department{ENGINEERING,HR,FINANCE,MARKETING} // no spacing, no javadoc
public String toString() // no override annotation
{
return "Employee{ID='"+ID+"', fullName='"+getFullName()+"', salary="+salary+", department="+(dept!=null?dept:"Not assigned")+'}'; // overly complex string
}
public boolean equals(Object obj) // no javadoc
{
if(this==obj) return true;
if(!(obj instanceof Employee)) return false;
Employee other=(Employee)obj;
return ID.equals(other.ID);
}
public int hashCode(){return ID.hashCode();} // single line, no javadoc
}