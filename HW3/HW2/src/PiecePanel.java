import javax.swing.JLabel;
import javax.swing.JPanel;

public class PiecePanel extends JLabel
{
	Person represented;
	public PiecePanel(Person p)
	{
		represented = p;
	}
	
	public String getName()
	{
		return represented.getFirstName();
	}
	

}
