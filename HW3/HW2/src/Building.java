import java.util.ArrayList;

/**
 * Created by Nico on 1/4/2017.
 */
public class Building
{
    private String name;
    private String address;
    public ArrayList<Person> numberOfOccupants = new ArrayList<Person>();

    public Building(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public Building()
    {
        name = "";
        address = "";
    }
    
    public Person getTopOccupant()
    {
    	return numberOfOccupants.get((numberOfOccupants.size()-1));
    }
    
    public void deleteOccupant()
    {
    	numberOfOccupants.remove((numberOfOccupants.size()-1));
    }

    public String getName() {
        return name;
    }

    public void addOccupant(Person p)
    {
        numberOfOccupants.add(p);
    }

    public String getNumberOfOccupants() {
        return Integer.toString(numberOfOccupants.size());
    }

    public void printNames()
    {
        for (Person p : numberOfOccupants)
        {
            System.out.print(p.getFirstName());
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
