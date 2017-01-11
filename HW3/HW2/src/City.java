import java.util.ArrayList;

/**
 * Created by Nico on 1/4/2017.
 */
public class City
{
    public ArrayList<Building> listOfBuildings = new ArrayList<Building>();
    public ArrayList<Person> listOfPeople = new ArrayList<Person>();

    public void getListOfPeople() {
        for (Building b : listOfBuildings)
        {
            System.out.print(b.getNumberOfOccupants());
        }
    }

    public ArrayList<Building> getListOfBuildings()
    {
        return listOfBuildings;
    }

     public void addBuilding(Building b)
     {
         listOfBuildings.add(b);
     }

     public void addPerson(Person p)
     {
         listOfPeople.add(p);
     }
}
