import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Triangle implements Shape {
	private int ID;
	private String kind;
	private int side1;
	private int side2;
	private int side3;
	private String color;
	public int imageHeight = 60;
	public int imageWidth = 60;
	
	
	public Triangle(int ID, String kind, int side1, int side2, int side3, String color)
	{
		setID(ID);
		setKind(kind);
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
		setColor(color);
	}
	
	public String setLabel()
	{
		return (toString() + " \n"
				+ "Color: " + getColor() + " \n"
				+ "Side#1: " + getSide1() + " \n"
				+ "Side#2: " + getSide2() + " \n"
				+ "Side#3: " + getSide3() + " \n"
				+ "Area: " + getArea() + " \n"
				+ "Perimeter " + getPerimeter() + " \n");
	}
	
	public ImageIcon setImage()
	{

		String trianglePath = "/Resources/Triangle.png";
		Image triangle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(trianglePath));
		triangle = triangle.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		ImageIcon tri = new ImageIcon(triangle);
		return tri;
		
	}
	
	public String toString()
	{
		return (getKind() + " ID# " + getID());
	}
	
	public double getArea()
	{
		return (.5*getSide1()*getSide2()*getSide3());
	}
	
	public double getPerimeter()
	{
		return (getSide1() + getSide2() + getSide3());
	}
	
	public String getDetailString()
	{
		return (toString() + "\n" + "Color : " + getColor());
	}
	
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	public void setSide1(int side1)
	{
		this.side1 = side1;
	}
	
	public void setSide2(int side2)
	{
		this.side2 = side2;
	}
	
	public void setSide3(int side3)
	{
		this.side3 = side3;
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
	
	public int getSide1()
	{
		return side1;
	}
	
	public int getSide2()
	{
		return side2;
	}
	
	public int getSide3()
	{
		return side3;
	}
	
	public String getColor()
	{
		return color;
	}

}
