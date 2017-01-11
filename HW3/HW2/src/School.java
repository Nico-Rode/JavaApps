import java.util.ArrayList;

/**
 * Created by Nico on 1/4/2017.
 */
public class School extends Building
{

    public School(String name, String address)
    {
        setAddress(address);
        setName(name);
    }

    public School()
    {
        setAddress("587 Sleeper ave");
        setName("Huff Elementary");
    }

}
