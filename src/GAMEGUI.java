import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;


public class GAMEGUI extends JFrame{
public GAMEGUI() throws IOException{
	//enter the game
	Game game = new Game();
	setSize(500,500);
	setTitle("Magic Tower");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addKeyListener(game);
	Main.yellowkeys.setBounds(470,41,100,10);
	Main.yellowkeys.setForeground(Color.white);
	add(Main.yellowkeys);
	Main.bluekeys.setBounds(470,75,100,10);
	Main.bluekeys.setForeground(Color.white);
	add(Main.bluekeys);
	Main.redkeys.setBounds(470,109,100,10);
	Main.redkeys.setForeground(Color.white);
	add(Main.redkeys);
//
	Main.attacks.setBounds(405,157,100,10);
	Main.attacks.setForeground(Color.white);
	
	Main.defenses.setBounds(405,217,100,10);
	Main.defenses.setForeground(Color.white);
	
	Main.healths.setBounds(405,343,100,10);
	Main.healths.setForeground(Color.white);
	
	add(Main.attacks);
	add(Main.defenses);
	add(Main.healths);

	add(game);
	setVisible(true);
}
}
