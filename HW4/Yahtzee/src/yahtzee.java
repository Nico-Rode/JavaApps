import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class yahtzee extends JFrame {

	public ImageIcon oneIcon;
	public ImageIcon twoIcon;
	public ImageIcon threeIcon;
	public ImageIcon fourIcon;
	public ImageIcon fiveIcon;
	public ImageIcon sixIcon;
	public ImageIcon[] arrayOfIcons = new ImageIcon[6];
	static JPanel panel_1;
	
	public yahtzee()
	{
		initialize();
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		
		JButton btnNewButton = new JButton("Roll!");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roll(panel);
		}});
		
	}
	
	public void roll(JPanel panel)
	{
		Thread[] threadTest = new Thread[6];
		dice[] diceRolls = new dice[6];
		for (int i = 0; i < 6; i++)
		{
			JLabel l = new JLabel(Integer.toString(i));
			diceRolls[i] = new dice(l, arrayOfIcons);
			panel.add(l);
		}
		
		for (int i = 0; i < 6; i++)
		{
			threadTest[i] = new Thread(diceRolls[i]);
			threadTest[i].start();
			
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException ex) {System.out.print(ex);}
		}
		JLabel finals = new JLabel();
		try
		{
			Random rand = new Random();
			int r = rand.nextInt(5);
			finals = (JLabel)panel.getComponent(r);
		}
		catch (Exception ex) {;}
		panel_1.add(finals);
	}
	
	
	public void initialize()
	{
		String onePath = "/Resources/1-dice.png";
		Image oneImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(onePath));
		oneImage = oneImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		oneIcon = new ImageIcon(oneImage);
		
		String twoPath = "/Resources/2-dice.png";
		Image twoImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(twoPath));
		twoImage = twoImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		twoIcon = new ImageIcon(twoImage);
		
		String threePath = "/Resources/3-dice.png";
		Image threeImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(threePath));
		threeImage = threeImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		threeIcon = new ImageIcon(threeImage);
		
		String fourPath = "/Resources/4-dice.png";
		Image fourImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(fourPath));
		fourImage = fourImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		fourIcon = new ImageIcon(fourImage);
		
		String fivePath = "/Resources/5-dice.png";
		Image fiveImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(fivePath));
		fiveImage = fiveImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		fiveIcon = new ImageIcon(fiveImage);
		
		String sixPath = "/Resources/6-dice.png";
		Image sixImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(sixPath));
		sixImage = sixImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		sixIcon = new ImageIcon(sixImage);
		
		arrayOfIcons[0] = oneIcon;
		arrayOfIcons[1] = twoIcon;
		arrayOfIcons[2] = threeIcon;
		arrayOfIcons[3] = fourIcon;
		arrayOfIcons[4] = fiveIcon;
		arrayOfIcons[5] = sixIcon;
		
	}
	
	public static void main(String[] args)
	{
		yahtzee test = new yahtzee();
		
	}
	
	
	
	
	
}

class dice implements Runnable
{
	private JLabel label;
	public ImageIcon[] arrayOfIcons = new ImageIcon[6];
	
	public dice(JLabel label, ImageIcon[] array)
	{
		this.label = label;
		for (int i = 0; i < 6; i++)
		{
			arrayOfIcons[i] = array[i];
		}
	}
	
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			Random rand = new Random();
			int n = rand.nextInt(6);
			System.out.print(n + " Current Thread : " + Thread.currentThread().getName() + "\n" );
			this.label.setIcon(arrayOfIcons[n]);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException ex) {System.out.print(ex);}
			
			
		}
	}
}