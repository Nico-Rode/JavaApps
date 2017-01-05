/**
 * Created by Nico on 1/4/2017.
 */
public class Employee
{
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String fName, String lName, double mSalary)
    {
        firstName = fName;
        lastName = lName;
        if (mSalary < 0)
            monthlySalary = 0;
        else
            monthlySalary = mSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0)
            this.monthlySalary = 0;
        else
            this.monthlySalary = monthlySalary;
    }
}
