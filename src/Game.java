
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener{

	private Timer gameTimer = new Timer(100, this);
	private Timer animateTimer = new Timer(0,this);
	private final ImageIcon BK = new ImageIcon("Image/BLUEKEY.png");
	private final ImageIcon BSK = new ImageIcon("Image/BigSkeleton.jpg");

	static char name;

	private final ImageIcon BD = new ImageIcon("Image/BlueDoor.jpg");
	private final ImageIcon BP = new ImageIcon("Image/BluePotion.jpg");
	private final ImageIcon BST = new ImageIcon("Image/BlueStone.jpg");
	private final ImageIcon F = new ImageIcon("Image/Floor.jpg");
	private final ImageIcon GRS = new ImageIcon("Image/GreenSlamu.jpg");
	private final ImageIcon HB = new ImageIcon("Image/HeroBack.jpg");
	private final ImageIcon HF = new ImageIcon("Image/HeroFront.jpg");
	private final ImageIcon HL = new ImageIcon("Image/HeroLeft.jpg");
	private final ImageIcon HR = new ImageIcon("Image/HeroRight.jpg");
	private final ImageIcon W = new ImageIcon("Image/Wall.jpg");
	private final ImageIcon L = new ImageIcon("Image/Lava.jpg");
	private final ImageIcon M = new ImageIcon("Image/Monkey.jpg");
	private final ImageIcon PS = new ImageIcon("Image/Princess.jpg");
	private final ImageIcon RD = new ImageIcon("Image/RedDoor.jpg");
	private final ImageIcon RK = new ImageIcon("Image/RedKey.jpg");
	private final ImageIcon RKG = new ImageIcon("Image/RedKing.jpg");
	private final ImageIcon RP = new ImageIcon("Image/RedPotion.jpg");
	private final ImageIcon RS = new ImageIcon("Image/RedSlamu.jpg");
	private final ImageIcon RSN = new ImageIcon("Image/RedStone.jpg");
	private final ImageIcon SB = new ImageIcon("Image/SmallBat.jpg");
	private final ImageIcon SMG = new ImageIcon("Image/SmallMage.jpg");
	private final ImageIcon SSK = new ImageIcon("Image/SmallSkeleton.jpg");
	private final ImageIcon SD = new ImageIcon("Image/StairDown.jpg");
	private final ImageIcon SU = new ImageIcon("Image/StairUp.jpg");
	private final ImageIcon T = new ImageIcon("Image/Ten.jpg");
	private final ImageIcon YD = new ImageIcon("Image/YellowDoor.jpg");
	private final ImageIcon YG = new ImageIcon("Image/YellorGuard.jpg");
	private final ImageIcon YK = new ImageIcon("Image/YellowKey.jpg");
	private final ImageIcon BL = new ImageIcon("Image/Black.GIF");
	
	private JLabel[][] cell = new JLabel[13][17];
	private char[][] maze = new char[13][17];

	private Hero hero;
	private int pStep;
	

	
	
	public Game() throws IOException{
		setLayout(new GridLayout(13,17));

		
		setBackground(Color.black);
		addKeyListener(this);
//set hero's image
		hero = new Hero(0,0,0,0,false, new ImageIcon("Image/HeroFront.jpg"));
//load board
			loadBoard();
		
			
	}
	
	private void loadBoard() throws IOException{
		int r = 0;

		Scanner input = new Scanner(new File(Maze()));

		while (input.hasNext()){

			maze[r] = input.nextLine().toCharArray();
//set the icons and the images
			for(int c = 0; c < maze[r].length; c++){
				cell[r][c] = new JLabel();
					
				if (maze[r][c] == '-')
					cell[r][c].setIcon(F);
				
				if(maze[r][c]=='+'){
					cell[r][c].setIcon(HF);
					hero.setRow(r);
					hero.setColumn(c);
				}
			


				if (maze[r][c] == 'E')
					cell[r][c].setIcon(BSK);
		
				if (maze[r][c] == 'I')
					cell[r][c].setIcon(BD);

				if (maze[r][c] == 'K')
					cell[r][c].setIcon(BP);

				if (maze[r][c] == 'M')
					cell[r][c].setIcon(BST);
	
				if (maze[r][c] == 'Q')
					cell[r][c].setIcon(F);
	
				if (maze[r][c] == 'U')
					cell[r][c].setIcon(GRS);
				if (maze[r][c] == '1')
					cell[r][c].setIcon(L);
				if (maze[r][c] == '2')
					cell[r][c].setIcon(M);
	
				if (maze[r][c] == '6')
					cell[r][c].setIcon(PS);
				if (maze[r][c] == '7')
					cell[r][c].setIcon(RD);
				if (maze[r][c] == '8')
					cell[r][c].setIcon(RK);
		
				if (maze[r][c] == '<')
					cell[r][c].setIcon(RKG);
	
				if (maze[r][c] == '3')
					cell[r][c].setIcon(RP);
				if (maze[r][c] == '5')
					cell[r][c].setIcon(RS);
				if (maze[r][c] == '0')
					cell[r][c].setIcon(RSN);

				if (maze[r][c] == 'X')
					cell[r][c].setIcon(SD);
				if (maze[r][c] == 'Y')
					cell[r][c].setIcon(SU);
	
				if (maze[r][c] == '!')
					cell[r][c].setIcon(SB);
				if (maze[r][c] == '@')
					cell[r][c].setIcon(SMG);
				if (maze[r][c] == '#')
					cell[r][c].setIcon(SSK);
				if (maze[r][c] == '$')
					cell[r][c].setIcon(T);
				
				if (maze[r][c] == '^')
					cell[r][c].setIcon(YD);
				if (maze[r][c] == 'w')
					cell[r][c].setIcon(W);

				if (maze[r][c] == '*')
					cell[r][c].setIcon(YK);
				if (maze[r][c] == '&')
					cell[r][c].setIcon(YG);
				if (maze[r][c] == '.')
					cell[r][c].setIcon(BK);
				
				add(cell[r][c]);
			}
			r++;	
		}
		input.close();
	}
//choose correct maze to use
	private String Maze() {
		String name = "";
		if(Main.floor == 1)
			name = "Maze";
		if(Main.floor == 2)
			name = "Maze2";
		if(Main.floor == 3)
			name = "Maze3";
		if(Main.floor == 4)
			name = "Maze4";
		if(Main.floor == 5)
			name = "Maze5";
		if(Main.floor == 6)
			name = "Maze6";
		return name;
		
	}

	public void keyPressed(KeyEvent key){
		//if game is not running start the game
		if(gameTimer.isRunning()==false)
			gameTimer.start();
		//if hero not dead than perform the options
		if(hero.getDead()==false){
			int direction = key.getKeyCode()-37;
			
		//if next direction is the stair go up and floor level +1
			 if(direction == 0 && maze[hero.getRow()][hero.getColumn()-1] == 'Y'){
				Main.floor++;
				setVisible(false);
			
				try {
					animateTimer.stop();
					new GAMEGUI();
					setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				//if next direction is the stair go up and floor level +1
			 
			 else if(direction == 0 && maze[hero.getRow()][hero.getColumn()-1] == '6'){
				 setVisible(false);

			 }
			 else if(direction == 1 && maze[hero.getRow()-1][hero.getColumn()] == '6'){
				 setVisible(false);

			 }
			 else if(direction ==2 &&maze[hero.getRow()][hero.getColumn()+1] == '6'){
				 setVisible(false);

			 }
			 else if(direction == 3 &&  maze[hero.getRow()+1][hero.getColumn()] == '6'){
				 setVisible(false);
			 }
			 
			 
			 
			else if(direction == 1 && maze[hero.getRow()-1][hero.getColumn()] == 'Y'){
				Main.floor++;

				setVisible(false);
				
				try {
					animateTimer.stop();
					new GAMEGUI();
					setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				//if next direction is the stair go up and floor level +1

			else if(direction ==2 &&maze[hero.getRow()][hero.getColumn()+1] == 'Y'){
				Main.floor++;

				setVisible(false);
				
				try {
					animateTimer.stop();
					new GAMEGUI();
					setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				//if next direction is the stair go up and floor level +1

			else if(direction == 3 &&  maze[hero.getRow()+1][hero.getColumn()] == 'Y'){
				Main.floor++;

				setVisible(false);
				
				try {
					animateTimer.stop();
					new GAMEGUI();
					setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			////////////////////////////////////
			else if(direction == 0 && maze[hero.getRow()][hero.getColumn()-1] == '6'){
				setVisible(false);}
			 else if(direction == 1 && maze[hero.getRow()-1][hero.getColumn()] == '6'){setVisible(false);}
			 else if(direction ==2 &&maze[hero.getRow()][hero.getColumn()+1] == '6'){setVisible(false);}
			 else if(direction == 3 &&  maze[hero.getRow()+1][hero.getColumn()] == '6'){setVisible(false);}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction == 0 &Main.yellow > 0 && maze[hero.getRow()][hero.getColumn()-1] == '^'){
				hero.setDirection(0);
				Main.yellow --;
				Main.yellowkeys.setText("* "+Main.yellow);
				maze[hero.getRow()][hero.getColumn()-1]='Q';
			}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction == 1 &&Main.yellow > 0 && maze[hero.getRow()-1][hero.getColumn()] == '^'){
				hero.setDirection(1);
				Main.yellow-=1;
				Main.yellowkeys.setText("* "+Main.yellow);
				maze[hero.getRow()-1][hero.getColumn()]='Q';
			}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction ==2 && Main.yellow > 0 && maze[hero.getRow()][hero.getColumn()+1] == '^'){
				hero.setDirection(2);
				Main.yellow --;
				Main.yellowkeys.setText("* "+Main.yellow);
				maze[hero.getRow()][hero.getColumn()+1]='Q';
			}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction == 3 && Main.yellow > 0 && maze[hero.getRow()+1][hero.getColumn()] == '^'){
				hero.setDirection(3);
				Main.yellow --;
				Main.yellowkeys.setText("* "+Main.yellow);
				maze[hero.getRow()+1][hero.getColumn()]='Q';
			}
			 //
			else if(direction == 0 &Main.blue > 0 && maze[hero.getRow()][hero.getColumn()-1] == 'I'){
				hero.setDirection(0);
				Main.blue --;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()][hero.getColumn()-1]='Q';
			}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction == 1 &&Main.blue > 0 && maze[hero.getRow()-1][hero.getColumn()] == 'I'){
				hero.setDirection(1);
				Main.blue-=1;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()-1][hero.getColumn()]='Q';
			}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction ==2 && Main.blue > 0 && maze[hero.getRow()][hero.getColumn()+1] == 'I'){
				hero.setDirection(2);
				Main.blue --;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()][hero.getColumn()+1]='Q';
			}
				//if next direction is the yellow door and you have yellow key then you can pass

			else if(direction == 3 && Main.blue > 0 && maze[hero.getRow()+1][hero.getColumn()] == 'I'){
				hero.setDirection(3);
				Main.blue --;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()+1][hero.getColumn()]='Q';
			}
			else if(direction == 0 &Main.blue > 0 && maze[hero.getRow()][hero.getColumn()-1] == 'I'){
				hero.setDirection(0);
				Main.blue --;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()][hero.getColumn()-1]='Q';
			}
				//if next direction is the blue door and you have blue key then you can pass

			else if(direction == 1 &&Main.blue > 0 && maze[hero.getRow()-1][hero.getColumn()] == 'I'){
				hero.setDirection(1);
				Main.blue-=1;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()-1][hero.getColumn()]='Q';
			}
				//if next direction is the blue door and you have blue key then you can pass

			else if(direction ==2 && Main.blue > 0 && maze[hero.getRow()][hero.getColumn()+1] == 'I'){
				hero.setDirection(2);
				Main.blue --;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()][hero.getColumn()+1]='Q';
			}
				//if next direction is the blue door and you have blue key then you can pass

			else if(direction == 3 && Main.blue > 0 && maze[hero.getRow()+1][hero.getColumn()] == 'I'){
				hero.setDirection(3);
				Main.blue --;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()+1][hero.getColumn()]='Q';
			}//
			 
			 
			 //if next direction is the red door and you have blue red then you can pass
			else if(direction == 0 &Main.red > 0 && maze[hero.getRow()][hero.getColumn()-1] == '8'){
				hero.setDirection(0);
				Main.red --;
				Main.redkeys.setText("* "+Main.red);
				maze[hero.getRow()][hero.getColumn()-1]='Q';
			}
				//if next direction is the red door and you have red key then you can pass

			else if(direction == 1 &&Main.red > 0 && maze[hero.getRow()-1][hero.getColumn()] == '8'){
				hero.setDirection(1);
				Main.red-=1;
				Main.redkeys.setText("* "+Main.red);
				maze[hero.getRow()-1][hero.getColumn()]='Q';
			}
				//if next direction is the red door and you have red key then you can pass

			else if(direction ==2 && Main.red > 0 && maze[hero.getRow()][hero.getColumn()+1] == '8'){
				hero.setDirection(2);
				Main.red --;
				Main.redkeys.setText("* "+Main.red);
				maze[hero.getRow()][hero.getColumn()+1]='Q';
			}
				//if next direction is the red door and you have red key then you can pass

			else if(direction == 3 && Main.red > 0 && maze[hero.getRow()+1][hero.getColumn()] == '8'){
				hero.setDirection(3);
				Main.red --;
				Main.redkeys.setText("* "+Main.red);
				maze[hero.getRow()+1][hero.getColumn()]='Q';
			}
			 
			 //
				//if next direction is not equal to door or wall you can move

			if(direction == 0 && maze[hero.getRow()][hero.getColumn()-1]!= 'w' &&direction == 0 && maze[hero.getRow()][hero.getColumn()-1]!= '^'){
				hero.setDirection(0);

			}
			//if next direction is not equal to door or wall you can move

			else if(direction == 1 && maze[hero.getRow()-1][hero.getColumn()]!= 'w'&&direction == 1 && maze[hero.getRow()-1][hero.getColumn()]!= '^'){
				hero.setDirection(1);

			}
			//if next direction is not equal to door or wall you can move

			else if(direction == 2 && maze[hero.getRow()][hero.getColumn()+1]!= 'w'&&direction == 2 && maze[hero.getRow()][hero.getColumn()+1]!='^'){
				hero.setDirection(2);

			}
			//if next direction is not equal to door or wall you can move

			else if(direction == 3 && maze[hero.getRow()+1][hero.getColumn()]!= 'w'&&direction == 3 && maze[hero.getRow()+1][hero.getColumn()]!= '^'){
				hero.setDirection(3);
			}
			
			
		}
	}

	public void keyReleased(KeyEvent key) {

	}
	
	public void keyTyped(KeyEvent key) {
	
	}
