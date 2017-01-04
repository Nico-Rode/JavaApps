/**
 * Created by Nico on 1/4/2017.
 */
public class TestEmployee
{
    public static void main(String[] args)
    {
        Employee John = new Employee("John","Doe",2000);
        Employee Jane = new Employee("Jane","Doe", 3000);

        //JANE'S INFORMATION
        System.out.print(Jane.getMonthlySalary());
        System.out.print(Jane.getFirstName());
        System.out.print("\n");

        //JOHN"S INFORMATION
        System.out.print(John.getMonthlySalary());
        System.out.print(John.getFirstName());
        System.out.print("\n");

        //Giving John a raise
        double raisedSalary = (John.getMonthlySalary() * .1) + John.getMonthlySalary();
        John.setMonthlySalary(raisedSalary);
        System.out.print("Johns new salary is: ");
        System.out.print(John.getMonthlySalary());
    }
}
