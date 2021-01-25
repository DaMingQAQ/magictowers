
public class DATA {
	private int health = 100;
	private int attack = 10;
	private int defense = 10;
	private int coin = 0;
	private int floor = 1;
	private int yellowkey = 0;
	private int bluekey = 0;
	private int redkey=0;
	
	
	public DATA(int health, int attack, int defense, int coin,int floor,int yellowkey, int bluekey, int redkey) {
		super();
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.coin = coin;
		this.floor = floor;
		this.yellowkey = yellowkey;
		this.bluekey = bluekey;
		this.redkey = redkey;

	}
	public int gethealth() {
		return health;
	}

	public void sethealth(int health) {
		this.health = health;
	}
	public int getfloor() {
		return floor;
	}

	public void setfloor(int floor) {
		this.floor = floor;
	}


	public int getattacj() {
		return attack;
	}

	public void setattack(int attack) {
		this.attack = attack;
	}

	public int getdefense() {
		return defense;
	}

	public void setdefense(int defense) {
		this.defense = defense;
	}

	public int getcoin() {
		return coin;
	}

	public void setcoin(int coin) {
		this.coin = coin;
	}
	
	public int getyellowkey() {
		return yellowkey;
	}

	public void setyellowkey(int yellowkey) {
		this.yellowkey = yellowkey;
	}
	public int getbluekey() {
		return bluekey;
	}

	public void setbluekey(int bluekey) {
		this.bluekey = bluekey;
	}
	public int getredkey() {
		return redkey;
	}

	public void setredkey(int redkey) {
		this.redkey = redkey;
	}
}
