import javax.swing.ImageIcon;

public class Mover {

	private int row;
	private int column;
	private int dRow;
	private int dColumn;
	private boolean isDead;

	
	public Mover(int row, int column, int dRow, int dColumn, boolean isDead) {
		super();
		this.row = row;
		this.column = column;
		this.dRow = dRow;
		this.dColumn = dColumn;
		this.isDead = isDead;

	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getdRow() {
		return dRow;
	}

	public void setdRow(int dRow) {
		this.dRow = dRow;
	}

	public int getdColumn() {
		return dColumn;
	}

	public void setdColumn(int dColumn) {
		this.dColumn = dColumn;
	}

	public boolean getDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

//set the direction of the hero
	
	public void setDirection(int dir){
		
		dRow = 0;
		dColumn = 0;
		
		if(dir == 0)
			dColumn = -1;
		else if (dir ==1)
			dRow = -1;
		else if (dir ==2)
			dColumn = 1;
		else if (dir ==3)
			dRow = 1;
		
	}
	//return the direction
	public int getDirection(){
		
		if(dRow == 0 && dColumn == -1)
			return 0;
		else if(dRow == -1 && dColumn == 0)
			return 1;
		else if(dRow == 0 && dColumn == 1)
			return 2;
		else 
			return 3;
	}
	//next row of the hero
	public int getNextRow(){
		
		return row + dRow;
		
	}
	//next column of the hero
	public int getNextColumn(){
		
		return column + dColumn;
		
	}
	//move the location of the hero
	public void move(){
		row = row+ dRow;
		column = column + dColumn;
		dRow = 0;
		dColumn = 0;
	}
}