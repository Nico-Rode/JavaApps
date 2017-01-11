/**
 * Created by Nico on 1/4/2017.
 */
public class Person
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;

    public Person()
    {
        firstName = "John";
        lastName = "Doe";
        phoneNumber = "";
        age = 0;
    }

    public Person(String firstName, String lastName, String phoneNumber, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
