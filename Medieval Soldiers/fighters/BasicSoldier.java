package fighters;

import framework.BattleField;
import framework.Random131;

public class BasicSoldier {
	
	// Initial Constant Variables
	public final static int INITIAL_HEALTH = 10;
	public final static int ARMOR = 20;
	public final static int STRENGTH = 30;
	public final static int SKILL = 40;
	
	public final static int UP = 0;
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int UP_AND_RIGHT = 4;
	public final static int DOWN_AND_RIGHT = 5;
	public final static int DOWN_AND_LEFT = 6;
	public final static int UP_AND_LEFT = 7;
	public final static int NEUTRAL = -1;
	
	// Instance Variables of the Class
	public final BattleField grid; 
	public int row, col; 
	public int health; 
	public final int team; 
	
	// Constructor that initializes all of the variables at the start
	public BasicSoldier(BattleField gridIn, int teamIn, int rowIn, int colIn){
		health = INITIAL_HEALTH;
		grid = gridIn;
		team = teamIn;
		row = rowIn;
		col = colIn;
	}
	
	// Determines whether the soldier can move 
	/* If the soldier can move, then it returns true. 
	* Otherwise it returns false
	*/
	public boolean canMove(){
		// Checks if a place in the grid is empty
		if (grid.get(row-1,col) == BattleField.EMPTY || 
			grid.get(row+1, col) == BattleField.EMPTY || 
			grid.get(row, col-1) == BattleField.EMPTY || 
			grid.get(row, col+1) == BattleField.EMPTY){
			return true;
		}else{ 
			return false;
		}
	}
	
	// Determines the number of enemies in the battlefield
	public int numberOfEnemiesRemaining(){
		int counter = 0; //Counter starts with 0 enemies
		
		for(int BattleRow = 0; BattleRow < grid.getRows(); BattleRow++){
			for(int BattleCol = 0; BattleCol < grid.getCols(); BattleCol++){
				if(team == BattleField.BLUE_TEAM && 
					grid.get(BattleRow, BattleCol) == BattleField.RED_TEAM){
					counter++; // Adds one to counter for every enemy 
				} 
				if (team == BattleField.RED_TEAM && 
					grid.get(BattleRow, BattleCol) == BattleField.BLUE_TEAM){
					counter++;
				}
			}
		}
		return counter;
	}
	
	// Calculates the distance between current position and destination
	public int getDistance(int destinationRow, int destinationCol){
	/*	int Vertical_Moves = col - destinationCol;
		int Horizontal_Moves = row - destinationRow;
		Horizontal_Moves = Math.abs(Horizontal_Moves);
		Vertical_Moves = Math.abs(Vertical_Moves);
		int moves = Horizontal_Moves + Vertical_Moves;
		return moves;
	*/
		int moves = Math.abs(col-destinationCol) + Math.abs(row-destinationRow);
		return moves;
	}
	
	// Determines the direction of motion based on the location of the destination
	public int getDirection(int destinationRow, int destinationCol){
		if (destinationCol == col && destinationRow < row){
			return UP;
		}else if (destinationCol == col && destinationRow > row){
			return DOWN;
		}else if (destinationCol > col && destinationRow == row){ 
			return RIGHT;
		}else if (destinationCol < col && destinationRow == row){
			return LEFT;
		}else if (destinationCol < col && destinationRow > row){
			return DOWN_AND_LEFT;
		}else if (destinationCol > col && destinationRow < row){
			return UP_AND_RIGHT;
		}else if (destinationCol < col && destinationRow < row){
			return UP_AND_LEFT;
		}else if (destinationCol > col && destinationRow > row){
			return DOWN_AND_RIGHT;
		}else{
			return NEUTRAL;
		}
	}	
	
