/**
 * Created by Nico on 1/4/2017.
 */
public class Police extends Person implements Employee
{
    public enum policeRole{Patrol, Sargent, Captain, Chief};
    private policeRole role;
    private int salary;
    private int employeeID;
    public static int latestID = 1111;


    public Police(String firstName, String lastName, String phoneNumber, int age, policeRole role, int salary)
    {
        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setRole(role);
        setSalary(salary);
        setEmployeeID(latestID);
        latestID++;
    }

    public Police()
    {
        setAge(25);
        setFirstName("John");
        setLastName("Doe");
        setPhoneNumber("1111111");
        role = policeRole.Patrol;
        setSalary(20000);
        setEmployeeID(latestID);
        latestID++;


    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public void setRole(policeRole role) {
        this.role = role;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public policeRole getPoliceRole() {
        return role;
    }

    public void setPoliceRole(policeRole role) {
        this.role = role;
    }

    public int getSalary()
    {
        return salary;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }
}
