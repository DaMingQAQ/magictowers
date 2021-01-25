import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
public class GUI extends JFrame implements ActionListener {

	JLabel title = new JLabel("Magic Tower");
	JLabel Version = new JLabel("Version 1.0");
	JButton startgame = new JButton("Start");
	JButton help = new JButton("Help");
	JButton Exit = new JButton("Exit");
	JPanel panel = new JPanel();
	
	
	public GUI()throws IOException{

		title.setBounds(250,100,150,50);
		title.setFont(new Font("Monotype Corsiva",30,26));
		title.setForeground(Color.white);
		
		setTitle("Magic Tower Version 1.0");
		
		Version.setBounds(350,150,150,50);
		Version.setFont(new Font("Monotype Corsiva",30,20));
		Version.setForeground(Color.white);
		
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startgame.setBounds(200,230,200,40);
		help.setBounds(200,300,200,40);
		Exit.setBounds(200,370,200,40);
		setVisible(true);
		
		startgame.addActionListener(this);
		help.addActionListener(this);
		Exit.addActionListener(this);
        panel.setBackground(Color.black);
        add(startgame);
		add(help);
		add(Exit);
		add(title);
		add(Version);
		add(panel);

	}

	public void actionPerformed(ActionEvent e) {
		//if start game start the game
		if(e.getSource() == startgame){
			try {
				new GAMEGUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);}
		// if help than go to help class
		if(e.getSource() == help){
			try {
				new help();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);}
		if(e.getSource() == Exit)
			setVisible(false);		
	}	
}