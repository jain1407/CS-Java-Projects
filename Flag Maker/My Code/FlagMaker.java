package studentCode;
import java.awt.Color;
import GridTools.MyGrid;

public class FlagMaker {
	
	public static void drawFlag(MyGrid grid, int countryCode) {
		
	// Country Cases
	if (countryCode==1) {
	horizontalSplit(grid, Color.red, Color.WHITE);
	} else if (countryCode==2) {
	threeSplit(grid, Color.yellow, Color.green, Color.red);
	} else if (countryCode==3) {
	fourSplit(grid, Color.blue, Color.yellow, Color.green);
	} else if (countryCode==4) {
	VerticalSplit(grid, Color.white, Color.red);
	} else if (countryCode==5) {
	TripleVerticalSplit(grid, Color.black, Color.red, Color.green);	
	} else if (countryCode==6) {
	triangle(grid, Color.red, Color.green, Color.blue);
	} else if (countryCode==7) {
	Macedoniaflag(grid, Color.red, Color.orange);
	} else if (countryCode==8) {
	BahamasFlag(grid, Color.black, Color.blue, Color.yellow);
	} else if (countryCode==9) {
	ZimbabweFlag(grid, Color.white, Color.green, Color.yellow, Color.red, 
			Color.black);
	} else {
	errorflag(grid, Color.white);
	}
}
	// Used for Indonesian Flag
	public static void horizontalSplit(MyGrid grid, Color ColorA, Color ColorB)  
	{	
		int height = grid.getHt(); 
		int width = grid.getWd(); 
		
		// Color the Top Half
		if (height % 2 == 0 && height >= 4 && height <= 30) {
			for(int row = 0; row < height/2; row++){
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorA);	
				}
			}
			// Color the Bottom Half
			for (int row = height/2; row < height; row++) {
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for the Lithuanian Flag
	public static void threeSplit(MyGrid grid, Color ColorA, Color ColorB, 
			Color ColorC) 
	{	
		int height = grid.getHt(); 
		int width = grid.getWd(); 
		
		if (height % 3 == 0 && height >= 4 && height <= 30) {
			// Used to color the top-third of the flag
			for(int row = 0; row < height/3; row++){
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorA);	
				}
			}
			// Used to color the middle third of the flag
			for (int row = (height/3); row < height; row++) {
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Used to color the Bottom third of the flag
			for (int row = ((height/3)+(height/3)); row < height; row++) {
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for Rwandian Flag
	public static void fourSplit(MyGrid grid, Color ColorA, Color ColorB,
			Color ColorC) 
	{	
		int height = grid.getHt(); 
		int width = grid.getWd(); 
		
		if (height % 4 == 0 && height >= 4 && height <= 30) {
			// Used to color the first half of the flag
			for(int row = 0; row < height/2; row++){
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorA);	
				}
			}
			// Used to color a fourth of the flag
			for (int row = (height/2); row < height; row++) {
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Used to color the bottom fourth of the flag
			for (int row = ((height/2)+(height/4)); row < height; row++) {
				for(int col = 0; col < width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for Maltan Flag
	public static void VerticalSplit(MyGrid grid, Color ColorA, Color ColorB) 
	{	
		int height = grid.getHt(); 
		int width = grid.getWd(); 
		
		if (height >= 4 && height <= 30) {
			// Used for the first vertical split 
			for(int col = 0; col < width/2; col++){
				for(int row = 0; row < height; row++) {
					grid.setColor(row, col, ColorA);	
				}
			}
			// Used for the second vertical split
			for (int col = width/2; col < width; col++) {
				for(int row = 0; row < height; row++) {
					grid.setColor(row, col, ColorB);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for Afghanistan Flag
	public static void TripleVerticalSplit(MyGrid grid, Color ColorA, 
			Color ColorB, Color ColorC) 
	{	
		int height = grid.getHt(); 
		int width = grid.getWd(); 
		
		if (height % 3 == 0 && height >= 4 && height <= 30) {
			// Used to color the first third vertical split of the flag
			for(int col = 0; col < width/3; col++){
				for(int row = 0; row < height; row++) {
					grid.setColor(row, col, ColorA);	
				}
			}
			// Used to color the middle third vertical of the flag
			for (int col = width/3; col < width; col++) {
				for(int row = 0; row < height; row++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Used to color the last third vertical of the flag
			for (int col = ((width/3)+(width/3)); col < width; col++) {
				for(int row = 0; row < height; row++) {
					grid.setColor(row, col, ColorC);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for Eritrean Flag
	public static void triangle(MyGrid grid, Color ColorA, Color ColorB,
			Color ColorC) {
		
		int height = grid.getHt(); // Height is 5
		int width = grid.getWd();
		
		if (height%2 == 0 && height >= 4 && height <= 30) {
			// This case is used if the height is even 
			// Used to color the upper half of the triangle with width as 4
			for(int row = 0; row<height/2; row++) {
				for(int col = 0; col < ((row+1)*4); col++) {
					grid.setColor(row, col, ColorA);
				}
				// Used to color the lower left triangle with width 4
				for(int col = (4*(row+1)); col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// This is used to print the lower half of the traingle
			for(int row = height/2; row<height; row++) {
				for(int col = 0; col < ((row-height)*(-4)); col++) {
					grid.setColor(row, col, ColorA);
				}
				// This is used to print the lower right triangle 
				for(int col = ((row-height)*(-4)); col < width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
		} else if(height % 2 == 1 && height >= 4 && height <= 30) {
			// This case is used if the height is odd
			// This colors the upper half of the triangle 
			for(int row = 0; row<(height/2); row++) {
				for(int col = 0; col < ((row+1)*4); col++) {
					grid.setColor(row, col, ColorA);
				}
				// This colors the upper right hand triangle 
				for(int col = ((row+1)*4); col < width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// This colors the middle row of the triangle
			for (int row=(height/2); row<((height/2)+1); row++){
				for(int col = 0; col < ((row*4)+2); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// This colors the lower half of the left triangle
			for(int row = ((height/2)+1); row<height; row++) {
				for(int col = 0; col < ((height-row)*(4)); col++) {
					grid.setColor(row, col, ColorA);
				}
				// This colors the lower triangle on the right
				for(int col = ((height-row)*(4)); col < width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for Macedonian Flag
	public static void Macedoniaflag(MyGrid grid, Color ColorA, Color ColorB) {
		int height = grid.getHt();
		int width = grid.getWd();
		
		if (height%2 == 0 && height >= 8 && height<=30) {
			// Background red color
			for(int row = 0; row < height; row++) {
				for(int col = 0; col<width; col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Middle Box 
			for(int row = ((height/2)-2); row<((height/2)+2); row++) {
				for (int col = ((width/2)-4); col < ((width/2)+4); col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Vertical Bar going through the box
			for(int row = 0; row<height; row++) {
				for(int col = ((width/2)-1); col<((width/2)+1); col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Horizontal Bar going through the box
			for(int row = ((height/2)-1); row<((height/2)+1); row++){
				for(int col = 0; col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Downsloping slash with width 2
			for(int row= 0; row<height; row++) {
				for(int col=(2*row); col<((2*row)+2); col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Upsloping slash with width 2
			for (int row = 0; row < height; row++) {
				for(int col = ((2*(height-row))-1); 
						col > ((2*height)-((2*row)+3)); col--) {
					grid.setColor(row, col, ColorB);
				}
			}
		}else {
				errorflag(grid, Color.white);
		}
	}
		
	// Used for The Bahamas Flag
	public static void BahamasFlag(MyGrid grid, Color ColorA, Color ColorB, 
			Color ColorC) {
		int height = grid.getHt();
		int width= grid.getWd();
		
		if (height % 3 == 0 && height %2 != 0 && height >= 4 && height<=30) {
			// Triangle Upper Half
			for (int row = 0; row < ((height/2)+1); row++) {
				for(int col = 0; col<(row+1); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Triangle Lower Half
			for(int row = ((height/2)+1); row<height; row++) {
				for(int col = 0; col<(height-row); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Top third 
			for(int row = 0; row < (height/3); row++) {
				for(int col=row+1; col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Second third (top section) 
			for(int row = (height/3); row < ((height/2)+(height%2)); row++) {
				for(int col=row+1; col<width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
			// Second third (lower section)
			for(int row = ((height/2)+(height%2)); 
					row < ((height/3)+(height/3)); row++) {
				for(int col= (height-row); col<width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
			// Third third 
			for(int row = ((height/3)+(height/3)); row < height; row++) {
				for(int col=(height-row); col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}
	
	// Used for the Zimbabwe Flag
	public static void ZimbabweFlag(MyGrid grid, Color ColorA, Color ColorB, 
			Color ColorC, Color ColorD, Color ColorE) {
		int height = grid.getHt();
		int width = grid.getWd();
		
		if (height % 7 == 0 && height % 2 != 0 && height >=4 && height<=30) {
			// Triangle Upper Half if height is odd
			for (int row = 0; row < ((height/2)+1); row++) {
				for(int col = 0; col<(row+1); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Triangle Lower Half
			for(int row = ((height/2)+1); row<height; row++) {
				for(int col = 0; col<(height-row); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Upper Seventh (1st)
			for (int row = 0; row<(height/7); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Upper seventh (2nd)
			for (int row = (height/7); row<((2*height)/7); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
			// Upper Seventh (3rd)
			for (int row = ((2*height)/7); row<((3*height)/7); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorD);
				}
			}
			// Middle Upper half
			for (int row = ((3*height)/7); row<((height/2)+1); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorE);
				}
			}
			// Middle Lower Half
			for (int row = ((height/2)+1); row<((4*height)/7); row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorE);
				}
			}
			// Lower Seventh (5th)
			for (int row = ((4*height)/7); row<((5*height)/7); row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorD);
				}
			}
			// Lower Seventh (6th)
			for (int row = ((5*height)/7); row<((6*height)/7); row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
			// Lower Seventh (7th)
			for (int row = ((6*height)/7); row<height; row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
		}else if(height % 7 ==0 && height % 2==0 && height >=4 && height<=30) {
			// Triangle upper half if height is even
			for (int row = 0; row < (height/2); row++) {
				for(int col = 0; col<(row+1); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Triangle Lower Half if height is even
			for(int row = (height/2); row<height; row++) {
				for(int col = 0; col<(height-row); col++) {
					grid.setColor(row, col, ColorA);
				}
			}
			// Upper Seventh (1st)
			for (int row = 0; row<(height/7); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
			// Upper seventh (2nd)
			for (int row = (height/7); row<((2*height)/7); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
			// Upper Seventh (3rd)
			for (int row = ((2*height)/7); row<((3*height)/7); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorD);
				}
			}
			// Middle Upper half
			for (int row = ((3*height)/7); row<(height/2); row++) {
				for (int col = (row+1); col<width; col++) {
					grid.setColor(row, col, ColorE);
				}
			}
			// Middle Lower Half
			for (int row = (height/2); row<((4*height)/7); row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorE);
				}
			}
			// Lower Seventh (5th)
			for (int row = ((4*height)/7); row<((5*height)/7); row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorD);
				}
			}
			// Lower Seventh (6th)
			for (int row = ((5*height)/7); row<((6*height)/7); row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorC);
				}
			}
			// Lower Seventh (7th)
			for (int row = ((6*height)/7); row<height; row++) {
				for (int col = (height-row); col<width; col++) {
					grid.setColor(row, col, ColorB);
				}
			}
		}else {
			errorflag(grid, Color.white);
		}
	}

	// This is error flag
	public static void errorflag(MyGrid grid, Color ColorA) {
		int height = grid.getHt(); 
		int width = grid.getWd();
		
		for (int row = 0; row<height; row++) {
			for(int col = 0; col<width; col++) {
				grid.setColor(row, col, ColorA);
			}
		}
		
		grid.setColor(0, 0, Color.red);
		grid.setColor(--height, 0, Color.blue);
		grid.setColor(0, --width, Color.yellow);
		grid.setColor(height--, width--, Color.green);
	}

}