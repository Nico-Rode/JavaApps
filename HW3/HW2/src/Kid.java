/**
 * Created by Nico on 1/4/2017.
 */
public class Kid extends Person
{
    private String favoriteCandy;

    public Kid(String firstName, String lastName, String phoneNumber, int age, String favoriteCandy)
    {
        setFavoriteCandy(favoriteCandy);

        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public void setFavoriteCandy(String favoriteCandy) {
        this.favoriteCandy = favoriteCandy;
    }

    public String getFavoriteCandy() {
        return favoriteCandy;
    }

    public Kid()
    {
        setFavoriteCandy("Twizzlers");
        setAge(12);
        setFirstName("Jane");
        setLastName("Doe");
        setPhoneNumber("1111111");


    }
}
