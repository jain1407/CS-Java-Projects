import java.util.Scanner;

public class OriolesBaseball 
{
	public static void main(String[] args) 
	{
		System.out.println("Type 1 to enter a number or 2 to enter a name: ");
		Scanner scan = new Scanner(System.in); 
		int choice = scan.nextInt();
		
		int playernumber; String playeranswer; 
		if (choice==1) 
		{
			System.out.println("Enter Player number: ");
			playernumber = scan.nextInt(); //playernumber represents an integer input from the user
			
			if (playernumber==10||playernumber==16||playernumber==19||playernumber==36) 
			{
				System.out.println("Which player wears number " + playernumber + " on his jersey?");
				playeranswer = scan.next(); //playeranswer represents a string input from user
				
				if (playeranswer.equals("Jones")&&playernumber==10) { 
					System.out.println("Correct!");		
				}else if(playeranswer.equals("Mancini")&&playernumber==16) { 
					System.out.println("Correct!");
				}else if (playeranswer.equals("Joseph")&&playernumber==36) { 
					System.out.println("Correct!");
				}else if (playeranswer.equals("Davis")&&playernumber==19) { 
					System.out.println("Correct!");
				}else {System.out.println("Incorrect!");} 
				// Another way to do them would have been more nested if loops but this is efficient
				scan.close();
			}else {System.out.println("Invalid choice.");}
		}else  
		{ // Else loop for choice being equal to 2	
			System.out.println("Choose a name: ");
			playeranswer = scan.next();
			
			if (playeranswer.equals("Jones")||playeranswer.equals("Mancini")||playeranswer.equals("Joseph")||playeranswer.equals("Davis")) 
			{ 
				
				System.out.println("What number does " + playeranswer + " wear?");
				playernumber = scan.nextInt();
				
				if (playeranswer.equals("Jones")&&playernumber==10) 
				{System.out.println("Correct!");
				}else if (playeranswer.equals("Mancini")&&playernumber==16)
				{System.out.println("Correct!");	
				}else if (playeranswer.equals("Joseph")&&playernumber==36) 
				{System.out.println("Correct!");
				}else if (playeranswer.equals("Davis")&&playernumber==19) 
				{System.out.println("Correct!");
				}else {System.out.println("Incorrect!");}
				scan.close();
			}else {
				System.out.println("Invalid Choice.");
			}
		} scan.close();
	}
}
