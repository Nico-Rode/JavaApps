import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JFrame;

/**
 * Created by Nico on 1/4/2017.
 */
public class TestCase extends JComponent implements MouseMotionListener
{

	int imageX, imageY;
	Image cityHall, school, field, kid, teacher, police;
	static int imageWidth = 60, imageHeight = 60;
	Person[] listOfPeople = {new Teacher(), new Teacher(), new Teacher(),
        	new Police(), new Police(), new Police(),
        	new Kid(), new Kid(), new Kid()};
	Building[] listOfBuildings = {new School(), new CityHall()};
	City MountainView = new City();
	
	Person[] listOfDisplayPeople = {new Police("Nico", "Rode", "6699683", 21, Police.policeRole.Captain, 90000), new Police("Timo", "Rode", "2791247", 26, Police.policeRole.Patrol, 70000),
			new Police("Brad", "Rode", "9960178", 57, Police.policeRole.Sargent, 100000), new Teacher("Maddie", "Rode", "2249029", 24,"High School", "Bachelors Degree", 1111, 60000), 
			new Teacher("Judy", "Rode", "2247970", 59,"Junior High", "Bachelors Degree", 1112, 70000)};
	
	ImageIcon iconPolice;
	ImageIcon iconTeacher;
	ImageIcon iconKid;
	
	JButton cityHallImage;
	JButton schoolImage;
	
	JFrame frame;
	int x_pressed = 0;
	int y_pressed = 0;
	
    public static void main(String[] args)
    {  
       	String field = "/Resources/Field.png";
		String school = "/Resources/school.png";
		String police = "/Resources/Police.png";
		String kid = "/Resources/Student.png";
		String cityHall = "/Resources/TownHall.png";
		String teacher = "/Resources/teacher.png";
		
		
		Image iField = Toolkit.getDefaultToolkit().getImage(TestCase.class.getResource(field));
		
		Image iKid = Toolkit.getDefaultToolkit().getImage(TestCase.class.getResource(kid));
		iKid = iKid.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		
		Image iCityHall = Toolkit.getDefaultToolkit().getImage(TestCase.class.getResource(cityHall));
		iCityHall = iCityHall.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		
		Image iSchool = Toolkit.getDefaultToolkit().getImage(TestCase.class.getResource(school));
		iSchool = iSchool.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		
		Image iTeacher = Toolkit.getDefaultToolkit().getImage(TestCase.class.getResource(teacher));
		iTeacher = iTeacher.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		
		Image iPolice = Toolkit.getDefaultToolkit().getImage(TestCase.class.getResource(police));
		iPolice = iPolice.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
       
       TestCase m = new TestCase(iCityHall, iSchool, iField, iKid, iTeacher, iPolice);
    }
    