	// Method for getting the Enemy Team
	public int getEnemyTeam(){
		int enemyteam = 0;
		
		if(team == BattleField.BLUE_TEAM){
			enemyteam = BattleField.RED_TEAM;
		}else if(team == BattleField.RED_TEAM){
			enemyteam= BattleField.BLUE_TEAM;
		}
		
		return enemyteam;
	}
	
	// Determines the direction of the nearest friend
	public int getDirectionOfNearestFriend(){
		int distance = 0; // Initial distance is 0
		int ShortDistance = Integer.MAX_VALUE; // Assigns the max integer value 
		int direction = NEUTRAL; // Initial Direction is Neutral but it will change
		for(int BattleRow = 0; BattleRow < grid.getRows(); BattleRow++){
			for(int BattleCol = 0; BattleCol < grid.getCols(); BattleCol++){ 
				if(getDistance(BattleRow,BattleCol) > 0 &&
					grid.get(BattleRow, BattleCol) == team){
					// Assigns direction to a specific location if team member is found
					distance = getDistance(BattleRow,BattleCol);
					
					if(distance <= ShortDistance){
						ShortDistance = distance;
						direction = getDirection(BattleRow, BattleCol); 
					}
				}
			}
		}
		return direction;
	}	
	
	// Determines the number of friends nearby the player
	public int countNearbyFriends(int radius){
		int counter = -1; // Excludes the player from being a friend of themselves
		
		for(int BattleRow = 0; BattleRow < grid.getRows(); BattleRow++){
			for(int BattleCol = 0; BattleCol < grid.getCols(); BattleCol++){
				if(getDistance(BattleRow, BattleCol)<=radius && 
					grid.get(BattleRow, BattleCol)==team){
					counter++; // Adds 1 for every team member found
				}	
			}
		}
		return counter;
	}
	
	// Returns the direction of the nearest Enemy
	public int getDirectionOfNearestEnemy(int radius){
		int EnemyDirection = NEUTRAL; // Initial Direction of Enemy
		int EnemyDistance = 0; // Initial Distance to Enemy
		int ShortDistance = Integer.MAX_VALUE; 
		
		for(int BattleRow = 0; BattleRow < grid.getRows(); BattleRow++){
			for(int BattleCol = 0; BattleCol < grid.getCols(); BattleCol++){
				if (getDistance(BattleRow, BattleCol) <= radius && 
					grid.get(BattleRow, BattleCol) == getEnemyTeam()){			
					// Gets the distance to the enemy within the radius
					EnemyDistance = getDistance(BattleRow, BattleCol);
					
					if(EnemyDistance<=ShortDistance){
						ShortDistance=EnemyDistance;
						EnemyDirection = getDirection(BattleRow,BattleCol);
					}
				}
			}
		}
		return EnemyDirection;
	}
	
	// This method performs a turn for the player using previous methods
	public void performMyTurn(){
		int EnemyTeam;
		
		// Assigns the enemy team to either blue or red team	
		if(team == BattleField.BLUE_TEAM){
			EnemyTeam = BattleField.RED_TEAM; 
		}else{
			EnemyTeam = BattleField.BLUE_TEAM;
		}
		
		/* Invokes the attack method if enemy is found and 
		 * Moves the player if no enemy is near 
		 */ 
		if(grid.get(row-1,col) == EnemyTeam){
			grid.attack(row-1, col);
		}else if(grid.get(row+1,col) == EnemyTeam){
			grid.attack(row+1, col);
		}else if (grid.get(row,col-1) == EnemyTeam){
			grid.attack(row, col-1);
		}else if (grid.get(row,col+1) == EnemyTeam){
			grid.attack(row, col+1);
		}else if (grid.get(row-1,col) == BattleField.EMPTY){ 
			row--;
		}else if (grid.get(row+1,col) == BattleField.EMPTY){
			row++;
		}else if (grid.get(row,col-1) == BattleField.EMPTY){
			col--;
		}else if (grid.get(row, col+1) == BattleField.EMPTY){
			col++;
		}
	}
}
