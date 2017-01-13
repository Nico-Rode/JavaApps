import javax.swing.ImageIcon;

public interface Shape {
	
	public String toString();
	public String getKind();
	public String getDetailString();
	public int getID();
	public String setLabel(); //Used this here because every shape needs to set the label, but every shape needs different attributes
	public ImageIcon setImage(); //Same idea as setLabel(), just a function that all Shapes need to implement

}