    public void takePersonOut(String Building, JPanel panel, JLabel lblInformation)
    {
    	Person p;
    	Image iPerson;
    	if (Building == "School" && (listOfBuildings[0].numberOfOccupants.size() > 0))
    	{
    		p = listOfBuildings[0].getTopOccupant();
    		listOfBuildings[0].deleteOccupant();
    		if (p instanceof Kid)
    		{
    			PiecePanel kid = new PiecePanel(p);
    			panel.add(kid);
    			kid.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mousePressed(MouseEvent e) {
    					x_pressed = e.getX();
    					y_pressed = e.getY();
    				}
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					lblInformation.setText(kid.represented.getFirstName());
    				}
    			});
    			kid.addMouseMotionListener(new MouseMotionAdapter() {
    				@Override
    				public void mouseDragged(MouseEvent e) {
    					kid.setLocation(e.getXOnScreen(), e.getYOnScreen());
    					if ((e.getXOnScreen() > 5 && e.getXOnScreen() < 80) && (e.getYOnScreen() > 30 && e.getY() < 274))
    					{
    						listOfBuildings[0].addOccupant(kid.represented);
    						panel.remove(kid);
    					}
    				}
    			});
    			kid.setIcon(iconKid);
    		}
    		if (p instanceof Teacher)
    		{
    			PiecePanel teacher = new PiecePanel(p);
    			panel.add(teacher);
    			teacher.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mousePressed(MouseEvent e) {
    					x_pressed = e.getX();
    					y_pressed = e.getY();
    				}
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					lblInformation.setText(teacher.represented.getFirstName());
    				}
    			});
    			teacher.addMouseMotionListener(new MouseMotionAdapter() {
    				@Override
    				public void mouseDragged(MouseEvent e) {
    					teacher.setLocation(e.getXOnScreen(), e.getYOnScreen());
    					if ((e.getXOnScreen() > 5 && e.getXOnScreen() < 80) && (e.getYOnScreen() > 30 && e.getY() < 274))
    					{
    						listOfBuildings[0].addOccupant(teacher.represented);
    						panel.remove(teacher);
    					}
    				}
    			});
    			teacher.setIcon(iconKid);
    		}
    	}
    	
    	if (Building == "CityHall" && (listOfBuildings[1].numberOfOccupants.size() > 0))
    	{
    		p = listOfBuildings[1].getTopOccupant();
    		listOfBuildings[1].deleteOccupant();
    		
    		if (p instanceof Police)
    		{
    			PiecePanel police = new PiecePanel(p);
    			panel.add(police);
    			police.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mousePressed(MouseEvent e) {
    					x_pressed = e.getX();
    					y_pressed = e.getY();
    				}
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					lblInformation.setText(police.represented.getFirstName());
    				}
    			});
    			police.addMouseMotionListener(new MouseMotionAdapter() {
    				@Override
    				public void mouseDragged(MouseEvent e) {
    					police.setLocation(e.getXOnScreen(), e.getYOnScreen());
    					if ((e.getXOnScreen() > 274 && e.getXOnScreen() < 400) && (e.getYOnScreen() > 5 && e.getY() < 105))
    					{
    						listOfBuildings[1].addOccupant(police.represented);
    						panel.remove(police);
    					}
    				}
    			});
    			police.setIcon(iconPolice);
    		}
    	}
    	
    }
    
    public TestCase(Image iCityHall, Image iSchool, Image iField, Image iKid, Image iTeacher, Image iPolice)
    {
    	school = iSchool;
    	field = iField;
    	kid = iKid;
    	cityHall = iCityHall;
    	teacher = iTeacher;
    	police = iPolice;
    	ImageIcon iconSchool = new ImageIcon(school);
    	ImageIcon iconCityHall = new ImageIcon(cityHall);
    	ImageIcon iconField = new ImageIcon(field);
    	iconPolice = new ImageIcon(police);
    	iconTeacher = new ImageIcon(teacher);
    	iconKid = new ImageIcon(kid);
    	
    	
    	
	
    	initialize(listOfPeople,listOfBuildings, MountainView);
    	
    	
    	
    	
    	
    	
    	frame = new JFrame("DragImage");
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		JLabel lblInformation = new JLabel("");
		panel_1.add(lblInformation);

		
		schoolImage = new JButton("");
		schoolImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				takePersonOut("School", panel, lblInformation);
				String output = "There are " + listOfBuildings[0].getNumberOfOccupants() + " people in this building";
				lblInformation.setText(output);
			}
		});
		schoolImage.setIcon(iconSchool);
		panel.add(schoolImage);
		
		PiecePanel teacher1 = new PiecePanel(listOfDisplayPeople[3]);
		panel.add(teacher1);
		teacher1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x_pressed = e.getX();
				y_pressed = e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInformation.setText(teacher1.represented.getFirstName());
			}
		});
		teacher1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				teacher1.setLocation(e.getXOnScreen(), e.getYOnScreen());
				if ((e.getXOnScreen() > 5 && e.getXOnScreen() < 80) && (e.getYOnScreen() > 30 && e.getY() < 274))
				{
					listOfBuildings[0].addOccupant(teacher1.represented);
					panel.remove(teacher1);
				}
			}
		});
		teacher1.setIcon(iconTeacher);
		
		PiecePanel teacher2 = new PiecePanel(listOfDisplayPeople[4]);
		panel.add(teacher2);
		teacher2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x_pressed = e.getX();
				y_pressed = e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInformation.setText(teacher2.represented.getFirstName());
			}
		});
		teacher2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				teacher2.setLocation(e.getXOnScreen(), e.getYOnScreen());
				if ((e.getXOnScreen() > 5 && e.getXOnScreen() < 80) && (e.getYOnScreen() > 30 && e.getY() < 274))
				{
					listOfBuildings[0].addOccupant(teacher2.represented);
					panel.remove(teacher2);
				}
			}
		});
		teacher2.setIcon(iconTeacher);
		
		
		
		
		
		
		
		
		
		
		//JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		
		cityHallImage = new JButton("");
		cityHallImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takePersonOut("CityHall", panel, lblInformation);
				String output = "There are " + listOfBuildings[1].getNumberOfOccupants() + " people in this building";
				lblInformation.setText(output);
			}
		});
		panel.add(cityHallImage);
		cityHallImage.setIcon(iconCityHall);
		
		
		PiecePanel police1 = new PiecePanel(listOfDisplayPeople[0]);
		panel.add(police1);
		police1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x_pressed = e.getX();
				y_pressed = e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInformation.setText(police1.represented.getFirstName());
			}
		});
		police1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				police1.setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
				if ((e.getXOnScreen() > 274 && e.getXOnScreen() < 400) && (e.getYOnScreen() > 5 && e.getY() < 105))
				{
					listOfBuildings[1].addOccupant(police1.represented);
					panel.remove(police1);
				}
			}
		});
		police1.setIcon(iconPolice);
		
		PiecePanel police2 = new PiecePanel(listOfDisplayPeople[1]);
		panel.add(police2);
		police2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x_pressed = e.getX();
				y_pressed = e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInformation.setText(police2.represented.getFirstName());
			}
		});
		police2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				police2.setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
				if ((e.getXOnScreen() > 274 && e.getXOnScreen() < 400) && (e.getYOnScreen() > 5 && e.getY() < 105))
				{
					listOfBuildings[1].addOccupant(police2.represented);
					panel.remove(police2);
				}
			}
		});
		police2.setIcon(iconPolice);
		
		PiecePanel police3 = new PiecePanel(listOfDisplayPeople[2]);
		panel.add(police3);
		police3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x_pressed = e.getX();
				y_pressed = e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInformation.setText(police3.represented.getFirstName());
			}
		});
		police3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				police3.setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
				if ((e.getXOnScreen() > 274 && e.getXOnScreen() < 400) && (e.getYOnScreen() > 5 && e.getY() < 105))
				{
					listOfBuildings[1].addOccupant(police3.represented);
					panel.remove(police3);
				}
			}
		});
		police3.setIcon(iconPolice);
		frame.setVisible(true);
    
    	
    	
    	
    }
    
    public void mouseDragged(MouseEvent e)
	{
		imageX = e.getX();
		imageY = e.getY();
		repaint();
	}
    
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(field, 0, 0, this);
		g2.drawImage(school,  20,  20,  this);
		g2.drawImage(cityHall, 550, 300, this);
	}
    
    public static void initialize(Person[] listOfPeople, Building[] listOfBuildings, City MountainView)
    {


		for (Person p : listOfPeople)
		{
			if (p instanceof Teacher || p instanceof Kid)
				listOfBuildings[0].addOccupant(p);
			if (p instanceof Police)
				listOfBuildings[1].addOccupant(p);
		}
		for (Building b : listOfBuildings)
		{
			MountainView.addBuilding(b);
		}
    	
    }
    public void mouseMoved(MouseEvent e)
	{
		
	}
    

}

