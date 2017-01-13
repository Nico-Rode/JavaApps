import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Circle implements Shape{

	private int ID;
	private String kind;
	private int radius;
	private String color;
	public int imageHeight = 60;
	public int imageWidth = 60;
	
	public Circle(int ID, String kind, int radius, String color)
	{
		setID(ID);
		setKind(kind);
		setRadius(radius);
		setColor(color);
	}
	
	public String setLabel()
	{
		return (toString() + " \n"
				+ "Color: " + getColor() + " \n"
				+ "Radius: " + getRadius() + " \n"
				+ "Area: " + getArea() + " \n"
				+ "Circum " + getPerimeter() + " \n");
	}
	
	public ImageIcon setImage()
	{

		String circlePath = "/Resources/Circle.png";
		Image circle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(circlePath));
		circle = circle.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		ImageIcon circleIcon = new ImageIcon(circle);
		return circleIcon;
		
	}
	
	public double getArea()
	{
		return (3.141596 * getRadius()*getRadius());
	}
	
	public double getPerimeter()
	{
		return (2*3.141596*getRadius());
	}
	
	public String toString()
	{
		return (getKind() + " ID# " + getID());
	}
	
	public String getDetailString()
	{
		return (toString() + "\n" + "Color : " + getColor() + "\n Radius: " + getRadius());
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	public void setRadius(int radius)
	{
		this.radius = radius;
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
	
	public int getRadius()
	{
		return radius;
	}
	
	public String getColor()
	{
		return color;
	}
	
	
}
