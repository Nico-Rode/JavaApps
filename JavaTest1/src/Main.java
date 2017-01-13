import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
	
	private static Map<Integer, Shape> listOfShapes = new HashMap<Integer, Shape>(); //Main data structure of the project
	//Used for creating all of the buttons and hashing the shape's ID to the actual shape object
	JFrame frame;
	
	public static void main(String[] args)
	{
		Main m = new Main();
	}
	
	public Main()
	{
		initialize();
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300,100));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Shape Information:");
		panel_1.add(lblNewLabel);
		
		
		JPanel panel = new JPanel();
		for(int i : listOfShapes.keySet()) //This goes through all of the shapes and creates a button and an action for each shape.
		{
			JButton shapeButton = new JButton(listOfShapes.get(i).toString());
			shapeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Shape shape = listOfShapes.get(i);
					lblNewLabel.setText(shape.setLabel()); //implemented in each class to display the relevant properties of each shape
					lblNewLabel.setIcon(shape.setImage()); //implemented in each class to set the Image of each shape
					
				}
			});
			panel.add(shapeButton);
			panel.revalidate();
			
		}
		frame.getContentPane().add(scrollPane, BorderLayout.WEST);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		
		
		
		frame.setVisible(true);
	}
	
	public void initialize()
	{
		try
		{
			//Opted to do the txt file and just brute force grabbing the data. Not the best. 
			String path = System.getProperty("user.dir");
			path = path+"\\src\\shapes.txt";
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] part = line.split(":");
				//Created functions for each type of shape; part[0] refers to the type of shape
				String shape = part[0];
				if (shape.equals("rectangle"))
				{
					addRectangle(line);
				}
				else if (shape.equals("square"))
				{
					addSquare(line);
				}
				else if (shape.equals("circle"))
				{
					addCircle(line);
				}
				else if (shape.equals("triangle"))
				{
					addTriangle(line);
				}
				else
					System.out.print("NOPE\n");
				
				
				
			}
			scanner.close();
		}
		catch(Exception ex) {System.out.print(ex);}
	}
	
	//the String[] array's indicies have different values based on the type of shape, then they're passed into the relevant argument parameters.
	public void addTriangle(String triangleInfo)
	{
		String[] shape = triangleInfo.split(":");
		String[] shape2 = triangleInfo.split(" ");
		Triangle tri = new Triangle(Integer.parseInt(shape2[1]), shape[0], Integer.parseInt(shape2[2]), Integer.parseInt(shape2[3]), Integer.parseInt(shape2[4]), shape2[5]);
		listOfShapes.put(Integer.parseInt(shape2[1]), tri);
	}
	
	public void addSquare(String squareInfo)
	{
		String[] shape = squareInfo.split(":");
		String[] shape2 = squareInfo.split(" ");
		Square square = new Square(Integer.parseInt(shape2[1]), shape[0], Integer.parseInt(shape2[2]), shape2[3]);
		listOfShapes.put(Integer.parseInt(shape2[1]), square);
	}
	
	public void addCircle(String circleInfo)
	{
		String[] shape = circleInfo.split(":");
		String[] shape2 = circleInfo.split(" ");
		Circle circle = new Circle(Integer.parseInt(shape2[1]), shape[0], Integer.parseInt(shape2[2]), shape2[3]);
		listOfShapes.put(Integer.parseInt(shape2[1]), circle);
	}
	
	public void addRectangle(String rectangleInfo)
	{
		String[] shape = rectangleInfo.split(":");
		String[] shape2 = rectangleInfo.split(" ");
		Rectangle rect = new Rectangle(Integer.parseInt(shape2[1]), shape[0], Integer.parseInt(shape2[2]), Integer.parseInt(shape2[3]), shape2[4]);
		listOfShapes.put(Integer.parseInt(shape2[1]), rect);
	}

}
