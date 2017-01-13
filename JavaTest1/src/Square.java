import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Square implements Shape {
	
	private int ID;
	private String kind;
	private int sides;
	private String color;
	public int imageHeight = 60;
	public int imageWidth = 60;
	
	public Square(int ID, String kind, int sides, String color)
	{
		setID(ID);
		setKind(kind);
		setSides(sides);
		setColor(color);
	}
	
	public String setLabel()
	{
		return (toString() + " \n"
				+ "Color: " + getColor() + " \n"
				+ "Sides: " + getSides() + " \n"
				+ "Area: " + getArea() + " \n"
				+ "Perimeter " + getPerimeter() + " \n");
	}
	
	public ImageIcon setImage()
	{

		String squarePath = "/Resources/Square.jpg";
		Image square = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(squarePath));
		square = square.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		ImageIcon squareIcon = new ImageIcon(square);
		return squareIcon;
		
	}
	
	public int getArea()
	{
		return (getSides() * getSides());
	}
	
	public int getPerimeter()
	{
		return (getSides()*4);
	}
	
	public String toString()
	{
		return (getKind() + " ID# " + getID());
	}
	
	public String getDetailString()
	{
		return (toString() + "\n" + "Color : " + getColor() + "\n sides: " + getSides());
	}
	
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	public void setSides(int sides)
	{
		this.sides = sides;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}

	public int getID()
	{
		return ID;
	}
	
	public String getKind()
	{
		return kind;
	}
	
	public int getSides()
	{
		return sides;
	}
	
	public String getColor()
	{
		return color;
	}
	

}