//set icons depends on where the mover goes
	private void performMove(Mover mover){
		if(maze[mover.getRow()][mover.getColumn()] == 'Y')
			cell[mover.getRow()][mover.getColumn()].setIcon(SU);
		if(maze[mover.getRow()][mover.getColumn()] == 'X')
			cell[mover.getRow()][mover.getColumn()].setIcon(SD);
		
		//if next row or column is not equal to the wall you can move
		if(maze[mover.getNextRow()][mover.getNextColumn()]!='w'){
			if(mover == hero)
				animateTimer.start();

			if(maze[mover.getNextRow()][mover.getNextColumn()]!='w')
				cell[mover.getRow()][mover.getColumn()].setIcon(F);
				
				mover.move();
				cell[mover.getRow()][mover.getColumn()].setIcon(HF);
			//if health < 0 dead
			if(collided())
				death();
		}
	}
	
	private boolean collided(){
		
			if (Main.health < 0)
				return true;
		return false;
	}
	//stop game if dead
	private void death(){

		hero.setDead(true);
		stopGame();
	}
// stop game if dead
	private void stopGame(){
		if(hero.getDead())
			gameTimer.stop();
	}


	public void actionPerformed(ActionEvent e) {
//if game timer is hero than move
		if(e.getSource()==gameTimer){
			performMove(hero);

		}
//if animate timer than perform the animation
		else if(e.getSource()==animateTimer){
//perform 3 moves. if pstep = 3 than return it to 0
			animatehero(pStep);
			pStep++;

			if(pStep == 3)
				pStep = 0;
		}
	}

	private void animatehero(int pStep){

		if(pStep == 0){
//set the icon of the hero
			cell[hero.getRow()][hero.getColumn()].setIcon(HF);
			animateTimer.setDelay(0);
		}

		else if(pStep == 1){
//set the place where the hero went to floor
			cell[hero.getRow()][hero.getColumn()].setIcon(F);
		}

		else if(pStep == 2){
			//if hero pick key yellow key ++
			hero.move();
			cell[hero.getRow()][hero.getColumn()].setIcon(HF);
			if(maze[hero.getRow()][hero.getColumn()] == '*'){
				Main.yellow+=1;
				Main.yellowkeys.setText("* "+Main.yellow);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
			}
			//if hero pick blue key blue key ++

			if(maze[hero.getRow()][hero.getColumn()] == '.'){
				Main.blue+=1;
				Main.bluekeys.setText("* "+Main.blue);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//if hero pick red key red key ++

			if(maze[hero.getRow()][hero.getColumn()] == '8'){
				Main.red+=1;
				Main.redkeys.setText("* "+Main.red);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//if hero pick potion health + 250

			if(maze[hero.getRow()][hero.getColumn()] == '3'){
				Main.health +=250;
				Main.healths.setText("Health "+Main.health);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//if hero pick stone attack + 1

			if(maze[hero.getRow()][hero.getColumn()] == '0'){
				Main.attack +=1;
				Main.attacks.setText("Attack "+Main.attack);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//if hero pick stone defense + 1

			if(maze[hero.getRow()][hero.getColumn()] == 'M'){
				Main.defense +=1;
				Main.defenses.setText("Defense "+Main.defense);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//if hero pick big potion health + 250
			if(maze[hero.getRow()][hero.getColumn()] == 'K'){
				Main.health +=200;
				Main.healths.setText("Health "+Main.health);
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class
			if(maze[hero.getRow()][hero.getColumn()] == 'E'){
				Main.mhealth =250;
				Main.mdfs = 10;
				Main.matk = 10;
				name = 'E';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == 'U'){
				Main.mhealth  =100;
				Main.mdfs = 1;
				Main.matk = 1;
				name = 'U';
				try {
					new BattleGUI();
				} catch (IOException e) {
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '5'){
				Main.mhealth  =150;
				Main.mdfs = 2;
				Main.matk = 2;
				name = '5';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '!'){
				Main.mhealth  =200;
				Main.mdfs = 3;
				Main.matk = 3;
				name = '!';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '@'){
				Main.mhealth  =300;
				Main.mdfs = 4;
				Main.matk = 4;
				name = '@';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '2'){
				Main.mhealth  =500;
				Main.mdfs = 7;
				Main.matk = 7;
				name = '2';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '#'){
				Main.mhealth  =350;
				Main.mdfs = 5;
				Main.matk = 5;
				name = '#';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '&'){
				Main.mhealth  =600;
				Main.mdfs = 17;
				Main.matk = 17;
				name = '&';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
			//set monster health defense attack and enter the battle class

			if(maze[hero.getRow()][hero.getColumn()] == '<'){
				Main.mhealth  =1000;
				Main.mdfs = 30;
				Main.matk = 30;
				name = '<';
				try {
					new BattleGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maze[hero.getRow()][hero.getColumn()] = 'Q';
				}
				//monster
			animateTimer.stop();
		}
	}
	
}
