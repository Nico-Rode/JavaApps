import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Rectangle implements Shape {

	private int ID;
	private String kind;
	private int length;
	private int width;
	private String color;
	public int imageHeight = 60;
	public int imageWidth = 60;
	
	public Rectangle(int ID, String kind, int length, int width, String color)
	{
		setID(ID);
		setKind(kind);
		setLength(length);
		setWidth(width);
		setColor(color);
	}
	
	public String setLabel()
	{
		return (toString() + " \n"
				+ "Color: " + getColor() + " \n"
				+ "Length: " + getLength() + " \n"
				+ "Width: " + getWidth() + " \n"
				+ "Area: " + getArea() + " \n"
				+ "Perimeter " + getPerimeter() + " \n");
	}
	
	public String toString()
	{
		return (getKind() + " ID# " + getID());
	}
	
	public ImageIcon setImage()
	{

		String RectanglePath = "/Resources/Rectangle.png";
		Image rectangle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(RectanglePath));
		rectangle = rectangle.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		ImageIcon rectangleIcon = new ImageIcon(rectangle);
		return rectangleIcon;
		
	}
	
	public String getDetailString()
	{
		return (toString() + "\n" + "Color : " + getColor() + "\n Area: " + getArea());
	}
	
	public int getPerimeter()
	{
		return ((length*2)+(width*2));
	}
	
	public int getArea()
	{
		return (length*width);
	}
	
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
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
	
	public int getLength()
	{
		return length;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public String getColor()
	{
		return color;
	}
	

	
}
