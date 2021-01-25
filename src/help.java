import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class help extends JFrame implements ActionListener{
	
	JLabel help = new JLabel("How to play Magic Tower");
	JPanel panel = new JPanel();
	ImageIcon option = new ImageIcon("Image/Z.jpg");
	JLabel label1 = new JLabel();
	JButton startgame = new JButton("GO!");
	
	JLabel how = new JLabel("<html><body>Press the buttons to move up down right and left.<br>You will find your self inside a large maze.<br>Your mission is to resue the princess.<br>There are lots of monsters inside the tower.<br>If you won each battle you will earn coins.<br>Remember to collect three different keys and purchase enough life points .<br>Good Luck!</body></html>");
	public help()throws IOException{
		
	    label1 = new JLabel(option);
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		help.setBounds(175,15,250,200);
		help.setFont(new Font("Monotype Corsiva",30,26));
		help.setForeground(Color.white);

        label1.setBounds(200,320,200,200);
        
        how.setBounds(300,100,300,300);
		how.setForeground(Color.white);

        startgame.setBounds(50,350,100,50);
        startgame.addActionListener(this);
        panel.setBackground(Color.black);
       

        panel.add(help);
        panel.add(how);
        add(startgame);
        panel.add(label1);

        add(panel);

		
	}
	public void actionPerformed(ActionEvent e) {
		//if button clicked enter the game
		if(e.getSource() == startgame){
			try {
				new GAMEGUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);}
	}
	

	

}
