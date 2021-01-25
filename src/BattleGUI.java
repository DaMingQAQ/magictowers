import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BattleGUI extends JFrame implements ActionListener{
	private final ImageIcon W = new ImageIcon("Image/Wall.jpg");
	private int damage = 0;
	private int mdamage = 0;
	private final ImageIcon BSK = new ImageIcon("Image/BigSkeleton.jpg");
	private final ImageIcon GRS = new ImageIcon("Image/GreenSlamu.jpg");
	private final ImageIcon HF = new ImageIcon("Image/HeroFront.jpg");
	private final ImageIcon M = new ImageIcon("Image/Monkey.jpg");
	private final ImageIcon RKG = new ImageIcon("Image/RedKing.jpg");
	private final ImageIcon RS = new ImageIcon("Image/RedSlamu.jpg");
	private final ImageIcon SB = new ImageIcon("Image/SmallBat.jpg");
	private final ImageIcon SMG = new ImageIcon("Image/SmallMage.jpg");
	private final ImageIcon SSK = new ImageIcon("Image/SmallSkeleton.jpg");
	private final ImageIcon YG = new ImageIcon("Image/YellorGuard.jpg");
	private final ImageIcon BL = new ImageIcon("Image/Black.GIF");

private Timer battle = new Timer(250,this);

private JLabel label1 = new JLabel(HF);
private JLabel label2 = new JLabel();

JPanel panel = new JPanel();



public BattleGUI() throws IOException{
  
      //start battle if health is larger than 0
       if(Main.health>0 && Main.mhealth > 0){        		
        			battle.start();
       					}
       
        
}





public void actionPerformed(ActionEvent e) {
	//if timer = battle start the act
if(e.getSource()==battle){
	act();
	if(Main.mhealth<1){
		Main.healths.setText("Health "+Main.health);
		setVisible(false);
		battle.stop();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}
}
	

}

public void act(){
	//damage calculation
	Main.health -= mdamage;
	Main.mhealth -= damage;

	graphic();

}
public void graphic(){
	panel.setLayout(null);

	setSize(500,500);
	setTitle("Magic Tower");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setVisible(true);
	//
	add(panel);

	Main.Health.setText("Health:"+Main.health);
	Main.Health.setBounds(50,100,100,30);	
	panel.add(Main.Health);
	Main.Health.setForeground(Color.white);
	
	Main.Attack.setText("Attack:"+Main.attack);
	Main.Attack.setBounds(50,200,100,30);	
	panel.add(Main.Attack);
	Main.Attack.setForeground(Color.white);

	Main.Defense.setText("Defense:"+Main.defense);
	Main.Defense.setBounds(50,300,100,30);	
	panel.add(Main.Defense);
	Main.Defense.setForeground(Color.white);

	Main.Mhealth.setText("Health:"+Main.mhealth);
	Main.Mhealth.setBounds(400,100,100,30);	
	panel.add(Main.Mhealth);
	Main.Mhealth.setForeground(Color.white);

	Main.Matk.setText("Attack:"+Main.matk);
	Main.Matk.setBounds(400,200,100,30);	
	panel.add(Main.Matk);
	Main.Matk.setForeground(Color.white);

	Main.Mdfs.setText("Defense:"+Main.mdfs);
	Main.Mdfs.setBounds(400,300,100,30);	
	panel.add(Main.Mdfs);
	Main.Mdfs.setForeground(Color.white);

//
	
	
		if(Game.name =='E')
		label2 = new JLabel(BSK);
		else if(Game.name =='U')
		label2 = new JLabel(GRS);			
		else if(Game.name =='5')
		label2 = new JLabel(RS);				
		else if(Game.name =='!')
		label2 = new JLabel(SB);				
		else if(Game.name =='@')
		label2 = new JLabel(SMG);				
		else if(Game.name =='#')
		label2 = new JLabel(SSK);				
		else if(Game.name =='&')
		label2 = new JLabel(YG);				
		else if(Game.name =='<')
		label2 = new JLabel(RKG);				

		panel.add(label1);
		panel.add(label2);
		label1.setBounds(150,200,34,34);
		label2.setBounds(300,200,34,34);
      panel.setBackground(Color.black);

      //attack larger than monster defense than damage = attack - defense if not than damage = 1
      if(Main.attack > Main.mdfs)
      	damage =(int) Main.attack-Main.mdfs;
		else damage = 1;
      //monster attack larger than defense than monster damage = attack - defense if not than monster damage = 1

      if(Main.matk > Main.defense)
      	mdamage =(int) Main.matk-Main.defense;
		else mdamage = 1;
}
}
