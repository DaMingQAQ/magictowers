import java.io.IOException;

import javax.swing.JLabel;
//Kevin did Mover Main Hero help and maps
//Jerry did BattleGUI Game GAMEGUI and GUI

public class Main {
	static int floor = 1;
	static int yellow = 5;
	static int red = 0;
	static int blue = 0;
	static int health = 100;
	static int attack = 10;
	static int defense = 10;
	static int matk;
	static int mdfs;
	static int mhealth;
	static JLabel Health = new JLabel("Health:"+health);
	static JLabel Attack = new JLabel("Attack:"+attack);
	static JLabel Defense = new JLabel("Defense:"+defense);
	static JLabel Mhealth = new JLabel("Health:"+mhealth);
	static JLabel Mdfs = new JLabel();
	static JLabel Matk = new JLabel("Attack:"+matk);

	static boolean[] largest = new boolean[11];
	
	static JLabel healths = new JLabel("Health 100");

	static JLabel yellowkeys = new JLabel("* 0");
	static JLabel bluekeys = new JLabel("* 0");
	static JLabel redkeys = new JLabel("* 0");
	static JLabel attacks = new JLabel("Attack 10");

	static JLabel defenses = new JLabel("Defense 10");
	public static void main(String[]args) throws IOException{
	//enter the menu
		new GUI();
	}
}
