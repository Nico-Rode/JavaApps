/**
 * Created by Nico on 1/4/2017.
 */
public class Teacher extends Person implements Employee
{

    private String gradeLevel;
    private String certification;
    private int salary;
    private int employeeID;
    public static int latestID = 1111;

    public Teacher(String firstName, String lastName, String phoneNumber, int age, String gradeLevel,String certification, int employeeID, int salary)
    {
        setGradeLevel(gradeLevel);
        setCertification(certification);
        setSalary(salary);
        setEmployeeID(latestID);
        latestID++;

        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public Teacher()
    {
        setGradeLevel("NA");
        setCertification("NA");
        setSalary(20000);
        setEmployeeID(latestID);
        latestID++;

        setAge(0);
        setFirstName("John");
        setLastName("Doe");
        setPhoneNumber("1111111");
    }




    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }


    public int getSalary()
    {
        return salary;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public String getCertification() {
        return certification;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
